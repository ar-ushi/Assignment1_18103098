import java.util.*;
public class ques6
{
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      System.out.println("Input number of which you want the Hailstone sequence of");
      int num =  in.nextInt();
      System.out.println("Hailstone sequence: " + x );
      int steps = 0;
      if (num == 0){
          System.out.println(x);
        }
      while (num != 1 && x<Integer.MAX_VALUE){
      if (num % 2 == 0){
          num /= 2;
        }else{
            num = (3*num + 1);
        }
        System.out.println(num);
         steps++;
    }
    if (num==1){
        System.out.println("No of steps: " + steps);
    }
    else if(num == Integer.MAX_VALUE || num  <0) {
        System.out.println("Integer overflow");
    }
}
}
