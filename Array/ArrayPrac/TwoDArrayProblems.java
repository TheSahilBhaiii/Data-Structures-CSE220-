/*
    🔹 Complex 2D Array Practice Problems
    Author: Sahil

    Each problem below has:
    - A clear comment description (like LeetCode)
    - A function stub for your solution
    - A main() that reads matrix input and calls one function (uncomment to test)
*/

import java.util.*;

public class TwoDArrayProblems {

    /* -------------------------------------------------------------------
       🧩 Problem 1: Diagonal Sum Difference
       Given an N x N matrix, return the absolute difference between 
       the sum of its primary diagonal and secondary diagonal.
       Example:
       Input:
       3
       11 2 4
       4 5 6
       10 8 -12
       Output: 15
    ------------------------------------------------------------------- */
    public static int diagonalDifference(int[][] matrix) {
        int M=matrix.length;
        int primsum=0;
        int secsum=0;
        int diff=0;
        int counter=M-1;
        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                if(i==j){
                    primsum+=matrix[i][j];
                }
            }
        }
        for(int i=0;i<M;i++){
                secsum+=matrix[i][counter];
                counter--;
            }
        
        if(primsum>secsum){
        diff=Math.abs(primsum-secsum);
        }
        else{
            diff=Math.abs(secsum-primsum);
        }
        return diff;
    }

    /* -------------------------------------------------------------------
       🧩 Problem 2: Spiral Traversal
       Return an array of elements in spiral order (clockwise).
       Example:
       Input:
       3 3
       1 2 3
       4 5 6
       7 8 9
       Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    ------------------------------------------------------------------- */
    public static int[] spiralOrder(int[][] matrix) {
        int M=matrix.length;
        int spiral[]=new int[M*M];
        int top=0;
        int left=0;
        int right=M-1;
        int bottom=M-1;
        int idx=0;
        while(top<=bottom && left<=right){
        for(int i=left;i<=right;i++){
            spiral[idx]=matrix[top][i];
            idx++;
        }
        top++;
        for(int i=top;i<=bottom;i++){
            spiral[idx]=matrix[i][right];
            idx++;
        }
        right--;
        if(top<=bottom){
        for(int i=right;i>=left;i--){
            spiral[idx]=matrix[bottom][i];
            idx++;
        }
    }
        bottom--;
        if(left<=right){
        for(int i=bottom;i>=top;i--){
            spiral[idx]=matrix[i][left];
            idx++;
        }
        left++;
    }
        }
        return spiral;
        }
    /* -------------------------------------------------------------------
       🧩 Problem 3: Rotate Matrix 90° Clockwise
       Modify the matrix in-place to rotate it 90 degrees clockwise.
       Example:
       Input:
       3
       1 2 3
       4 5 6
       7 8 9
       Output:
       7 4 1
       8 5 2
       9 6 3
    ------------------------------------------------------------------- */
    public static void rotate90Clockwise(int[][] matrix) {
        int n=matrix.length;
        int rotatedmatrix[][]=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                rotatedmatrix[j][n-1-i]=matrix[i][j];
            
        }
    }
        printMatrix(rotatedmatrix);
        
    }
    /* -------------------------------------------------------------------
       🧩 Problem 4: Row with Maximum Sum
       Find the row with the maximum sum and return its index (0-based).
       Example:
       Input:
       3 3
       1 2 3
       4 5 6
       7 8 9
       Output: 2
    ------------------------------------------------------------------- */
    public static int rowWithMaxSum(int[][] matrix) {
        int M=matrix.length;
        int N=matrix[0].length;
        int sumrow[]=new int[M];
        int sum=0;
        int max=Integer.MIN_VALUE;;

        for(int i=0;i<M;i++){
            sum=0;
            for(int j=0;j<N;j++){
                sum+=matrix[i][j];
                sumrow[i]=sum;
            }
        }
        for(int k=1;k<M;k++){
            if(sumrow[k]>sumrow[k-1]){
            max=sumrow[k];
            }
        }
        for(int i=0;i<M;i++){
            if(max==sumrow[i]){
                return i;
            }
        }
        return -1;
    }

    /* -------------------------------------------------------------------
       🧩 Problem 5: Search in Sorted Matrix
       Each row and column is sorted in ascending order.
       Return true if the target exists, else false.
       Example:
       Input:
       3 3, target = 5
       1 3 5
       7 9 11
       13 15 17
       Output: true
    ------------------------------------------------------------------- */
    public static boolean searchInSortedMatrix(int[][] matrix, int target) {
        int M=matrix.length;
        int N=matrix[0].length;
        int X=target;

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }

    /* -------------------------------------------------------------------
       🧩 Problem 6: Transpose of Matrix
       Return the transpose of the given matrix.
       Example:
       Input:
       2 3
       1 2 3
       4 5 6
       Output:
       1 4
       2 5
       3 6
    ------------------------------------------------------------------- */
    public static int[][] transposeMatrix(int[][] matrix) {
        int M=matrix.length;
        int N=matrix[0].length;
        int transposematrix [][]=new int[N][M];

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                transposematrix[j][i]=matrix[i][j];
            }
        }
        
        return transposematrix;
    }

    /* -------------------------------------------------------------------
       🧩 Problem 7: Boundary Traversal
       Print all boundary elements of a matrix in clockwise order.
       Example:
       Input:
       4 4
       1 2 3 4
       5 6 7 8
       9 10 11 12
       13 14 15 16
       Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5]
    ------------------------------------------------------------------- */
    public static int[] boundaryTraversal(int[][] matrix) {
        int M=matrix.length;
        int N=matrix[0].length;
        int boundary[]=new int[2*(M+N)-4];
        int idx=0;
        int top=0;
        int left=0;
        int right=N-1;
        int bottom=M-1;

        for(int i=left;i<=right;i++){
           boundary[idx]=matrix[top][i];
           idx++;
            }
            top++;
        
        for(int i=top;i<=bottom;i++){
           boundary[idx]=matrix[i][right];
           idx++;
            }
            right--;
        
        for(int i=right;i>=left;i--){
            boundary[idx]=matrix[bottom][i];
            idx++;
        }
        bottom--;

         for(int i=bottom;i>=top;i--){
            boundary[idx]=matrix[i][left];
            idx++;
         }
        
        
        return boundary;
    }

    /* -------------------------------------------------------------------
       🧩 Problem 8: Saddle Point in Matrix
       A saddle point is an element that is the minimum in its row and
       the maximum in its column. Return it, or -1 if none exists.
       Example:
       Input:
       3 3
       4 5 6
       7 8 9
       1 2 3
       Output: 7
    ------------------------------------------------------------------- */
    public static int saddlePoint(int[][] matrix) {
        // TODO: Implement manually
        return -1;
    }

    /* -------------------------------------------------------------------
       🧩 Problem 9: Matrix Rotation (Cyclic Shift)
       Given a matrix, rotate all elements of the matrix in a spiral order
       by one position (cyclic shift).
       Example:
       Input:
       3 3
       1 2 3
       4 5 6
       7 8 9
       Output:
       4 1 2
       7 5 3
       8 9 6
    ------------------------------------------------------------------- */
    public static void rotateCyclic(int[][] matrix) {
        // TODO: Implement manually
    }

    /* -------------------------------------------------------------------
       🧩 Problem 10: Matrix Multiplication
       Multiply two matrices A (m x n) and B (n x p), return the result.
       Example:
       Input:
       A = 2x3, B = 3x2
       A: 1 2 3
          4 5 6
       B: 7 8
          9 10
          11 12
       Output:
       58 64
       139 154
    ------------------------------------------------------------------- */
    public static int[][] multiplyMatrix(int[][] A, int[][] B) {
        // TODO: Implement manually
        return new int[0][0];
    }

    /* -------------------------------------------------------------------
       🧠 MAIN METHOD: for testing
       Reads matrix input and lets you test each function manually
    ------------------------------------------------------------------- */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] matrix = new int[r][c];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Uncomment ONE function call below to test

                            //System.out.println(diagonalDifference(matrix));
                            //System.out.println(Arrays.toString(spiralOrder(matrix)));
                            //rotate90Clockwise(matrix);
                            //System.out.println(rowWithMaxSum(matrix));
                            //System.out.println(searchInSortedMatrix(matrix, 5));
                            //printMatrix(transposeMatrix(matrix));
                            //System.out.println(Arrays.toString(boundaryTraversal(matrix)));
        // System.out.println(saddlePoint(matrix));
        // rotateCyclic(matrix);
        // printMatrix(multiplyMatrix(matrix, matrix)); // example only

        sc.close();
    }

    // Utility to print a 2D matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
