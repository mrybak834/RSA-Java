import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Creates the user interface and handles all user-program
 * interactions/initializations.
 *
 * The local data members are instances of the other classes which store any
 * information that the user has already presented to the program.
 *
 * The primary constructor instantiates the other classes and creates the GUI
 * frame and grids, at which point execution is passed over to an infinite user
 * interaction loop.
 * The loop processes the 4 RSA options of key creation, file blocking, file
 * unblocking, and encryption/decryption.
 * Once the user exits the GUI the program stops execution.
 *
 * The mouseListener methods of the GUI will act as the user interaction loop,
 * specifically mouseReleased which toggles one of the 4 RSA options and
 * handles user input and instance variable processing.
 *
 * @version     1.0.0
 * @university  University of Illinois at Chicago
 * @course      CS342 - Software Design
 * @package     Project #03 - RSA-Java
 * @author      Marek Rybakiewicz
 * @author      Lubna Mirza
 * @license     GNU Public License <http://www.gnu.org/licenses/gpl-3.0.txt>
 */
public class GUI extends JFrame implements ActionListener, KeyListener {

	/**
	 * An array of all components stored on the JFrame
	 */
	JComponent[] jArray;

	/**
	 * An array to track which components have been modified
	 */
	int[] modified;

	/**
	 * An instance of Cipher, which encrypts/decrypts a blocked file and holds
	 * the filename.
	 */
	protected Cipher ciphers;
	/**
	 * An instance of Keypair, which holds the private and public keys along with
	 * required information.
	 */
	protected KeyPair keys;

	/**
	 * File that stores prime numbers for usage in key creation
	 */
	protected static String primesFile;

	/**
	 * File that stores the blocked numbers
	 */
	protected static String blockedFile;

	/**
	 * File that stores the unblocked ASCII characters
	 */
	protected static String unblockedFile;

	/**
	 * XML file that stores a private or public key
	 */
	protected static String keyFile;

	/**
	 * Creates new GUI
	 */
	public GUI() {
		//Create a frame
		super("RSA");
		
		//Create array that holds all components
		jArray = new JComponent[26];

		//Create components
		JPanel panel1 = new JPanel();
		JMenuBar menuBar1 = new JMenuBar();
		JMenu menu1 = new JMenu();
		JMenu menu2 = new JMenu();
		JMenu menu3 = new JMenu();
		JButton button1 = new JButton();
		JButton button2 = new JButton();
		JButton button3 = new JButton();
		JButton button4 = new JButton();
		JComboBox<String> comboBox1 = new JComboBox<>();
		JRadioButton radioButton1 = new JRadioButton();
		JRadioButton radioButton2 = new JRadioButton();
		JRadioButton radioButton3 = new JRadioButton();
		JRadioButton radioButton4 = new JRadioButton();
		JTextField textField1 = new JTextField();
		JTextField textField2 = new JTextField();
		JTextField textField3 = new JTextField();
		JTextField textField4 = new JTextField();
		JTextField textField5 = new JTextField();
		JTextField textField6 = new JTextField();
		JTextField textField7 = new JTextField();
		JTextField textField8 = new JTextField();
		JTextField textField9 = new JTextField();
		JTextField textField10 = new JTextField();
		JTextField textField11 = new JTextField();
		JTextField textField12 = new JTextField();

		//Add listeners
		menu1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				menuClick(e);
			}
		});
		menu2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				menuClick(e);
			}
		});
		menu3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				menuClick(e);
			}
		});
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		comboBox1.addActionListener(this);
		radioButton1.addActionListener(this);
		radioButton2.addActionListener(this);
		radioButton3.addActionListener(this);
		radioButton4.addActionListener(this);
		textField1.addKeyListener(this);
		textField2.addKeyListener(this);
		textField3.addKeyListener(this);
		textField4.addKeyListener(this);
		textField5.addKeyListener(this);
		textField6.addKeyListener(this);
		textField7.addKeyListener(this);
		textField8.addKeyListener(this);
		textField9.addKeyListener(this);
		textField10.addKeyListener(this);
		textField11.addKeyListener(this);
		textField12.addKeyListener(this);

		//Add to array (Left-right, top-down layout logic)
		jArray[0] = panel1;
		jArray[1] = menuBar1;
		jArray[2] = menu1;
		jArray[3] = menu2;
		jArray[4] = menu3;
		jArray[5] = button1;
		jArray[6] = comboBox1;
		jArray[8] = radioButton1;
		jArray[7] = textField1;
		jArray[9] = textField2;
		jArray[10] = textField3;
		jArray[11] = button2;
		jArray[12] = textField4;
		jArray[13] = textField5;
		jArray[14] = radioButton2;
		jArray[15] = textField6;
		jArray[16] = button3;
		jArray[17] = textField7;
		jArray[18] = textField8;
		jArray[19] = radioButton3;
		jArray[20] = textField9;
		jArray[21] = button4;
		jArray[22] = textField10;
		jArray[23] = textField11;
		jArray[24] = radioButton4;
		jArray[25] = textField12;

		//Set text of components
		button1.setText("Create Key Pair");
		button2.setText("Block a file");
		button3.setText("Unblock a file");
		button4.setText("Cipher");
		comboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Generate primes", "Provide primes" }));
		radioButton1.setText("Rename output files");
		radioButton2.setText("Rename output file");
		radioButton3.setText("Rename output file");
		radioButton4.setText("Rename output file");
		textField1.setText("2 prime numbers (comma separated)");
		textField2.setText("Private key file");
		textField3.setText("Public key file");
		textField4.setText("ASCII file");
		textField5.setText("Blocking #");
		textField6.setText("Output filename");
		textField7.setText("Blocked file");
		textField8.setText("Blocking #");
		textField9.setText("Output filename");
		textField10.setText("Blocked file");
		textField11.setText("Key file");
		textField12.setText("Output filename");
		menu1.setText("Info");
		menu2.setText("About");
		menu3.setText("Help");

		//Set up menu
		menu1.add(menu2);
		menu1.add(menu3);
		menuBar1.add(menu1);
		setJMenuBar(menuBar1);


		GroupLayout panel1Layout = new GroupLayout(panel1);
		panel1.setLayout(panel1Layout);

		//Set layout of panel and all components
		panel1Layout.setHorizontalGroup(
				panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(panel1Layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
												.addGap(0, 0, Short.MAX_VALUE)
												.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(radioButton2)
														.addComponent(radioButton1)
														.addComponent(radioButton3)
														.addComponent(radioButton4)))
										.addGroup(panel1Layout.createSequentialGroup()
												.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(button2, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
														.addComponent(button3, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
														.addComponent(button4, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
												.addGap(0, 0, Short.MAX_VALUE))
										.addGroup(panel1Layout.createSequentialGroup()
												.addComponent(button1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
												.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addGroup(panel1Layout.createSequentialGroup()
												.addComponent(textField10, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
												.addComponent(textField11, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
										.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
												.addComponent(textField7, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textField8, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
										.addComponent(textField12)
										.addComponent(textField9)
										.addComponent(textField6)
										.addComponent(textField1)
										.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
												.addComponent(textField4, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textField5, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
										.addGroup(panel1Layout.createSequentialGroup()
												.addComponent(textField2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textField3, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
								.addGap(30, 30, 30))
		);
		panel1Layout.setVerticalGroup(
				panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(panel1Layout.createSequentialGroup()
								.addGap(38, 38, 38)
								.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(button1)
										.addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
								.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(radioButton1))
								.addGap(51, 51, 51)
								.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(button2)
										.addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(radioButton2))
								.addGap(35, 35, 35)
								.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(button3)
										.addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(textField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(radioButton3))
								.addGap(36, 36, 36)
								.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(button4)
										.addComponent(textField10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(textField12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(radioButton4))
								.addGap(39, 39, 39))
		);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);

		//Disable optional text fields initially
		jArray[7].setEnabled(false);
		jArray[9].setEnabled(false);
		jArray[10].setEnabled(false);
		jArray[15].setEnabled(false);
		jArray[20].setEnabled(false);
		jArray[25].setEnabled(false);

		//Set frame properties
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		//Initialize modified array to reflect no change
		modified = new int[26];

		//Name prime number file
		primesFile = "primeNumbers.rsc";
	}


	/**
	 * Changes the associated text field access status upon a change of a radio handler button.
	 * @param component
	 */
	protected int radioButtonHandler(int component){
		//Not a radio button
		int returnVal = -1;

		//If it is a radio button
		if(jArray[component] instanceof JRadioButton){
			JRadioButton b = (JRadioButton) jArray[component];
			//If it is now selected
			if(b.isSelected()){
				//Enable text field(s)
				for(int i = 1; i <= 2; i++){
					//If not out of bounds
				    if(component + i < 26) {
						if (jArray[component + i] instanceof JTextField) {
							jArray[component + i].setEnabled(true);

							//Turn on user input
							returnVal = 1;
						}
					}
				}
			}
			//Deselected
			else{
				//Disable text field(s)
				for(int i = 1; i <= 2; i++){
					//If not out of bounds
					if(component + i < 26) {
						if (jArray[component + i] instanceof JTextField) {
							jArray[component + i].setEnabled(false);

							//Turn off user input
							returnVal = 0;
						}
					}
				}
			}
		}

		return returnVal;
	}

	protected int comboBoxHandler(int component){
		//Not a combo box button
		int returnVal = -1;

		//If it is a combo box
		if(jArray[component] instanceof JComboBox){
			JComboBox cb = (JComboBox) jArray[component];
			//If the selects "Provide primes"
			if(cb.getSelectedIndex() == 1){
				//Enable text field
				if (jArray[component + 1] instanceof JTextField) {
					jArray[component + 1].setEnabled(true);

					//Turn on user input
					returnVal = 1;
				}
			}
			//Not selected
			else{
				//Disable text field
				if (jArray[component + 1] instanceof JTextField) {
					jArray[component + 1].setEnabled(false);

					//Turn off user input
					returnVal = 0;
				}

			}
		}

		return returnVal;
	}

	protected void textFieldHandler(int component){
		//If it is a text field and has not been modified
		if((jArray[component] instanceof JTextField) && (modified[component] == 0)) {
			JTextField tf = (JTextField) jArray[component];

			//Clear the text, set file extension
			if(component == 9 || component == 10 || component == 23)
				tf.setText(".xml");
			else if (component == 12 || component == 17 || component == 22)
				tf.setText(".txt");
			else
				tf.setText("");

			tf.setCaretPosition(0);

			//The component has been modified
			modified[component] = 1;
		}
	}

	protected void menuHandler(int component){
		//If it is a menu
		if(jArray[component] instanceof JMenu) {
			JMenu m = (JMenu) jArray[component];

			//If the "About" menu was selected
			if(m.getText() == "About"){
				//Instantiate a new "About" frame
				JFrame menuFrame = new JFrame("About");
				menuFrame.setPreferredSize(new Dimension(400,250));
				JPanel menuPanel = new JPanel();
				String text = "Authors:" + "<br>" + "<br>" +
						"Marek Rybakiewicz" + "<br>" +
						"mrybak3@uic.edu" + "<br>" + "<br>" +
						"Lubna Mirza" + "<br>" +
						"lmirza3@uic.edu" + "<br>" + "<br>" + "<br>" +
						"University of Illinois at Chicago" + "<br>" +
						"CS 342 Spring 2016 Project 3";
				JLabel label = new JLabel("<html><div style='text-align: center;'>" + text + "</html>");
				menuPanel.add(label,BorderLayout.CENTER);
				menuFrame.add(menuPanel);

				//Set display options
				menuFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				menuFrame.setResizable(false);
				menuFrame.pack();
				menuFrame.setLocationRelativeTo(null);
				menuFrame.setVisible(true);

			}
			//If the "Help" menu was selected
			else if (m.getText() == "Help"){
				//Instantiate a new "Help" frame
				JFrame menuFrame = new JFrame("About");
				menuFrame.setPreferredSize(new Dimension(800,450));
				JPanel menuPanel = new JPanel();
				String text = "Help:" + "<br>" + "<br>" +
						"For all 4 commands, the user has the choice to provide a filename for input and/or output. " + "<br>" +
						"The optional file text fields are initially greyed out and are only available after the user selects " + "<br>" +
						"a radio button/combo box indicating that they would like to provide optional files for processing." + "<br>" + "<br>" +
						"Create Key Pair:" + "<br>" +
						"Generates a pair of private and public keys and associated files. " + "<br>" +
						"The user has the option to provide an input file with prime numbers, and rename the output files." + "<br>" + "<br>" +
						"Block a file:" + "<br>" +
						"Takes an ASCII file along with the desired blocking size, " + "<br>" +
						"and converts to a quasi-ASCII file separated into lines with [blocking size] amounts of characters." + "<br>" + "<br>" +
						"Unblock a file:" + "<br>" +
						"Takes an already-blocked file along with a blocking number and restores it to ASCII format." + "<br>" +
						"It is the users responsibility to provide the blocking number, even though it may be assumed from the file." + "<br>" +
						"This allows for ease of modification, although it may also damage output if an incorrect number is provided" + "<br>" + "<br>" +
						"Cipher:" + "<br>" +
						"Encrypts or decrypts an already-blocked file. Outputs a file with a single character blocking number." + "<br>" +
						"The operation performed is dependent upon which key file the user provides. Key files must be in XML format";
				JLabel label = new JLabel("<html><div style='text-align: center;'>" + text + "</html>");
				menuPanel.add(label,BorderLayout.CENTER);
				menuFrame.add(menuPanel);

				//Set display options
				menuFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				menuFrame.setResizable(false);
				menuFrame.pack();
				menuFrame.setLocationRelativeTo(null);
				menuFrame.setVisible(true);

			}

		}
	}


	/**
	 * Helper of createKeyPairHandler
	 * @param p1
	 * @param p2
     */
	protected void keyIntCreator(String p1, String p2 ){
		try{
			//Create HugeInts
			HugeInt prime1 = new HugeInt(p1);
			HugeInt prime2 = new HugeInt(p2);

			//Check if prime
			//TODO
			if (new KeyPair(prime1, prime2).primality(prime1, prime2) == false) {
				JOptionPane.showMessageDialog(null, "Numbers must be prime");
				return;
			}

			//Check if p*q is greater than 16129
			HugeInt checker = new HugeInt("16129");
			HugeInt mult = prime1.multiply(prime2);
			if(!(mult.compare(mult,checker) == 0)){
				JOptionPane.showMessageDialog(null,"Product of primes must be greater than 16129");
				return;
			}

			//Create the pair of keys
			KeyPair keyPair = new KeyPair(prime1, prime2);
			keys = keyPair;


			//Check if output files are to be renamed, rename is so.
			if (((JRadioButton) jArray[8]).isSelected()) {
				//Try to store filenames and rename key files
				try {
					//Get the text
					String privateKeyFile = (((JTextField) jArray[9]).getText());
					String publicKeyFile = (((JTextField) jArray[10]).getText());

					if (privateKeyFile.trim().length() == 0 || publicKeyFile.trim().length() == 0) {
						JOptionPane.showMessageDialog(null, "You must provide a non-empty filename");
						return;
					}
					if (privateKeyFile == null && privateKeyFile.length() == 0) {
						JOptionPane.showMessageDialog(null, "You must provide a non-empty filename");
						return;
					}
					if (publicKeyFile == null && publicKeyFile.length() == 0) {
						JOptionPane.showMessageDialog(null, "You must provide a non-empty filename");
						return;
					}
					//File must end in .xml
					if (!privateKeyFile.endsWith(".xml") || !publicKeyFile.endsWith(".xml")) {
						JOptionPane.showMessageDialog(null, "Filename must end with .xml extension");
						return;
					}
					//File must be a valid name
					if (privateKeyFile.toCharArray()[0] == '.' || publicKeyFile.toCharArray()[0] == '.') {
						JOptionPane.showMessageDialog(null, "Filename must not be blank or have invalid characters");
						return;
					}

					privateKeyFile = privateKeyFile.trim();
					publicKeyFile = publicKeyFile.trim();

					//Rename the files and store locally
					keyPair.createKeyFiles(privateKeyFile, publicKeyFile);
					keys = keyPair;
				} catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null, "You must provide a non-empty filename with extension .xml");
					return;
				}
			}
			//Otherwise, default names
			keyPair.createKeyFiles("privateKeyFile.xml", "publicKeyFile.xml");
			keys = keyPair;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Key creation failed");
			return;
		}
	}

	protected void createKeyPairHandler(){
		//Check if numbers are provided
		if(modified[6] == 1){
			//Make sure input is correct
			try{
				//Check length conditions
				String[] userPrimes = ((JTextField)jArray[7]).getText().split(",", 2);
				if(userPrimes[0].trim().length() == 0 || userPrimes[1].trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "You must provide 2 integers, separated by a comma");
					return;
				}
				if(userPrimes[0] == null && userPrimes[0].length() == 0) {
					JOptionPane.showMessageDialog(null, "You must provide 2 integers, separated by a comma");
					return;
				}
				if(userPrimes[1] == null && userPrimes[1].length() == 0) {
					JOptionPane.showMessageDialog(null, "You must provide 2 integers, separated by a comma");
					return;
				}

				//Passed, return a trimmed string
				userPrimes[0] = userPrimes[0].trim();
				userPrimes[1] = userPrimes[1].trim();

				//Make sure it is an integer string
				for(char c: userPrimes[0].toCharArray()){
					if(!Character.isDigit(c)) {
						JOptionPane.showMessageDialog(null,"You must provide 2 integers");
						return;
					}
				}
				for(char c: userPrimes[1].toCharArray()){
					if(!Character.isDigit(c)) {
						JOptionPane.showMessageDialog(null,"You must provide 2 integers");
						return;
					}
				}


				//We have a valid pair of prime int strings
				keyIntCreator(userPrimes[0], userPrimes[1]);
			}
			catch(ArrayIndexOutOfBoundsException e){
				JOptionPane.showMessageDialog(null,"You must provide 2 integers, separated by a comma");
				return;
			}
			catch(NumberFormatException	e){
				JOptionPane.showMessageDialog(null,"You must provide 2 integers");
				return;
			}
		}
		//Otherwise use input file
		else
		{
			try{
				int lineCount;
				String prime1 = "0";
				String prime2 = "0";

				//Check if file exists, try to find the number of lines
				File f = new File(primesFile);
				if (f.exists() && !f.isDirectory()) {
					LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(f));
					lineNumberReader.skip(Long.MAX_VALUE);
					lineCount = lineNumberReader.getLineNumber();
					lineNumberReader.close();
				}
				else{
					JOptionPane.showMessageDialog(null,"File not found");
					return;
				}

				//File too short
				if(lineCount < 20){
					JOptionPane.showMessageDialog(null,"File must have at least 20 integers");
					return;
				}

				//Generate 2 unique random places in the file
				Random rand = new Random();
				int rand1 = 0;
				int rand2 = 0;
				while( rand1 == rand2 ) {
					rand1 = rand.nextInt(lineCount);
					rand2 = rand.nextInt(lineCount);
				}

				//Check if file exists
				f = new File(primesFile);
				if (f.exists() && !f.isDirectory()) {
					//Create file readers
					FileInputStream fs = new FileInputStream(f);
					//Construct BufferedReader from InputStreamReader
					BufferedReader br = new BufferedReader(new InputStreamReader(fs));

					//Read file and store primes
					String line = null;
					for(int i = 0; i < lineCount; i++) {
						//Read line
						if ((line = br.readLine()) != null) {
							//If non-whitespace
							if (line.trim().length() > 0){
								//Remove whitespace
								line = line.trim();
								//Check if integer
								for(char c: line.toCharArray()){
									if(!Character.isDigit(c)) {
										JOptionPane.showMessageDialog(null,"You must provide 2 integers");
										return;
									}
								}

								//Store if at random coordinate
								if(rand1 == i) {
									prime1 = line;
								}
								if(rand2 == i) {
									prime2 = line;
								}
							}
							//whitespace
							else{
								JOptionPane.showMessageDialog(null,"File must have an integer on every line");
								return;
							}
						}
						//Incorrect input file
						else{
							JOptionPane.showMessageDialog(null,"File must have at least 20 integers");
							return;
						}
					}
					//Close reader
					br.close();
				}
				//File not found
				else{
					JOptionPane.showMessageDialog(null,"File not found");
					return;
				}

				//Found and usable, so create keys
				System.out.println(prime1 + " " + prime2);
				keyIntCreator(prime1,prime2);
			}
			//Incorrect file format
			catch(Exception e){
				JOptionPane.showMessageDialog(null,"File is of incorrect format. Must be at least 20 lines with 1 prime number per line");
				return;
			}

		}
	}


	protected void blockString(String text, int blockingSize){
		//Check if file is to be renamed, rename if so
		if(((JRadioButton)jArray[14]).isSelected()){
			//Try to store filenames and rename key files
			try{
				//Get the text
				String newFileName = (((JTextField)jArray[15]).getText());

				if(newFileName.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "You must provide a non-empty filename");
					return;
				}
				if(newFileName == null && newFileName.length() == 0) {
					JOptionPane.showMessageDialog(null, "You must provide a non-empty filename");
					return;
				}
				//File must be a valid name
				if(newFileName.toCharArray()[0] == '.' || newFileName.toCharArray()[0] == '.'){
					JOptionPane.showMessageDialog(null, "Filename must not be blank or have invalid characters");
					return;
				}

				blockedFile = newFileName;

			}
			catch(ArrayIndexOutOfBoundsException e){
				JOptionPane.showMessageDialog(null,"You must provide a non-empty filename with extension .xml");
				return;
			}
		}
		//Use default name if not
		else{
			blockedFile = "blockedFile.txt";
		}

		//Create an instance of blocking, and blocks file
		Blocking b = new Blocking(blockingSize,text,0,blockedFile);
	}

    protected void blockFileHandler(){
		try {
			//Check if blocking number is an integer
			String blockingString = ((JTextField)jArray[13]).getText();
			blockingString = blockingString.trim();
			for (char c : blockingString.toCharArray()) {
				System.out.println(c);
				if (!Character.isDigit(c)) {
					JOptionPane.showMessageDialog(null, "You must provide an integer blocking number");
					return;
				}
			}
			if(blockingString.trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "You must provide an integer blocking number");
				return;
			}
			if(blockingString == null && blockingString.length() == 0) {
				JOptionPane.showMessageDialog(null, "You must provide an integer blocking number");
				return;
			}
			//Set blocking number
			int blockingNumber = Integer.parseInt(blockingString);


			//Get filename
			String fileName = ((JTextField)jArray[12]).getText();

			//Catch incorrect names
			if(fileName.trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "You must provide a non-empty filename");
				return;
			}
			if(fileName == null && fileName.length() == 0) {
				JOptionPane.showMessageDialog(null, "You must provide a non-empty filename");
				return;
			}
			//File must be a valid name
			if(fileName.toCharArray()[0] == '.'){
				JOptionPane.showMessageDialog(null, "Filename must not be blank or have invalid characters");
				return;
			}

			//Save filename temporarily
			blockedFile = fileName;
			//Save file to string (since a string can hold 2gb of text)
			String text = new Scanner(new File(blockedFile)).useDelimiter("\\Z").next();
			System.out.println(text);

			//Create blocked file
			blockString(text, blockingNumber);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"File not found or is empty");
			return;
		}
	}

	protected void unblockString(String text, int blockingSize){
		//Check if file is to be renamed, rename if so
		if(((JRadioButton)jArray[19]).isSelected()){
			//Try to store filenames and rename key files
			try{
				//Get the text
				String newFileName = (((JTextField)jArray[20]).getText());

				if(newFileName.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "You must provide a non-empty filename");
					return;
				}
				if(newFileName == null && newFileName.length() == 0) {
					JOptionPane.showMessageDialog(null, "You must provide a non-empty filename");
					return;
				}
				//File must be a valid name
				if(newFileName.toCharArray()[0] == '.' || newFileName.toCharArray()[0] == '.'){
					JOptionPane.showMessageDialog(null, "Filename must not be blank or have invalid characters");
					return;
				}

				unblockedFile = newFileName;

			}
			catch(ArrayIndexOutOfBoundsException e){
				JOptionPane.showMessageDialog(null,"You must provide a non-empty filename with extension .xml");
				return;
			}
		}
		//Use default name if not
		else{
			unblockedFile = "unblockedFile.txt";
		}

		//Create an instance of blocking, and unblocks file
		Blocking b = new Blocking(blockingSize,text,1,unblockedFile);
	}

	protected void unblockFileHandler(){
		try {
			//Check if blocking number is an integer
			String blockingString = ((JTextField)jArray[18]).getText();
			blockingString = blockingString.trim();
			for (char c : blockingString.toCharArray()) {
				if (!Character.isDigit(c)) {
					JOptionPane.showMessageDialog(null, "You must provide an integer blocking number");
					return;
				}
			}
			if(blockingString.trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "You must provide an integer blocking number");
				return;
			}
			if(blockingString == null && blockingString.length() == 0) {
				JOptionPane.showMessageDialog(null, "You must provide an integer blocking number");
				return;
			}
			//Set blocking number
			int blockingNumber = Integer.parseInt(blockingString);




			//Get filename
			String fileName = ((JTextField)jArray[17]).getText();

			//Catch incorrect names
			if(fileName.trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "You must provide a non-empty filename");
				return;
			}
			if(fileName == null && fileName.length() == 0) {
				JOptionPane.showMessageDialog(null, "You must provide a non-empty filename");
				return;
			}
			//File must be a valid name
			if(fileName.toCharArray()[0] == '.'){
				JOptionPane.showMessageDialog(null, "Filename must not be blank or have invalid characters");
				return;
			}

			//Save filename temporarily
			unblockedFile = fileName;
			//Save file to string (since a string can hold 2gb of text)
			String text = new Scanner(new File(unblockedFile)).useDelimiter("\\Z").next();

			//Create unblocked file
			unblockString(text, blockingNumber);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"File not found or is empty");
			return;
		}
	}

	protected void cipherHandler() {
		try {
			//Get filename
			String blockedFileName = ((JTextField)jArray[22]).getText();
			String keyFileName	= ((JTextField)jArray[23]).getText();

			//Catch incorrect names
			if(blockedFileName.trim().length() == 0 || keyFileName.trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "You must provide a non-empty filename");
				return;
			}
			if(blockedFileName == null && blockedFileName.length() == 0) {
				JOptionPane.showMessageDialog(null, "You must provide a non-empty filename");
				return;
			}
			if(keyFileName == null && keyFileName.length() == 0) {
				JOptionPane.showMessageDialog(null, "You must provide a non-empty filename");
				return;
			}
			//File must be a valid name
			if(blockedFileName.toCharArray()[0] == '.'  || keyFileName.toCharArray()[0] == '.' ){
				JOptionPane.showMessageDialog(null, "Filename must not be blank or have invalid characters");
				return;
			}
			//File must end in .xml
			if (!keyFileName.endsWith(".xml")) {
				JOptionPane.showMessageDialog(null, "Filename must end with .xml extension");
				return;
			}

			//Save filenames temporarily
			blockedFile = blockedFileName;
			keyFile = keyFileName;
			String outputCipherFile = " ";

			//Check if output files are to be renamed, rename is so.
			if (((JRadioButton) jArray[24]).isSelected()) {
				//Try to store filenames and rename key files
				//Get the text
				outputCipherFile = (((JTextField) jArray[25]).getText());

				if (outputCipherFile.trim().length() == 0 || outputCipherFile.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "You must provide a non-empty filename");
					return;
				}
				if (outputCipherFile == null && outputCipherFile.length() == 0) {
					JOptionPane.showMessageDialog(null, "You must provide a non-empty filename");
					return;
				}
				//File must be a valid name
				if (outputCipherFile.toCharArray()[0] == '.') {
					JOptionPane.showMessageDialog(null, "Filename must not be blank or have invalid characters");
					return;
				}

				//Rename file and store locally
				outputCipherFile = outputCipherFile.trim();
			}

			//Save file to string (since a string can hold 2gb of text)
			String text = new Scanner(new File(blockedFile)).useDelimiter("\\Z").next();
			String keyText = new Scanner(new File(keyFile)).useDelimiter("\\Z").next();

			//Handle ciphering
			Cipher cipher = new Cipher(text, keyText,outputCipherFile);


		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "File not found or is empty");
			return;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Try to identify the position of the component in the array
		int component = -1;
		for(int i = 0; i < 26; i++){
			if ( jArray[i] == e.getSource()){
				component = i;
			}
		}
		//Error if component not found
		if(component == -1){
			System.out.print("ERROR: Could not find component");
			return;
		}

		System.out.println(component);

		//Handle radio buttons
		if(jArray[component] instanceof JRadioButton)
			modified[component] = radioButtonHandler(component);

		//Handle the combo box
		if(jArray[component] instanceof JComboBox)
			modified[component] = comboBoxHandler(component);

		//Handle the Create Key Pair button
		if(e.getActionCommand() == "Create Key Pair")
			createKeyPairHandler();

		//Handle the Block button
		if(e.getActionCommand() == "Block a file")
			blockFileHandler();

		//Handle the Unblock button
		if(e.getActionCommand() == "Unblock a file")
			unblockFileHandler();

		//Handle the Cipher button
		if(e.getActionCommand() == "Cipher")
			cipherHandler();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//Try to identify the position of the component in the array
		int component = -1;
		for(int i = 0; i < 26; i++){
			if ( jArray[i] == e.getSource()){
				component = i;
			}
		}
		//Error if component not found
		if(component == -1){
			System.out.print("ERROR: Could not find component");
			return;
		}

		//Handle text fields
		textFieldHandler(component);

	}


	public void menuClick(MouseEvent e) {
		//Try to identify the position of the component in the array
		int component = -1;
		for(int i = 0; i < 26; i++){
			if ( jArray[i] == e.getSource()){
				component = i;
			}
		}
		//Error if component not found
		if(component == -1){
			System.out.print("ERROR: Could not find component");
			return;
		}

		//Handle menu display
		menuHandler(component);

	}


	/**
	 * Processes the user input, determining the file, blocking size, and whether to
	 * block or unblock the file.
	 *
	 * Execution is then passed to Blocking which is instantiated in a local
	 * data member and performs the desired blocking operation, as well as storing the
	 * resulting file names.
	 *
	 * @param userInput
	 */
	public int createBlock(String[] userInput){
		return 0;
	}

	/**
	 * Processes the user input, determining whether a file name was provided or not
	 * and what type of command to execute, and passes execution to Cipher by
	 * instantiating the class in a local data member.
	 *
	 * An encrypted/decrypted file is created based on the input.
	 *
	 * @param userInput
	 * @param keys
	 */
	public int createCipher(String[] userInput, KeyPair keys){
		return 0;
	}

	/**
	 * Processes the user input and determines whether a file was provided or not,
	 * then passes execution over to KeyPair by instantiating the class as a
	 * local data member, therefore creating the key pairs along with any relevant
	 * information.
	 *
	 * @param userInput
	 */
	protected void createKey(String[] userInput){

	}


	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}


}
