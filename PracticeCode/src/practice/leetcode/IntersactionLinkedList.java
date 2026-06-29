package practice.leetcode;

/**
 * Intersection of Two Linked Lists LeetCode - 160
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * Given the heads of two singly linked-lists headA and headB, return the node
 * at which the two lists intersect. If the two linked lists have no
 * intersection at all, return null.
 * 
 * For example, the following two linked lists begin to intersect at node c1:
 * 
 * 
 * The test cases are generated such that there are no cycles anywhere in the
 * entire linked structure.
 * 
 * Note that the linked lists must retain their original structure after the
 * function returns.
 * 
 * Custom Judge:
 * 
 * The inputs to the judge are given as follows (your program is not given these
 * inputs):
 * 
 * intersectVal - The value of the node where the intersection occurs. This is 0
 * if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head)
 * to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head)
 * to get to the intersected node.
 * The judge will then create the linked structure based on these inputs and
 * pass the two heads, headA and headB to your program. If you correctly return
 * the intersected node, then your solution will be accepted.
 */
public class IntersactionLinkedList {

    public static void main(String[] args) {
        IntersactionLinkedList l = new IntersactionLinkedList();
        ListNode listA = l.createSampleList(new int[]{1, 2, 4, 8, 6, 9});
        ListNode listB = l.createSampleList(new int[]{7, 5, 3, 8, 6, 9});

        l.createIntersection(listA, listB, 8);

        System.out.println(l.getIntersectionNode(listA, listB).val);
    }

    /**private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // find the length of ListA and ListB
        ListNode a = headA, b = headB;
        int listASize = 0, listBSize = 0;
        while (a != null) {
            a = a.next;
            listASize++;
        }

        while (b != null) {
            b = b.next;
            listBSize++;
        }

        a = headA;
        b = headB;
        int diff = Math.abs(listASize - listBSize);
        if (listASize > listBSize) {
            for (int i = 0; i < diff; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                b = b.next;
            }
        }

        while (a != b) {
            a = a.next;
            b = b.next;
        }

        return a;

    }**/

    // find cycle
    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;

        while(a != b)
        {
            if(a.next == null){
                a = headB;
                continue;
            }
                
            if(b.next == null){
                b = headA;
                continue;
            }
                
            a = a.next;
            b = b.next;

        }

        return a;
    }

    private ListNode createSampleList(int[] a) {
        ListNode head = new ListNode(a[0], null);
        ListNode current = head;
        for (int i = 1; i < a.length; i++) {
            current.next = new ListNode(a[i], null);
            current = current.next;
        }
    
        return head;
    }

    private void createIntersection(ListNode headA, ListNode headB, int intersection)
    {
        ListNode a = headA, b = headB;
        while(a != null)
        {
            if(a.val == intersection)
                break;
            a = a.next;
        }

        while(b.next != null)
        {
            if(b.next.val == intersection)
            {
                b.next = a;
                break;
            }
            b = b.next;
        }
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
