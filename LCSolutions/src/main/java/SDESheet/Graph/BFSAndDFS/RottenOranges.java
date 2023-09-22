package main.java.SDESheet.Graph.BFSAndDFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    static class Pair{
        int i;
        int j;
        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        int count = -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Queue<Pair> queue = new LinkedList<>();
        boolean freshOrange = false;

        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    //freshOrange = true;
                    queue.add(new Pair(i, j));
                } else if (grid[i][j] ==1) {
                    freshOrange = true;
                }
            }
        }

        if(!freshOrange){
            return 0;
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            while(size != 0) {
                Pair pair = queue.poll();

                grid[pair.i][pair.j] = 2;
                if (pair.i + 1 < grid.length && grid[pair.i + 1][pair.j] == 1 && !visited[pair.i+1][pair.j]) {
                    queue.add(new Pair(pair.i + 1, pair.j));
                    visited[pair.i+1][pair.j] = true;
                }
                if (pair.i - 1 >= 0 && grid[pair.i - 1][pair.j] == 1 && !visited[pair.i-1][pair.j]) {
                    queue.add(new Pair(pair.i - 1, pair.j));
                    visited[pair.i-1][pair.j] = true;
                }
                if (pair.j + 1 < grid[0].length && grid[pair.i][pair.j + 1] == 1 && !visited[pair.i][pair.j+1]) {
                    queue.add(new Pair(pair.i, pair.j+1));
                    visited[pair.i][pair.j+1] = true;
                }
                if (pair.j - 1 >= 0 && grid[pair.i][pair.j - 1] == 1 && !visited[pair.i][pair.j-1]) {
                    queue.add(new Pair(pair.i, pair.j-1));
                    visited[pair.i][pair.j-1] = true;
                }
                size--;
            }
        }

        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        RottenOranges sol = new RottenOranges();
        int[][] grid = {
                {2,2},
                {1,1},
                {0,0},
                {2,0}
        };

        sol.orangesRotting(grid);
    }
}
