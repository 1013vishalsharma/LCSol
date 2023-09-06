package SDESheet.Arrays_III;

public class UniquePaths {

    static int count = 0;
    public static void uniquePaths(int[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return;
        }
        if(i == board.length-1 && j == board[0].length-1){
            count++;
            return;
        }
        uniquePaths(board, i+1, j);
        uniquePaths(board, i, j+1);
    }

    public static void main(String[] args) {
        int m = 3, n = 2;
        int[][] board = new int[m][n];
        uniquePaths(board, 0, 0);
        System.out.println(count);
    }
}
