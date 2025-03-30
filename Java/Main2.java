public class Main2 {
    public static void main(String[] args) {
        int[][] origArray = {
            {10, 20, 30},
            {40, 50, 60},
            {10, 20, 30},
            {40, 50, 60}
        };

        int rows = origArray.length;
        int columns = origArray[0].length;

        int[][] transpoArray = new int[columns][rows];

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                transpoArray[i][j] = origArray[j][i];
            }
        }

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(transpoArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
