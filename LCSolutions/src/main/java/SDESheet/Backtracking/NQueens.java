package SDESheet.Backtracking;

public class NQueens {

    public static void nQueens(int n){
        char[][] board = new char[n][n];

        /*for (int i = 0; i < n; i++){
            for (int j = 0; j < n ; j++){
                solveNQueens(board, i, j);
            }
        }*/

        for(int i=0; i< board.length; i++){
            solveNQueens(board, i, 0, 0);
        }

        displayBoard(n, board);
    }

    private static void displayBoard(int n, char[][] board) {
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(board[i][j] + ", ");
            }
            System.out.println();
        }
    }

    private static void solveNQueens(char[][] board, int row, int col, int count){
        if(row > board.length-1 || row < 0 || col >board.length -1 || col < 0){
            return;
        }
        else {

            if (validatePosition(board, row, col)) {
                board[row][col] = 'Q';
                count++;
                if(count == board.length){
                    displayBoard(board.length, board);
                    System.out.println("-----------------------------------------------------------------------------");
                }
                for(int i = 0; i< board.length; i++) {
                    solveNQueens(board, i, col + 1, count);
                }
                board[row][col] = '-';
            }
        }
    }

    private static boolean validatePosition(char[][] board, int row, int col){
        // check cols
        for (int i=0; i<board.length; i++){
            if(i == col){
                continue;
            }
            if(board[row][i] == 'Q')
                return false;
        }

        // check row
        for (int i=0; i<board.length; i++){
            if(i == row){
                continue;
            }
            if(board[i][col] == 'Q')
                return false;
        }

        //check upper left diagnol
        for (int i=row-1, j= col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q')
                return false;
        }

        //check lower right diagnol
        for (int i=row+1, j= col+1; i<=board.length-1 && j<=board.length-1; i++, j++){
            if(board[i][j] == 'Q')
                return false;
        }

        //check upper right diagnol
        for (int i=row-1, j= col+1; i>=0 && j<=board.length-1; i--, j++){
            if(board[i][j] == 'Q')
                return false;
        }

        // check lower left diagnol
        for (int i=row+1, j= col-1; i<= board.length-1 && j>=0; i++, j--){
            if(board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        nQueens(4);
    }

}
