package main.java.SDESheet.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
        // Write your code here
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.add(0);
        List<Integer> res = new ArrayList<>();

        while(!queue.isEmpty()){
            int i = queue.poll();
            res.add(i);
            if(!visited[i]) {
                visited[i] = true;
                List<Integer> neighbours = adj.get(i);
                queue.addAll(neighbours);
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(List.of(1,2,3));
        adj.add(List.of(4));
        adj.add(List.of(5));
        adj.add(List.of());
        adj.add(List.of());
        adj.add(List.of());

        BFS.bfsTraversal(6, adj);

    }
}
