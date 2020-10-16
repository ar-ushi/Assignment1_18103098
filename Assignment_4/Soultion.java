/
/* 
-- The farm is in the form of an  N X M grid with each cell in the grid being a square plot.
-- The farmer has 26 varieties of crops that he can plant.
-- In each row, there must be at least 2 different varieties of crops (any number  of crops can be used in a column)
-- No two nearby (Top, bottom, left, right) plots can have  the same variety of crops
-- column)No two nearby (Top, bottom, left, right) plots can have  the same variety of crops. 
-- Given the current state of the farm, find the minimum number  of plots that have to replant with a different crop so that the above conditions are satisfied.

Input 
4 
4 
acaa dddd bbbb ccce 

Output
6

Potential Solution: using matrix, start from cell (0,0) - check if same char present in down or left cell - yes, then change this cell. Eliminates need of checking up/right
 */

import java.util.*;
class Solution { 
    private static final String alphabets = "abcdefghijklmnopqrstuvwxyz";
    private static int N = 0;
    private static int M = 0;
    private static int min_replant = Integer.MAX_VALUE;

    public static void main(String[] args) 
    { 
        int n,m; 
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        in.nextLine();
        String[] crops = new String[n]; 
        for (int i=0;i<n;i++){ 
            crops[i]=in.nextLine().trim();
        }
        N = n;
        M = m;
        System.out.println(replant(crops));
    }

    public static int replant(String[] crops) {
        // Write your code here
        // Return the number of replanted crops
        helper(crops, 0, 0, 0);

        return mini_replant;

    }

    private static void helper(String[] crops, int x, int y, int replace){
        if (checkValidity(x,y)){ //if out of range between 0:N-1 or 0:m-1 then error
            y = 0;
            x += 1;
            if (checkValidity(x,y)){
                min_replant = Math.min(replace, min_replant); //replace keeps count of how many times we had to replace crop to fit conditoon

            }
        }
        //checking conditions - if doesn't fulfil, run replace.
        if ((!checkValidity(x-1,y) && crops[x].charAt(y) == crops[x-1].charAt(y)) || (!checkValidity(x,y-1) &&  crops[x].charAt(y) == crops[x].charAt(y-1))){
            helper_replace(crops, x,y,replace);
        }else if ((!checkValidity(x+1,y) && crops[x].charAt(y) == crops[x+1].charAt(y)) || (!checkValidity(x,y+1) &&  crops[x].charAt(y) == crops[x].charAt(y+1))){
            helper_replace(crops,x,y+1,replace);
            helper_replace(crops,x,y,replace);
        }else{
            helper_replace(crops,x,y+1,replace);

        }
    }

    private static boolean checkValidity(int a, int b){
        return (a<0 || a>= N|| b<0|| b>=M);
    }

    private static void helper_replace(String[] crops, int x, int y, int replace){
        int ch = -1;
        for (int i = 0; i<26; i++){
            if ((!checkValidity(x-1,y) && crops[x-1].charAt(y) == alphabets.charAt(i))
            || (!checkValidity(x+1,y) && crops[x+1].charAt(y) == alphabets.charAt(i))
            || (!checkValidity(x,y-1) && crops[x].charAt(y-1) == alphabets.charAt(i))
            || (!checkValidity(x,y+1) && crops[x].charAt(y+1) == alphabets.charAt(i)))
            { //all conditons check
                continue;
            }
            ch = i;
            break;

        }
        if (ch == -1){
            return; //no replacements made
        }

        String s1 = crops[x].substring(0, y) + alphabets.charAt(ch) + crops[x].substring(y + 1);
        String s2 = crops[x];
        crops[x] = s1;
        helper(crops,x,y+1,replace +1);
        crops[x] = s2;

    }

} 