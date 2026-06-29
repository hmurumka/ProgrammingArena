package practice.javastream;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Change the string with all first word as capital letter
hello, how are you. Hope you are doing great. --> Hello, How Are You. Hope You Are Doing Great.
*/
public class CapitalFirstLetter {
    public static void main(String[] args) {
        CapitalFirstLetter o = new CapitalFirstLetter();
        System.out.println(o.change("hello, how are you. Hope you are doing great."));
    }


    private String change(String s)
    {
        if(Objects.isNull(s) || s.isBlank() || s.isEmpty())
            return s;
        else{
            
            return Stream.of(s.split(" "))
            .map(w -> w.substring(0,1).toUpperCase() + w.substring(1))
            .collect(Collectors.joining(" "));
        }
    }
}
