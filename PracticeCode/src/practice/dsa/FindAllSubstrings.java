package practice.dsa;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubstrings {
    public static void main(String[] args) {

        List<String> results = new ArrayList<>();
        allSubstrigs("", "ABCD", results);
        System.out.println(results);
        
    }

    private static void allSubstrigs(String current, String input, List<String> set)
    {
        if(input.isEmpty())
        {
            if(!current.isEmpty())
                set.add(current);
            return;
        }
            

        // include the first cahacter
        allSubstrigs(current + input.charAt(0), 
        input.substring(1), set);

        // exclude the first character
        allSubstrigs(current, input.substring(1), set);
    }
}
