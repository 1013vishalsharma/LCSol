package main.java.SDESheet.Graph;

public class ConnectedComponents {

    public static int findNumOfProvinces(int[][] roads, int n) {
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                traversal(roads, i, n, visited);
                count++;
            } else {
                continue;
            }
        }
        System.out.println(count);
        return count;

    }

    private static void traversal(int[][] roads, int i, int n, boolean[] visited){
        for (int j=0; j<n; j++){
            if(roads[i][j] == 1){
                if(visited[j])
                    continue;
                else {
                    visited[j] = true;
                    traversal(roads, j, n, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] roads = {
                /*{1,1,1,0},
                {1,1,1,0},
                {1,1,1,0},
                {0,0,0,1}*/

                /*{1,0,0},
                {0,1,0},
                {0,0,1}*/

                /*{1,1,0,0},
                {1,1,0,0},
                {0,0,1,1},
                {0,0,1,1}*/

                {1, 0, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 1, 1}
        };
        ConnectedComponents.findNumOfProvinces(roads, 4);
    }
}
