

import java.util.*;
public class ques5
{
    private static void union_array(int[] universe, int[] a, int[] b, int total)
    {
        int[] ans = new int[total];
        for(int i=0; i<total; i++)
        {
            if(a[i] == 1 || b[i] == 1)
                ans[i] = 1;
        }
        System.out.print("Union of the sets using arrays: ");
        for(int i=0; i<total; i++)
        {
            if(ans[i] == 1)
                System.out.print(i + " ");
        }
    }

    private static void intersection_array(int[] universe, int[] a, int[] b, int total)
    {
        int[] ans = new int[total];
        for(int i=0; i<total; i++)
        {
            if(a[i] == 1 && b[i] == 1)
                ans[i] = 1;
        }
        System.out.print("Intersection of the sets using arrays: ");
        for(int i=0; i<total; i++)
        {
            if(ans[i] == 1)
                System.out.print(i + " ");
        }
    }

    private static void complement_array(int[] universe, int[] a, int total)
    {
        int[] ans = new int[total];
        for(int i=0; i<total; i++)
        {
            if(a[i] == 0)
                ans[i] = 1;
        }
        System.out.print("Complement of the set using arrays: ");
        for(int i=0; i<total; i++)
        {
            if(ans[i] == 1)
                System.out.print(i + " ");
        }
    }

    public static void main(String[] args)
    {
        int total = 11; //detemines the size of the universe

        System.out.println("The Universe is defined as: [0,1,2,3,4,5,6,7,8,9,10]");
        int[] universe = new int[total];
        for(int i=0; i<total; i++)
            universe[i] = 1;

        Set<Integer> set_u = new HashSet<Integer>();
        for(int i=0; i<total; i++)
            set_u.add(i);

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the size of set A: ");
        int m = in.nextInt();
        int[] a = new int[total];
        Set<Integer> set_a = new HashSet<Integer>();
        System.out.println("Enter the element of set A: ");
        for(int i=0; i<m; i++)
        {
            int num = in.nextInt();
            a[num] = 1;
            set_a.add(num);
        }

        System.out.println("Enter the size of set B: ");
        int n = in.nextInt();
        int[] b = new int[total];
        Set<Integer> set_b = new HashSet<Integer>();
        System.out.println("Enter the element of set B: ");
        for(int i=0; i<n; i++)
        {
            int num = in.nextInt();
            b[num] = 1;
            set_b.add(num);
        }

        //Union using array
        long startTime = System.nanoTime();
        union_array(universe, a, b, total);
        System.out.println();
        long stopTime = System.nanoTime();
        long timeElapsed1 = (stopTime - startTime)/1000;

        //Union using set
        startTime = System.nanoTime();
        Set<Integer> union = new HashSet<Integer>(set_a);
        union.addAll(set_b);
        System.out.println("Union of the sets using Set: " + union);
        stopTime = System.nanoTime();
        long timeElapsed2 = (stopTime - startTime)/1000;

        //Printing the time
        System.out.println("The time taken for union operation using Arrays is: " + timeElapsed1 + " ms");
        System.out.println("The time taken for union operation using Sets is: " + timeElapsed2 + " ms");
        System.out.println("-------------------------------------------------------------------------");

        //Intersection using arrays
        startTime = System.nanoTime();
        intersection_array(universe, a, b, total);
        System.out.println();
        stopTime = System.nanoTime();
        timeElapsed1 = (stopTime - startTime)/1000;

        //Intersection using set
        startTime = System.nanoTime();
        Set<Integer> intersection = new HashSet<Integer>(set_a);
        intersection.retainAll(set_b);
        System.out.println("Intersection of the sets using Set: " + intersection);
        stopTime = System.nanoTime();
        timeElapsed2 = (stopTime - startTime)/1000;

        //Printing the time
        System.out.println("The time taken for intersection operation using Arrays is: " + timeElapsed1 + " ms");
        System.out.println("The time taken for intersection operation using Sets is: " + timeElapsed2 + " ms");

        //Complement using array
        startTime = System.nanoTime();
        complement_array(universe, a, total);
        System.out.println();
        stopTime = System.nanoTime();
        timeElapsed1 = (stopTime - startTime)/1000;

        //Complement using set
        startTime = System.nanoTime();
        Set<Integer> compliment = new HashSet<Integer>(set_u);
        compliment.removeAll(set_a);
        System.out.println("Complement of the set using Set: " + compliment);
        stopTime = System.nanoTime();
        timeElapsed2 = (stopTime - startTime)/1000;

        //Printing the time
        System.out.println("The time taken for complement operation using Arrays is: " + timeElapsed1 + " ms");
        System.out.println("The time taken for complement operation using Sets is: " + timeElapsed2 + " ms");
    }
}