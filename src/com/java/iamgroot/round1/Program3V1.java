package com.java.iamgroot.round1;

import com.java.iamgroot.Assert;

import java.util.HashSet;
import java.util.Set;

public class Program3V1 {

    public static String expandStringWithoutDuplicate(String s, int left, int right,Set<Character> duplicate){

        if (duplicate == null){
            duplicate = new HashSet<>();
            for (char ch:s.substring(left,right).toCharArray()){
                duplicate.add(ch);
            }
        }
        boolean isChanged = false;
        if (left > 0 && !duplicate.contains(s.charAt(left-1))){
            isChanged = true;
            duplicate.add(s.charAt(left-1));
            left -= 1;
        }
        if (right+1 < s.length() && !duplicate.contains(s.charAt(right))){
            isChanged = true;
            duplicate.add(s.charAt(right));
            right+=1;
        }
        if (isChanged){
            return expandStringWithoutDuplicate(s,left,right, new HashSet<>(duplicate));
        }else{
            return s.substring(left,right);
        }
    }



    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        for (int l=0;l<s.length();l++){
            String result = expandStringWithoutDuplicate(s,l,l+1,null);
            int size = result.length();
            if(size > longest){
                longest = size;
            }
        }
        System.out.println(longest);
        return longest;
    }

    public static void main(String[] args) {
        Program3V1 program3 = new Program3V1();
        Assert.equals(program3.lengthOfLongestSubstring("abcabcbb"),3,"Test Case 1");
        Assert.equals(program3.lengthOfLongestSubstring("bbbbb"),1,"Test Case 2");
        Assert.equals(program3.lengthOfLongestSubstring("pwwkew"),3,"Test Case 3");
    }
}
