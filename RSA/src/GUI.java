//import javafx.embed.swing.JFXPanel;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
///**
// * Creates the user interface and handles all user-program
// * interactions/initializations.
// *
// * The local data members are instances of the other classes which store any
// * information that the user has already presented to the program.
// *
// * The primary constructor instantiates the other classes and creates the GUI
// * frame and grids, at which point execution is passed over to an infinite user
// * interaction loop.
// * The loop processes the 4 RSA options of key creation, file blocking, file
// * unblocking, and encryption/decryption.
// * Once the user exits the GUI the program stops execution.
// *
// * The mouseListener methods of the GUI will act as the user interaction loop,
// * specifically mouseReleased which toggles one of the 4 RSA options and
// * handles user input and instance variable processing.
// *
// * @version     1.0.0
// * @university  University of Illinois at Chicago
// * @course      CS342 - Software Design
// * @package     Project #03 - RSA-Java
// * @author      Marek Rybakiewicz
// * @author      Lubna Mirza
// * @license     GNU Public License <http://www.gnu.org/licenses/gpl-3.0.txt>
// */
//public class GUI extends JFrame implements MouseListener {
//
//	/**
//	 * An instance of Blocking, which blocks/unblocks a file based on blocking
//	 * size and stores the resulting file name.
//	 */
//	protected Blocking blocks;
//	/**
//	 * An array of buttons that stores the 4 options the user may click on, all with
//	 * attached mouse listener.
//	 */
//	protected JButton[] buttons;
//	/**
//	 * An instance of Cipher, which encrypts/decrypts a blocked file and holds
//	 * the filename.
//	 */
//	protected Cipher ciphers;
//	/**
//	 * An instance of Keypair, which holds the private and public keys along with
//	 * required information.
//	 */
//	protected KeyPair keys;
//	/**
//	 * Stores the 4 radio buttons that correspond to the 4 user commands, a button is
//	 * checked if the user intends to provide custom parameters
//	 */
//	protected JRadioButton[] radioButtons;
//	/**
//	 * The panel inside of the GUI window that will hold buttons and labels
//	 * Instantiated in the constructor.
//	 */
//	protected JPanel panel;
//	/**
//	 * Stores the 4 text fields associated with the 4 user commands, a text field is
//	 * used to input custom files or file names
//	 */
//	protected JTextField[] textFields;
//
//
////	//Not used
////	public void finalize() throws Throwable {
////
////	}
//
//
//	/**
//	 * Creates the user interface and handles all user-program interactions/initializations.
//	 *
//	 * The primary constructor instantiates the other classes and creates the GUI frame and grids,
//	 * at which point execution is passed over to an infinite user interaction loop.
//	 */
//	public GUI(){
//
//
//	}
//
//	/**
//	 * Processes the user input, determining the file, blocking size, and whether to
//	 * block or unblock the file.
//	 *
//	 * Execution is then passed to Blocking which is instantiated in a local
//	 * data member and performs the desired blocking operation, as well as storing the
//	 * resulting file names.
//	 *
//	 * @param userInput
//	 */
//	public int createBlock(String[] userInput){
//		return 0;
//	}
//
//	/**
//	 * Processes the user input, determining whether a file name was provided or not
//	 * and what type of command to execute, and passes execution to Cipher by
//	 * instantiating the class in a local data member.
//	 *
//	 * An encrypted/decrypted file is created based on the input.
//	 *
//	 * @param userInput
//	 * @param keys
//	 */
//	public int createCipher(String[] userInput, KeyPair keys){
//		return 0;
//	}
//
//	/**
//	 * Processes the user input and determines whether a file was provided or not,
//	 * then passes execution over to KeyPair by instantiating the class as a
//	 * local data member, therefore creating the key pairs along with any relevant
//	 * information.
//	 *
//	 * @param userInput
//	 */
//	protected void createKey(String[] userInput){
//
//	}
//
//	/**
//	 * A method required to implement MouseListener. Does nothing.
//	 *
//	 * @param e
//	 */
//	public void mouseClicked(MouseEvent e){
//
//	}
//
//	/**
//	 * A method required to implement MouseListener. Does nothing.
//	 *
//	 * @param e
//	 */
//	public void mouseEntered(MouseEvent e){
//
//	}
//
//	/**
//	 * A method required to implement MouseListener. Does nothing.
//	 *
//	 * @param e
//	 */
//	public void mouseExited(MouseEvent e){
//
//	}
//
//	/**
//	 * A method required to implement MouseListener. Does nothing.
//	 *
//	 * @param e
//	 */
//	public void mousePressed(MouseEvent e){
//
//	}
//
//	/**
//	 * A method required to implement MouseListener.
//	 *
//	 * Handles the user input loop by processing any mouse releases that occur. Passes
//	 * execution to helper methods which perform the RSA tasks, and exits the program
//	 * upon the user exiting the GUI.
//	 *
//	 * @param e
//	 */
//	public void mouseReleased(MouseEvent e){
//
//	}
//
//}
//
//
//

import javax.swing.*;

public class GUI extends JFrame {

	/**
	 * Creates new form GUI
	 */
	public GUI() {

		super("RSA");
		jPanel1 = new JPanel();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		textField1 = new JTextField();
		textField12 = new JTextField();
		textField4 = new JTextField();
		textField5 = new JTextField();
		comboBox1 = new JComboBox<>();
		textField6 = new JTextField();
		textField9 = new JTextField();
		textField10 = new JTextField();
		textField11 = new JTextField();
		textField2 = new JTextField();
		textField3 = new JTextField();
		radioButton3 = new JRadioButton();
		radioButton4 = new JRadioButton();
		radioButton2 = new JRadioButton();
		radioButton1 = new JRadioButton();
		textField7 = new JTextField();
		textField8 = new JTextField();
		jMenuBar1 = new JMenuBar();
		jMenu1 = new JMenu();
		jMenu2 = new JMenu();
		jMenu3 = new JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		button1.setText("Create Key Pair");
		button1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button1ActionPerformed(evt);
			}
		});

		button2.setText("Block a file");

		button3.setText("Unblock a file");

		button4.setText("Cipher");

		textField1.setText("Prime number input file");
		textField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textField1ActionPerformed(evt);
			}
		});
		textField1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				textField1KeyPressed(evt);
			}
		});

		textField12.setText("Output filename");

		textField4.setText("ASCII text file");

		textField5.setText("Blocking number");

		comboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Generate primes", "Provide primes" }));

		textField6.setText("Output filename");

		textField9.setText("Output filename");

		textField10.setText("Blocked file");

		textField11.setText("Key file");
		textField11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textField11ActionPerformed(evt);
			}
		});

		textField2.setText("Private key file");
		textField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textField2ActionPerformed(evt);
			}
		});

		textField3.setText("Public key file");

		radioButton3.setText("Rename output file");

		radioButton4.setText("Rename output file");

		radioButton2.setText("Rename output file");

		radioButton1.setText("Rename output files");

		textField7.setText("Blocked text file");

		textField8.setText("Blocking number");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
												.addGap(0, 0, Short.MAX_VALUE)
												.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(radioButton3, javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(radioButton2)
																.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(radioButton1, javax.swing.GroupLayout.Alignment.TRAILING)
																		.addComponent(radioButton4, javax.swing.GroupLayout.Alignment.TRAILING)))))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(0, 0, Short.MAX_VALUE))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
												.addComponent(comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(textField10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
												.addComponent(textField11, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
												.addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textField8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(textField12)
										.addComponent(textField9)
										.addComponent(textField6)
										.addComponent(textField1)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
												.addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(30, 30, 30))
		);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGap(38, 38, 38)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(button1)
										.addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(radioButton1))
								.addGap(51, 51, 51)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(button2)
										.addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(textField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(radioButton2))
								.addGap(35, 35, 35)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(button3)
										.addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(textField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(radioButton3)
										.addComponent(textField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(35, 35, 35)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(button4)
										.addComponent(textField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(textField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(textField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(radioButton4))
								.addGap(39, 39, 39))
		);

		jMenu1.setText("Help");

		jMenu2.setText("About");
		jMenu1.add(jMenu2);

		jMenu3.setText("Help");
		jMenu1.add(jMenu3);

		jMenuBar1.add(jMenu1);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);


		this.setVisible(true);

		pack();
	}


	private void button1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void textField11ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void textField2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void textField1KeyPressed(java.awt.event.KeyEvent evt) {
		// TODO add your handling code here:
	}

	// Variables declaration - do not modify
	private javax.swing.JButton button1;
	private javax.swing.JButton button2;
	private javax.swing.JButton button3;
	private javax.swing.JButton button4;
	private javax.swing.JComboBox<String> comboBox1;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JRadioButton radioButton1;
	private javax.swing.JRadioButton radioButton2;
	private javax.swing.JRadioButton radioButton3;
	private javax.swing.JRadioButton radioButton4;
	private javax.swing.JTextField textField1;
	private javax.swing.JTextField textField10;
	private javax.swing.JTextField textField11;
	private javax.swing.JTextField textField12;
	private javax.swing.JTextField textField2;
	private javax.swing.JTextField textField3;
	private javax.swing.JTextField textField4;
	private javax.swing.JTextField textField5;
	private javax.swing.JTextField textField6;
	private javax.swing.JTextField textField7;
	private javax.swing.JTextField textField8;
	private javax.swing.JTextField textField9;
	// End of variables declaration
}
