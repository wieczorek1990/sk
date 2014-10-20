import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Generator {

	/**
	 * Generuje duza maciez double'ow. Format: { rozmiar_obydwu macierzy
	 * kwadratowych macierz 1 macierz 2 END }
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		int matrixSize = 10000;
		String fileName = Integer.toString(matrixSize) + "-matrices.txt";
		String path = "C:\\Users\\luke\\workspace\\SK2\\";
		String filePath = path + fileName;

		Random r = new Random();
		BufferedWriter out = new BufferedWriter(new FileWriter(filePath));

		out.write(Integer.toString(matrixSize) + '\n');
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < matrixSize; i++) {
				for (int j = 0; j < matrixSize; j++) {
					out.write(Double.toString(r.nextDouble()) + " ");
				}
				out.write('\n');
			}
		}
		out.write("END");
		out.close();

		System.out.println("Finished generating matrix.");
	}
}
