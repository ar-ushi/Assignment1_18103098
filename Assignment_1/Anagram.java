/*Question 4 - Check if two strings/numbers are anagrams of each other*/


import java.util.*;

public class Anagram
{
    static boolean isAnagram(String a,String s){
        if (a.length() != s.length()){
            return false;
        }
        char[] c = a.toCharArray(); //array of character in string
        char[] d = s.toCharArray();
        Arrays.sort(c);
        Arrays.sort(d);
        return Arrays.equals(c,d);
}
public static void main(String[] args){
       
       Scanner in=new Scanner(System.in);
       System.out.println("Enter First Input: ");
       String a = "" +in.next();
       System.out.println("Enter Second Input: ");
       String s = "" + in.next();
       if (isAnagram(a.toLowerCase(),s.toLowerCase()))
       System.out.println("Inputs are anagram are each of other");
       else
       System.out.println("Inputs are not anagram are each of other");
    }
}
