package SDESheet.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {

    public static void findPath(int[][] m){
        boolean[][] visited = new boolean[m.length][m.length];
        findPath(m, 0, 0, new ArrayList<>(), "", visited);

    }

    public static void findPath(int[][] m, int i, int j, List<String> str, String dir, boolean[][] visited){
        if(i < 0 || j < 0 || i >= m.length || j >= m.length || m[i][j] == 0 || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        str.add(dir);
        if(i == m.length-1 && j == m.length-1){
            str.forEach(System.out::print);
            System.out.println();
            visited[i][j] = false;
            str.remove(str.size()-1);
            return;
        }

        findPath(m, i+1, j, str, "D", visited);
        findPath(m, i-1, j, str, "U", visited);
        findPath(m, i, j+1, str, "R", visited);
        findPath(m, i, j-1, str, "L", visited);

        visited[i][j] = false;
        str.remove(str.size()-1);
    }


    public static void main(String[] args) {
        int[][] m = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        findPath(m);
    }
}
