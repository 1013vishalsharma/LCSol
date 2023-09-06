package SDESheet.Backtracking;

public class SudokuSolver {

    public static void solveSudoku(char[][] board) {
        solve(board);

        for (int i = 0; i<board.length; i++){
            for (int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    //static boolean found = true;
    private static boolean solve(char[][] board){
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j < board.length; j++){
                if(board[i][j] == '.'){
                    for (char x = '1'; x <= '9'; x++){
                        if(validateColumn(board, i, j, x) && validateRow(board, i, j, x) && validateSquare(board, i, j, x)){
                            board[i][j] = x;
                            if(solve(board)){
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean validateRow(char[][] board, int i, int j, char x){
        for(int col = 0; col < board.length; col++){
            if(board[i][col] == x){
                return false;
            }
        }
        return true;
    }

    private static boolean validateColumn(char[][] board, int i, int j, char x){
        for(int row = 0; row < board.length; row++){
            if(board[row][j] == x){
                return false;
            }
        }
        return true;
    }

    private static boolean validateSquare(char[][] board, int i, int j, char x){
        int startRow, endRow, startCol, endCol;
        if (i >= 0 && i <=2){
            startRow = 0;
            endRow = 2;
        } else if (i >= 3 && i <= 5){
            startRow = 3;
            endRow = 5;
        } else {
            startRow = 6;
            endRow = 8;
        }

        if (j >= 0 && j <=2){
            startCol = 0;
            endCol = 2;
        } else if (j >= 3 && j <= 5){
            startCol = 3;
            endCol = 5;
        } else {
            startCol = 6;
            endCol = 8;
        }

        for (int a = startRow; a <= endRow; a++){
            for(int b = startCol; b <= endCol; b++){
                if(board[a][b] == x){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        /*
            001
            101

         */

        /*char[][] board = {
                {'5', '3', '.',},
                {'6', '.', '.',},
                {'4', '7', '8',},
        };*/

        solveSudoku(board);
    }
}
