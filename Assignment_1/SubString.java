//Question 1 - Find substring of a string if order is irrelevant 


import java.util.*;
public class SubString{

    public static boolean next_permutations(char[] substr,int n) {

        int index = -1;
        for(int i=n-2;i>=0;--i) {
            if(substr[i] < substr[i+1])
            {
                index = i;
                break;
            }
        }
        if(index ==-1) 
        return false;

        int start=index+1, last = n-1;
        while(start < last) {
            char temp = substr[start];
            substr[start] = substr[last];
            substr[last] = temp;
            last--;
            start++;
        }

        for(int i=index+1;i<n;++i)
        {
            if(substr[index]<substr[i])
            {
                char temp = substr[index];
                substr[index] = substr[i];
                substr[i] = temp;
                break;
            }
        }
        return true;
    }

    public static int subStringSearch(String s,char[] substr,int n) {

        int ans=0;
        for(int i=0;i<s.length()-n+1;++i)
        {
            boolean visited = true;
            for(int j=0;j<n;++j) {
                if(s.charAt(i+j) != substr[j]) {
                   visited = false;
                    break;
                }
            }
            if(visited) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the String: ");
        String s = in.next();
        System.out.print("Enter the Sub-String: ");
        String sub = in.next();
        int n = sub.length();

        char[] substr = sub.toCharArray();
        Arrays.sort(substr);

        int ans = 0;

        do {

            ans += subStringSearch(s,substr,n);

        } while(next_permutations(substr,n));

        System.out.println("The substring occurs a total of " + ans + "times");
    }
}
