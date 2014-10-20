import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class SocketConnection implements Runnable {
	private String hostname;
	private int port;
	private Socket socket = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private JTextArea textArea;
	private File fileSend;
	private File fileRecieve;

	public SocketConnection(String hostname, int port, JTextArea textArea,
			File file, File fileRecieve) {
		super();
		this.hostname = hostname;
		this.port = port;
		this.textArea = textArea;
		this.fileSend = file;
		this.fileRecieve = fileRecieve;
	}

	/**
	 * £¹czenie.
	 * 
	 * @return 0 - ok, 1 - ~ok
	 */
	public int connect() {
		try {
			this.socket = new Socket(this.hostname, this.port);
			textArea.append("Connected.\n");
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(textArea, e.getMessage());
			return 1;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(textArea, e.getMessage());
			return 1;
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(textArea, e.getMessage());
			return 1;
		} catch (SecurityException e) {
			JOptionPane.showMessageDialog(textArea, e.getMessage());
			return 1;
		}
		return 0;
	}

	/**
	 * Zamyka strumienie i gniazdo.
	 */
	public void disconnect() {
		try {
			out.close();
			in.close();
			socket.close();
			textArea.append("Disconnected.\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Uruchamiane przy starcie w¹tku. (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		long startTime = System.nanoTime();
		Interface.changeButtonsEnabledState();
		if (this.connect() == 1) {
			Interface.changeButtonsEnabledState();
			return;
		}
		this.write();
		this.read();
		this.disconnect();
		Interface.changeButtonsEnabledState();
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		double seconds = elapsedTime / 1.0E09;
		textArea.append("Elapsed time: " + seconds + " seconds.\n");
	}

	/**
	 * Czyta dane od serwera.
	 */
	private void read() {
		try {
			in = new BufferedReader(new InputStreamReader(
					this.socket.getInputStream()));
			BufferedWriter out = new BufferedWriter(new FileWriter(fileRecieve));
			String line;
			while (!(line = in.readLine()).equals("END")) {
				out.write(line + '\n');
			}
			out.close();
			System.out.println("Read from server succeded.");
			textArea.append("Results recieved.\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Pobiera dane od serwera.
	 */
	private void write() {
		try {
			out = new PrintWriter(this.socket.getOutputStream(), true);
			BufferedReader inFile = new BufferedReader(new FileReader(fileSend));
			String line;
			while ((line = inFile.readLine()) != null) {
				out.println(line);
			}
			out.println("END");
			inFile.close();
			System.out.println("Write to server succeded.");
			textArea.append("Data sent.\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isConnected() {
		if (socket == null) {
			return false;
		}
		return socket.isConnected();
	}
}
