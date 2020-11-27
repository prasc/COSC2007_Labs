// Partner with Ekta

public class EightQueen {
    private static int[][] board = new int[8][8];     // creating chess board using 2D 8x8 array

    public static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {             // if board[i][j] == 1, it means there is a queen at this position
                    System.out.print("Q ");         // print Queen at this position
                } else {
                    System.out.print(". ");         // mark as empty spot
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main() {
        solution(board, 0);             // call solution with initial column of 0, which is furthest left column
     //  allSolution(board, 0);
    }


    public static boolean allSolution(int board[][], int col) {
        if (col >= 8) {
            printBoard();
            return true;
        }
        boolean result = false;
        for (int i = 0; i < 8; i++) {
            if (isValid(i, col)) {
                board[i][col] = 1;

                result =  allSolution(board, col + 1) || result;

                board[i][col] = 0;
            }
        }
        return result;
    }


    public static boolean solution(int board[][], int col) {
        if (col >= 8) {                     // this is the base case, happens when we have traversed every column
            printBoard();                    // print board, board[row][col] == 1 if there should be a queen on that spot
            return true;                    // return true, which ends function
        }

        for (int i = 0; i < 8; i++) {       // i represents the row, we start with the top most row (row 0) and end at the bottom room (row 7)

            if (isValid(i, col)) {          // passing current row and column and checking if this position is under attack by other queens
                board[i][col] = 1;          // if its not under attack, its valid, so mark it as 1 which represents a queen

                if (solution(board, col+1)) {    // recursively passing the current board with all of its queens, and moving on to the next column
                    return true;                            // keep incrementing col (using col+1) until col >= 8, at which point, move to next row (i++)
                }
                //**** BACK TRACKING ******
                board[i][col] = 0;          // revert the last queen back to 0
            }
        }
        return false;
    }


    // we're only checking left side because right side is empty past current col value
    public static boolean isValid(int row, int col) {
        // Checking if there is a queen on this row to the left
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Checking this there is a queen on the upper diagonal left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Checking this there is a queen on the lower diagonal left side
        for (int i = row, j = col; j >= 0 && i < 8; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // If none of these statements returned false:
        // It means there are no queens in attacking position
        // Therefore, the current position is valid
        return true;
    }



}
