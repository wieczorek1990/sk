import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Matrix {
	/**
	 * Zapisuje macierz.
	 * 
	 * @param matrixSize
	 * @param matrix
	 * @param out
	 */
	public static void saveMatrix(int matrixSize, Double[][] matrix,
			BufferedWriter out) {
		try {
			out.write(Integer.toString(matrixSize) + "\n");
			for (int currentRow = 0; currentRow < matrixSize; currentRow++) {
				for (int currentColumn = 0; currentColumn < matrixSize; currentColumn++) {
					out.write(matrix[currentRow][currentColumn].toString()
							+ " ");
				}
				out.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Wczytuje macierz.
	 * 
	 * @param matrixSize
	 * @param in
	 * @return
	 */
	public static Double[][] readMatrix(int matrixSize, BufferedReader in) {
		Double[][] matrix = new Double[matrixSize][matrixSize];
		try {
			for (int currentRow = 0; currentRow < matrixSize; currentRow++) {
				String line = in.readLine();
				String row[] = line.split(" ");
				for (int currentColumn = 0; currentColumn < matrixSize; currentColumn++) {
					matrix[currentRow][currentColumn] = Double
							.parseDouble(row[currentColumn]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return matrix;
	}

	/**
	 * Wypisuje macierz.
	 * 
	 * @param matrixSize
	 * @param matrix
	 */
	public static void printMatrix(int matrixSize, Double[][] matrix) {
		System.out.println("MatrixSize = " + matrixSize);
		for (int currentRow = 0; currentRow < matrixSize; currentRow++) {
			for (int currentColumn = 0; currentColumn < matrixSize; currentColumn++) {
				System.out.print(matrix[currentRow][currentColumn] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Mno¿y macierze.
	 * 
	 * @param matrixSize
	 * @param matrix1
	 * @param matrix2
	 * @return
	 */
	public static Double[][] multiplyMatrices(int matrixSize,
			Double[][] matrix1, Double[][] matrix2) {
		Double[][] result = new Double[matrixSize][matrixSize];
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				result[i][j] = 0.0d;
			}
		}
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				for (int k = 0; k < matrixSize; k++) {
					result[i][j] += matrix1[i][k] * matrix2[k][j];
				}
			}
		}
		return result;
	}
}
