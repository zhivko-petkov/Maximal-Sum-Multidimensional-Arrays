package EXERCISE;

import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int boxRows = 3; 
        int boxCols = 3;
        int[][] matrix = new int[n][m];

        inputMatrixMxN(sc, matrix, n, m);

        int max = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;
        for (int i = 0; i < n - boxRows + 1; i++)
        {
            for (int j = 0; j < m - boxCols + 1; j++)
            {
                int currentMax = CalculateBox(i, j, boxCols, boxRows, matrix);
                if (currentMax > max)
                {
                    max = currentMax;
                    row = i;
                    col = j;
                }
            }
        }
       System.out.printf("Sum = %d\n", max);
        for (int i = row; i < boxCols + row; i++)
        {
            for (int j = col; j < col + boxCols; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }



    }
    static int CalculateBox(int startRow, int startCol, int boxCols, int boxRows, int[][] matrix)
    {
        int sum = 0;
        for (int i = startRow; i < boxCols + startRow; i++)
        {
            for (int j = startCol; j < startCol + boxCols; j++)
            {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static void inputMatrixMxN(Scanner sc, int[][] matrix, int n, int m){
        for (int row = 0; row < n; row++) {
            String[] inputTokens = sc.nextLine().split(" ");
            for (int column = 0; column < m; column++) {
                matrix[row][column] = Integer.parseInt(inputTokens[column]);
            }
        }
    }
    
}
