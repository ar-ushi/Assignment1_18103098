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


Potential Solution: 
*/

import java.util.*;
class Solution { 
public static void main(String[] args) 
{ 
int n,m; 
Scanner in = new Scanner(System.in);
n = in.nextInt();
m = in.nextInt();
in.nextLine();
String[] crops = new String[n]; 
for (int i=0;i<n;i++){ 
crops[i]=in.nextLine().trim 
}
System.out.print(replant(crops) 
} 




