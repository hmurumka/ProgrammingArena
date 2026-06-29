package practice.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        
        List<List<String>> l = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        l.stream().toList().forEach(System.out::println);
    }

    private static java.util.List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> result = new ArrayList<>();
        if(Objects.isNull(strs) || strs.length == 0)
            return result;
        else{
            Map<Integer, List<String>> map = new HashMap<>();
            List<String> lStr;
            for (String str : strs) {
                
                int charSum = str.chars().sum();
                if(!map.containsKey(charSum))
                {
                    lStr = new ArrayList<>();
                    lStr.add(str);
                    map.put(charSum, lStr);
                }
                else
                    map.get(charSum).add(str);
                
            }

            return map.values().stream().toList();
        }
    }

}
