public class Matrix {
    double[][] multiply(double[][] a, double[][] b) {
        double[][] result = new double[a.length][b[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = multiplyCell(a, b, i, j);
            }
        }
        return result;
    }

    double multiplyCell(double[][] a, double[][] b, int row, int col) {
        double cell = 0;
        for (int i = 0; i < b.length; i++) {
            cell += a[row][i] * b[i][col];
        }
        return cell;
    }
}
