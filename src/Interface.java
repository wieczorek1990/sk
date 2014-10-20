import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JPanel;

/**
 * @author luke
 *
 */
/**
 * @author luke
 *
 */
/**
 * @author luke
 *
 */
/**
 * @author luke
 * 
 */
public class Interface {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	JTextArea textArea;
	File fileSend = null;
	File fileRecieve = null;
	private JLabel lblFileToSend;
	private JLabel lblFileToSave;
	private JTextField textField_2;
	private JTextField textField_3;
	private JSplitPane splitPane;
	private JSplitPane splitPane_1;
	private JPanel panel;
	private static JButton btnBrowse;
	private static JButton btnBrowse_1;
	private static JButton btnConnect;
	private static JButton btnDisconnect;
	private SocketConnection connection;

	/**
	 * Launch the application. Tworzy ramkê i pokazuje j¹.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame. Od WindowBuilder Pro.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Hostname:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(30);

		JLabel lblNewLabel_1 = new JLabel("Port:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		frame.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(4);

		lblFileToSend = new JLabel("File to send:");
		GridBagConstraints gbc_lblFileToSend = new GridBagConstraints();
		gbc_lblFileToSend.anchor = GridBagConstraints.EAST;
		gbc_lblFileToSend.insets = new Insets(0, 0, 5, 5);
		gbc_lblFileToSend.gridx = 0;
		gbc_lblFileToSend.gridy = 2;
		frame.getContentPane().add(lblFileToSend, gbc_lblFileToSend);

		splitPane = new JSplitPane();
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.anchor = GridBagConstraints.WEST;
		gbc_splitPane.fill = GridBagConstraints.VERTICAL;
		gbc_splitPane.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane.gridx = 1;
		gbc_splitPane.gridy = 2;
		frame.getContentPane().add(splitPane, gbc_splitPane);

		textField_2 = new JTextField();
		splitPane.setLeftComponent(textField_2);
		textField_2.setColumns(30);

		btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				choose(textField_2);
			}
		});
		splitPane.setRightComponent(btnBrowse);

		lblFileToSave = new JLabel("File to save results:");
		GridBagConstraints gbc_lblFileToSave = new GridBagConstraints();
		gbc_lblFileToSave.anchor = GridBagConstraints.EAST;
		gbc_lblFileToSave.insets = new Insets(0, 0, 5, 5);
		gbc_lblFileToSave.gridx = 0;
		gbc_lblFileToSave.gridy = 3;
		frame.getContentPane().add(lblFileToSave, gbc_lblFileToSave);

		splitPane_1 = new JSplitPane();
		GridBagConstraints gbc_splitPane_1 = new GridBagConstraints();
		gbc_splitPane_1.anchor = GridBagConstraints.WEST;
		gbc_splitPane_1.fill = GridBagConstraints.VERTICAL;
		gbc_splitPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane_1.gridx = 1;
		gbc_splitPane_1.gridy = 3;
		frame.getContentPane().add(splitPane_1, gbc_splitPane_1);

		textField_3 = new JTextField();
		splitPane_1.setLeftComponent(textField_3);
		textField_3.setColumns(30);

		btnBrowse_1 = new JButton("Browse");
		btnBrowse_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				choose(textField_3);
			}
		});
		splitPane_1.setRightComponent(btnBrowse_1);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		btnConnect = new JButton("Connect");
		GridBagConstraints gbc_btnConnect = new GridBagConstraints();
		gbc_btnConnect.insets = new Insets(0, 0, 5, 0);
		gbc_btnConnect.gridx = 0;
		gbc_btnConnect.gridy = 0;
		panel.add(btnConnect, gbc_btnConnect);

		btnDisconnect = new JButton("Disconnect");
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				disconnect();
			}
		});
		GridBagConstraints gbc_btnDisconnect = new GridBagConstraints();
		gbc_btnDisconnect.insets = new Insets(0, 0, 5, 0);
		gbc_btnDisconnect.anchor = GridBagConstraints.NORTH;
		gbc_btnDisconnect.gridx = 0;
		gbc_btnDisconnect.gridy = 1;
		panel.add(btnDisconnect, gbc_btnDisconnect);
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				connect();
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);

		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		customInitialization();
	}

	/**
	 * Bajery + wype³nienie pól tekstowych
	 */
	private void customInitialization() {
		frame.setTitle("Client");
		textField.setText("localhost");
		textField_1.setText("1234");
		textField_2.setText("C:\\Users\\luke\\workspace\\SK2\\matrices.txt");
		textField_3.setText("C:\\Users\\luke\\workspace\\SK2\\results.txt");
		btnDisconnect.setEnabled(false);
	}

	/**
	 * Okienko wyboru pliku
	 * 
	 * @param textField
	 */
	private void choose(JTextField textField) {
		final JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
		int returnVal = fc.showDialog(frame, "Choose");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			textField.setText(fc.getSelectedFile().getAbsolutePath());
		}
	}

	/**
	 * Pobranie parametrów po³¹czenia i odpalenie w¹tku po³aczenia.
	 */
	private void connect() {
		if (textField.getText().equals("") || textField_1.getText().equals("")) {
			JOptionPane.showMessageDialog(frame,
					"Please specify hostname and port.");
			return;
		}
		String hostname = textField.getText();
		int port = Integer.parseInt(textField_1.getText());
		fileSend = new File(textField_2.getText());
		fileRecieve = new File(textField_3.getText());
		if (!fileSend.exists() || !fileRecieve.exists()) {
			JOptionPane.showMessageDialog(frame,
					"You must choose files to send and to recieve.");
			return;
		}

		connection = new SocketConnection(hostname, port, textArea, fileSend,
				fileRecieve);
		Thread thread = new Thread(connection);
		thread.start();
	}

	/**
	 * Roz³¹czenie. Nie mam pomys³u jak to zrobiæ by dzia³a³o :D
	 */
	private void disconnect() {
		JOptionPane.showMessageDialog(frame, "Currently not supported. Sorry!");
	}

	public static void changeButtonsEnabledState() {
		btnConnect.setEnabled(!btnConnect.isEnabled());
		btnDisconnect.setEnabled(!btnDisconnect.isEnabled());
		btnBrowse.setEnabled(!btnBrowse.isEnabled());
		btnBrowse_1.setEnabled(!btnBrowse_1.isEnabled());
	}
}
