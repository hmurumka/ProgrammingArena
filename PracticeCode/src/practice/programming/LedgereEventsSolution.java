package practice.programming;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

public class LedgereEventsSolution {

    public static void main(String[] args) {
        Account a = new Account();
        a.read(null, null);
        a.isProcessable = true;
        a.process();
        a.printFinalStatus();
    }



    ////////////////////////////////////////////////////////////////////

    private interface ReadableEvents {
        public void read(InputStream stream, Collection c);
    }

    private interface AccountProcessor {

        public void process();

        public boolean isProcessable();
    }

    private static class Account implements ReadableEvents, AccountProcessor {
        private double clearedAmount = 0;
        private double suspendedAmount = 0;
        private boolean isProcessable = false;

        // ProductId and Events
        Map<String, Set<LedgereEvent>> events;
        InputStream stream;

        public Account()
        {
            this.events = new HashMap<>();
            this.stream = null;
        }

        public void printFinalStatus() {
            System.out.println("Cleared Amount : [" + this.clearedAmount + "]");
            System.out.println("Suspended Amount : [" + this.suspendedAmount + "]");
        }

        @Override
        public void read(InputStream stream, Collection c) {
            // read the events from given stream and fill it in Collection.
            // for now using dummy events
            getDummyEvents().stream().forEach(e -> {
                if (!events.containsKey(e.reference)) {
                    Set<LedgereEvent> s = new TreeSet<>();
                    s.add(e);
                    events.put(e.reference, s);
                } else {
                    events.get(e.reference).add(e);
                }
            });
        }

    @Override
    public void process() {

        List<ReferenceLedgere> refLedgereList = new ArrayList<>();
        for(Entry entry : events.entrySet())
        {
            ReferenceLedgere o = new ReferenceLedgere();
            o.calculate((Set<LedgereEvent>)entry.getValue());
            refLedgereList.add(o);
        }

        for(ReferenceLedgere l : refLedgereList)
        {
            this.clearedAmount += l.clearedAmount;
            this.suspendedAmount += l.suspendedAmount;
        }

    }

        @Override
        public boolean isProcessable() {
            return this.isProcessable;
        }

    }

    private static class ReferenceLedgere{
        private String reference;
        private double clearedAmount = 0;
        private double suspendedAmount = 0;

        public void calculate(Set<LedgereEvent> set)
        {
            for(LedgereEvent e : set){
                this.reference = e.reference;

                if(e.status == STATUS.REFUND)
                {
                    if(e.amount <= clearedAmount)
                        clearedAmount -= e.amount;
                    else
                        suspendedAmount += e.amount;
                }   

                if(e.status == STATUS.CHARGE)
                    clearedAmount += e.amount;

            }
                
        }

        @Override
        public String toString() {
            return "Reference [" + this.reference + "] Cleared_Amount [" 
            + this.clearedAmount 
            + "] Suspended_Amount [" + this.suspendedAmount + "]";
        }
    }

    private static class LedgereEvent implements Comparable {
        private int eventId;
        private STATUS status;
        private double amount;
        private String reference;

        public LedgereEvent(int id, STATUS sts, double amt, String ref) {
            this.amount = amt;
            this.eventId = id;
            this.status = sts;
            this.reference = ref;
        }

        @Override
        public boolean equals(Object obj) {
            LedgereEvent evt = (LedgereEvent) obj;
            return ((this.eventId == evt.eventId) && (this.reference == evt.reference));

        }

        @Override
        public int hashCode() {
            return this.eventId;
        }

        @Override
        public int compareTo(Object o) {
            if(this.eventId < ((LedgereEvent)o).eventId)
                return -1;
            else if(this.eventId == ((LedgereEvent)o).eventId)
                return 0;
            else
                return 1;
        }
    }

    private enum STATUS {
        CHARGE,
        REFUND
    }

    // DUMMY EVENTS

    public static List<LedgereEvent> getDummyEvents() {
        // check for inputstream and reads all events and arrange it in events map.
        List<LedgereEvent> ledgere = new ArrayList<>();

        ledgere.add(new LedgereEvent(1, STATUS.CHARGE, 100, "PROD_A"));
        ledgere.add(new LedgereEvent(1, STATUS.CHARGE, 200, "PROD_B"));
        ledgere.add(new LedgereEvent(1, STATUS.CHARGE, 300, "PROD_C"));
        ledgere.add(new LedgereEvent(2, STATUS.REFUND, 50, "PROD_A"));
        ledgere.add(new LedgereEvent(2, STATUS.REFUND, 100, "PROD_B"));
        ledgere.add(new LedgereEvent(2, STATUS.REFUND, 300, "PROD_C"));
        ledgere.add(new LedgereEvent(3, STATUS.REFUND, 10, "PROD_A"));
        ledgere.add(new LedgereEvent(3, STATUS.CHARGE, 100, "PROD_B"));
        ledgere.add(new LedgereEvent(3, STATUS.REFUND, 100, "PROD_C"));

        return ledgere;
    }
}
