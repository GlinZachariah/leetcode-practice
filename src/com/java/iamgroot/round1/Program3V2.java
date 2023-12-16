package com.java.iamgroot.round1;

import com.java.iamgroot.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Program3V2 {

// Using loops alone
    public int lengthOfLongestSubstring(String s) {
        String longestString = "";
        List<String> allSubString = new ArrayList<>();

        // iterate through the string starting with left =0;
        int idx = 0;
        int left = 0;
        int right = 0;
        Set<Character> duplicateChars = new HashSet<>();
        while (idx < s.length()) {
            while (right < s.length() && !duplicateChars.contains(s.charAt(right))) {
                duplicateChars.add(s.charAt(right));
                right += 1;
            }
            if (longestString.length() < s.substring(left, right).length()) {
                longestString = s.substring(left, right);

            }
            allSubString.add(s.substring(left, right));
            if (right == s.length()) {
                break;
            }
            int commonPoint = s.substring(left, right).indexOf(s.charAt(right));
            for (char ch : s.substring(left, left + commonPoint).toCharArray()) {
                duplicateChars.remove(ch);
            }
            left = left + commonPoint + 1;
            right += 1;
            idx = left;
        }
        // find first char that matches the duplicate
        // find the position of duplicate in the existing substring then take the remaining right side of the substring
//        System.out.println(allSubString);
        return longestString.length();
    }

    public static void main(String[] args) {
        Program3V2 program3 = new Program3V2();
        Assert.equals(program3.lengthOfLongestSubstring("abcabcbb"), 3, "Test Case 1");
        Assert.equals(program3.lengthOfLongestSubstring("bbbbb"), 1, "Test Case 2");
        Assert.equals(program3.lengthOfLongestSubstring("pwwkew"), 3, "Test Case 3");
        Assert.equals(program3.lengthOfLongestSubstring("au"), 2, "Test Case 4");
        Assert.equals(program3.lengthOfLongestSubstring("ciridmtxsgaryv"), 11, "Test Case 5");
        Assert.equals(program3.lengthOfLongestSubstring("bziuwnklhqzrxnb"), 11, "Test Case 6");
    }
}
