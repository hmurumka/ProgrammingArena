package practice.leetcode;

import java.util.Stack;

/*
remove all adjacent duplicates
Given a string s, remove all its adjacent duplicate characters recursively.

Examples: 

Input: s = "geeksforgeek"
Output: "gksforgk"
Explanation: g(ee)ksforg(ee)k -> gksforgk
 */
public class RemoveAllAdjacent {
    
    public static void main(String[] args) {
     RemoveAllAdjacent o = new RemoveAllAdjacent();
     System.out.println(o.findString("geeksforgeek"));
    }

    private String findString(String s)
    {
        Stack<Character> st = new Stack<>();
        String b = "";
        for (Character character : s.toCharArray()) {

            if(!st.empty() && st.peek() == character)
            {
                st.pop(); // remove 
            }else
                st.push(character);
        }
        
        while(!st.empty())
        {
            b = st.pop() + b;
        }

        return b;
    }

}


