import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private final static int PORT = 1234;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		/*
		 * Tworzy gniazdo.
		 */
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Couldn't listen on port "
					+ Integer.toString(PORT));
			System.exit(1);
		}
		/*
		 * Akceptuje po³aczenie od klienta.
		 */
		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Accept failed");
			System.exit(1);
		}
		/*
		 * Strumienie do pisania/czytania do/z klientem.
		 */
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		/*
		 * Czyta dane od kilenta.
		 */
		String inputLine;
		PrintWriter fileOut = new PrintWriter("recieved.txt");
		while (!(inputLine = in.readLine()).equals("END")) {
			fileOut.println(inputLine);
		}
		fileOut.close();
		System.out.println("Read from client succeded.");
		/*
		 * Mno¿y macierz i zapisuje j¹ do pliku.
		 */
		BufferedReader fileIn = new BufferedReader(new FileReader("recieved.txt"));
		int matrixSize = Integer.parseInt(fileIn.readLine());
		Double[][] matrix1 = Matrix.readMatrix(matrixSize, fileIn);
		Double[][] matrix2 = Matrix.readMatrix(matrixSize, fileIn);
		fileIn.close();
		Double[][] resultingMatrix = Matrix.multiplyMatrices(matrixSize,
				matrix1, matrix2);
		// Matrix.printMatrix(matrixSize, resultingMatrix);
		BufferedWriter fileOut2 = new BufferedWriter(
				new FileWriter("results.txt"));
		Matrix.saveMatrix(matrixSize, resultingMatrix, fileOut2);
		fileOut2.close();
		System.out.println("Result saved to file.");
		/*
		 * Wysy³a macierz z pliku do klienta.
		 */
		BufferedReader fileIn2 = new BufferedReader(new FileReader("results.txt"));
		String outputLine;
		while ((outputLine = fileIn2.readLine()) != null) {
			out.println(outputLine);
		}
		out.print("END");
		fileIn2.close();
		System.out.println("Write to client succeded.");
		/*
		 * Zamkniecie strumieni.
		 */
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}
}
