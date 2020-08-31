import java.util.*;
public class ques6
{
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      System.out.println("Input number of which you want the Hailstone sequence of");
      int x =  in.nextInt();
      System.out.println("Hailstone sequence: " + x );
      int steps = 0;
      if (x == 0){
          System.out.println(x);
        }
      while (x!= 1 && x<Integer.MAX_VALUE){
      if (x % 2 == 0){
          x /= 2;
        }else{
            x = (3*x + 1);
        }
        System.out.println(x);
         steps++;
    }
    if (x==1){
        System.out.println("No of steps: " + steps);
    }
    else if(x == Integer.MAX_VALUE || x <0) {
        System.out.println("Integer overflow");
    }
}
}
