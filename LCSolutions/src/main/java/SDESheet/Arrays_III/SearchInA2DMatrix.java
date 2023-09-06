package SDESheet.Arrays_III;

public class SearchInA2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int res = binarySearch(matrix, 0, matrix.length-1, target);
        if(res == -1){
            return false;
        } else {
            boolean val = binarySearchInRow(matrix[res], 0, matrix[0].length, target);
            System.out.println(val);
            return val;
        }
    }

    private static boolean binarySearchInRow(int[] matrix, int low, int high, int target){
        if(low <= high){
            int mid = (low + high)/2;

            if(matrix[mid] == target){
                return true;
            } else if (matrix[mid] > target) {
                return binarySearchInRow(matrix, low, mid-1, target);
            } else if (matrix[mid] < target) {
                return binarySearchInRow(matrix, mid+1, high, target);
            }
        }
        return false;
    }

    private static int binarySearch(int[][] matrix, int low, int high, int target){
        if(low <= high){
            int mid = (low + high)/2;

            if(matrix[mid][0] == target || ( target > matrix[mid][0] && target <= matrix[mid][matrix[0].length-1])){
                return mid;
            } else if (matrix[mid][0] > target) {
                return binarySearch(matrix, low, mid-1, target);
            } else if (matrix[mid][0] < target) {
                return binarySearch(matrix, mid+1, high, target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };

        searchMatrix(matrix, 3);
    }
}
