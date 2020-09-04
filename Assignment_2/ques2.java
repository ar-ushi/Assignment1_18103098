import java.util.*;
public class ques2{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = in.nextInt();
        int[] arr = new int[n];
        int count = 0;
        System.out.println("Enter array elements (in range 0-20): ");
        int[] freq = new int[21];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
            if(arr[i]<0 || arr[i]>20){
                count ++;
            }
            else{
                freq[arr[i]]++;
            }
        }
        int x = arr.length - count;
        int b[] = new int[arr.length - count];
        int j=0;
        for(int i=0;i<21;i++){
            for(int k=0;k<freq[i];k++){
                b[j] = i;
                j++;
            }
        }
        System.out.print("Sorted array: ");
        for(int i=0;i<x;i++){
            System.out.print(b[i]+" ");
        }
    }
}