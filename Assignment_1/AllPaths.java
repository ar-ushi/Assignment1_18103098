//Question 3 - Extended -- Find All Paths between two nodes. Calculated via DFS. Uses same class and inputs as Shortest Path.
import java.util.*;

public class AllPaths{

    public static void main(String[] args){

        class graph{

            class edge{
                int start, end, weight;
                edge(){
                    start=0;
                    end=0;
                    weight=0;
                }
            };

            class adjList{
                ArrayList<Integer> adj = new ArrayList<Integer>();
            }
            int v, e;
            edge edges[];
            adjList adjacency[];

            public void dfs(int start, int end, ArrayList<Integer> curr){
                if(start==end){
                    for(int i=0;i<curr.size();i++){
                        System.out.print(curr.get(i));
                        if(curr.get(i)!=end){
                            System.out.print("->");
                        }
                        else{
                            System.out.println("");
                        }
                    }
                    return;
                }
                boolean present = false;
                for(int i=0;i<this.adjacency[start].adj.size();i++){
                    present=false;
                    for(int j=0;j<curr.size();j++){
                        if(curr.get(j)==this.adjacency[start].adj.get(i)){
                            present=true;
                            break;
                        }
                    }
                    if(!present){
                        curr.add(this.adjacency[start].adj.get(i));
                        dfs(this.adjacency[start].adj.get(i), end, curr);
                        curr.remove(this.adjacency[start].adj.get(i));
                    }
                }
            }

            graph(int v, int e){
                edges = new edge[e];
                adjacency = new adjList[v];
                for(int i=0;i <e; i++){
                    edges[i] = new edge();
                }
                for(int i=0;i<v;i++){
                    adjacency[i] = new adjList();
                }
            }

        };



        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of nodes and edges: ");
        int v = in.nextInt(), e = in.nextInt();
        System.out.print("Enter edges start, end, weight: ");
        graph g = new graph(v, e);

        int s, end, w;
        for(int i=0;i<e; i++){
            g.edges[i].start = in.nextInt();
            g.edges[i].end = in.nextInt();
            g.edges[i].weight = in.nextInt();
            g.adjacency[g.edges[i].start].adj.add(g.edges[i].end);
        }


        int start, dest;
        System.out.print("Enter start and destination node: ");
        start = in.nextInt();
        dest = in.nextInt();

        ArrayList<Integer> curr = new ArrayList<Integer>();
        curr.add(start);
        g.dfs(start, dest, curr);

    }
}