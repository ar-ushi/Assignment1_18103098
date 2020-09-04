//Write a program to sort strings(without using library function)

import java.util.Scanner;
public class ques3{
    public static String SortingString(String s2){
        char chars[] =  s2.toCharArray();
        for(int i=0;i<chars.length;i++){
            for(int j=i;j<chars.length;j++){
                if(j>i){
                    if((int)chars[i] > (int)chars[j]){ //implementing basic swapping if ascii larger 
                        char c = chars[i];
                        chars[i] = chars[j];
                        chars[j] = c;
                    }
                }
            }
        }
        String s = "";
        for (int i = 0; i < chars.length; i++) {
            s+=chars[i];
        }
        return s;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string : ");
        String s1 = in.nextLine();
        String s2 = SortingString(s1);
        System.out.println("Sorted String is: "+ s2);
    }
}