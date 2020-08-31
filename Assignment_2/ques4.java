  
/*  Question Logic Explained : 
sum of n natural numbers :  n(n+1)/2 = (n^2 + n)/2
square of n = n^2 
equating on each side => n = n^2
hence sum of n natural numbers can never be equal to the square
unless you are at 0 or 1 and our lowerbound starts from 1 hence answer 1
     */

public class ques4{
    public static void main(String[] args){
        int n=1;
        int sum = 1;
        while(n<Integer.MAX_VALUE){
            if(sum==n*n){
                System.out.println("Ans: "+n);
            }
            n+=1;
            sum+=n;
        }
    }
}