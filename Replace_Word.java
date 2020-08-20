/*Question 2 - write a program to read a paragram from the user and 
replace specific words mentioned in a vector*/


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ReplaceWord
{
   static String replaceWords(String a, List<String> words){
       for (String i : words){
           Pattern p = Pattern.compile(i,Pattern.CASE_INSENSITIVE);
           Matcher m = p.matcher(a); //all matches of words in para
           StringBuilder sb = new StringBuilder(); //is mutuable allows changes
           if (m.find()){
               sb.append(i.charAt(0));
               for(int j=1;j<i.length();j++)
                   sb.append("*");
        }
        a = m.replaceAll(sb.toString()); //replace every instance
    }
    return a;
}
public static void main(String[] args){
       Scanner in=new Scanner(System.in);
       System.out.println("Enter Paragraph: ");
       String a = in.nextLine();
       System.out.println("Input string of all words to be replaced seperated by a comma");
       String hi = in.nextLine();
       String[] items = hi.split(",");
       List<String> words = Arrays.asList(items);
       System.out.println(replaceWords(a,words));
    }
}
