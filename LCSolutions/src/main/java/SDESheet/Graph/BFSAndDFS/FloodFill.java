package main.java.SDESheet.Graph.BFSAndDFS;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    static class Pair{
        int i;
        int j;
        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color){
            return image;
        }
        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        visited[sr][sc] = true;

        int initialColor = image[sr][sc];
        image[sr][sc] = color;

        while(!queue.isEmpty()){

            Pair pair = queue.poll();

            if(pair.i+1 < image.length && image[pair.i+1][pair.j] == initialColor && !visited[pair.i+1][pair.j]){
                visited[pair.i+1][pair.j] = true;
                image[pair.i+1][pair.j] = color;
                queue.add(new Pair(pair.i+1, pair.j));
            }
            if(pair.i-1 >= 0 && image[pair.i-1][pair.j] == initialColor && !visited[pair.i-1][pair.j]){
                visited[pair.i-1][pair.j] = true;
                image[pair.i-1][pair.j] = color;
                queue.add(new Pair(pair.i-1, pair.j));
            }
            if(pair.j+1 < image[0].length && image[pair.i][pair.j+1] == initialColor && !visited[pair.i][pair.j+1]){
                visited[pair.i][pair.j+1] = true;
                image[pair.i][pair.j+1] = color;
                queue.add(new Pair(pair.i, pair.j+1));
            }
            if(pair.j-1 >= 0 && image[pair.i][pair.j-1] == initialColor && !visited[pair.i][pair.j-1]){
                visited[pair.i][pair.j-1] = true;
                image[pair.i][pair.j-1] = color;
                queue.add(new Pair(pair.i, pair.j-1));
            }
        }

        return image;
    }

    public static void main(String[] args) {
        FloodFill sol = new FloodFill();
        int[][] image = {
                /*{1,1,1,},
                {1,1,0},
                {1,0,1}*/

                {7,1,1,1},
                {1,7,7,7},
                {7,7,7,0},
                {7,7,7,4},
                {4,4,4,4}
        };

        sol.floodFill(image, 2,2,5);
    }
}
