public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{2, 3, 4}, {5, 6, 4}};
        int[][] transpose = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        System.out.println("Matrix: ");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }

        System.out.println("Transpose: ");
        for (int[] row : transpose) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}