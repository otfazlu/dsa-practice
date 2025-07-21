package com.mytestpractice;

import java.util.List;
/*
 * 
1 2 3
4 5 6
7 8 9
 
 
 
1 2 3 6 9 8 7 4 5
 
 * 
 */
public class SpiralMatrixTraversal {

    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Spiral order for matrix1:");
        printSpiral(matrix1); // Expected: 1 2 3 6 9 8 7 4 5

        System.out.println("\n---------------------\n");

        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13,14,15,16}
        };
        System.out.println("Spiral order for matrix2:");
        printSpiral(matrix2); // Expected: 1 2 3 4 8 12 11 10 9 5 6 7

        System.out.println("\n---------------------\n");

        int[][] matrix3 = {
            {1}
        };
        System.out.println("Spiral order for matrix3:");
        printSpiral(matrix3); // Expected: 1

        System.out.println("\n---------------------\n");

        int[][] matrix4 = {
            {1, 2},
            {3, 4}
        };
        System.out.println("Spiral order for matrix4:");
        printSpiral(matrix4); // Expected: 1 2 4 3
    }

    public static void printSpiral(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Matrix is empty or null.");
            return;
        }

        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int topRow = 0;
        int bottomRow = numRows - 1;
        int leftCol = 0;
        int rightCol = numCols - 1;

        while (topRow <= bottomRow && leftCol <= rightCol) {

            // Traverse Right (Top Row)
            for (int col = leftCol; col <= rightCol; col++) {
                System.out.print(matrix[topRow][col] + " ");
            }
            topRow++; // Move the top boundary down

            // Traverse Down (Right Column)
            if (topRow <= bottomRow) { // Check if there are still rows to traverse
                for (int row = topRow; row <= bottomRow; row++) {
                    System.out.print(matrix[row][rightCol] + " ");
                }
                rightCol--; // Move the right boundary left
            }


            // Traverse Left (Bottom Row)
            if (topRow <= bottomRow) { // Check if there are still rows to traverse
                for (int col = rightCol; col >= leftCol; col--) {
                    System.out.print(matrix[bottomRow][col] + " ");
                }
                bottomRow--; // Move the bottom boundary up
            }

            // Traverse Up (Left Column)
            if (leftCol <= rightCol) { // Check if there are still columns to traverse
                for (int row = bottomRow; row >= topRow; row--) {
                    System.out.print(matrix[row][leftCol] + " ");
                }
                leftCol++; // Move the left boundary right
            }
        }
        System.out.println(); // New line after printing the spiral
    }
}