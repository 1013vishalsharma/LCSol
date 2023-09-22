package main.java.SDESheet.Graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        boolean[] visited = new boolean[v];
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i=0; i<v; i++){
            if(!visited[i]){
                visited[i] = true;
                ArrayList<Integer> res = new ArrayList<>();
                res.add(i);
                res = dfs(edges, i, visited, res, al);
                al.add(res);
            }
        }
        System.out.println("ans" + al);
        return al;
    }

    private static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> edges, int i, boolean[] visited, ArrayList<Integer> res, ArrayList<ArrayList<Integer>> al){
        List<Integer> edgeList = edges.get(i);
        for (int j=0; j<edgeList.size(); j++){
            int edge = edgeList.get(j);
            if(!visited[edge]){
                visited[edge] = true;
                res.add(edge);
                /*List<Integer> res = new ArrayList<Integer>();
                res.add(i);*/
                dfs(edges, edge, visited, res, al);
            } else {
                continue;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        /*
        9 7
0 1
0 2
0 5
3 6
7 4
4 8
7 8
         */
        edges.add(new ArrayList(List.of(1,2,5)));
        edges.add(new ArrayList(List.of()));
        edges.add(new ArrayList(List.of()));
        edges.add(new ArrayList(List.of(6)));
        edges.add(new ArrayList(List.of(8)));
        edges.add(new ArrayList(List.of()));
        edges.add(new ArrayList(List.of()));
        edges.add(new ArrayList(List.of(4,8)));
        edges.add(new ArrayList(List.of()));


        DFS.depthFirstSearch(9,7, edges);

        /*edges[[1, 0], [2, 0], [3, 0], [4, 0], [5, 0], [6, 0], [7, 0], [8, 0], [9, 0]]
[[0, 1], [2], [3], [4], [5], [6], [7], [8], [9]]
        0 1 2 3 4 5 6 7 8 9
        9
        0 1
        2
        3
        4
        5
        6
        7
        8
        9


        Exception in thread  main  java.lang.IndexOutOfBoundsException: Index: 9, Size: 9
        at java.util.ArrayList.rangeCheck(ArrayList.java:653)
        at java.util.ArrayList.get(ArrayList.java:429)
        at Solution.dfs(Solution.java:22)
        at Solution.dfs(Solution.java:30)
        at Solution.dfs(Solution.java:30)
        at Solution.dfs(Solution.java:30)
        at Solution.dfs(Solution.java:30)
        at Solution.dfs(Solution.java:30)
        at Solution.dfs(Solution.java:30)
        at Solution.dfs(Solution.java:30)
        at Solution.dfs(Solution.java:30)*/



    }
}
