import com.sun.corba.se.impl.logging.OMGSystemException;
import jdk.nashorn.internal.runtime.Context;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
public class GUI extends JFrame implements ActionListener, KeyListener, MenuListener {

	/**
	 * An array of all components stored on the JFrame
	 */
	JComponent[] jArray;

	/**
	 * An array to track which components have been modified
	 */
	int[] modified;

	protected JFrame menu1;
	protected JFrame menu2;

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
	 * An instance of Blocking, which blocks/unblocks a file based on blocking
	 * size and stores the resulting file name.
	 */
	protected Blocking blocks;

	/**
	 * Creates new GUI
	 */
	public GUI() {
		//Create a frame
		super("RSA");
		
		//Create array that holds all components
		jArray = new JComponent[26];

		//Create components
		JPanel panel1 = new javax.swing.JPanel();
		JMenuBar menuBar1 = new javax.swing.JMenuBar();
		JMenu menu1 = new javax.swing.JMenu();
		JMenu menu2 = new javax.swing.JMenu();
		JMenu menu3 = new javax.swing.JMenu();
		JButton button1 = new javax.swing.JButton();
		JButton button2 = new javax.swing.JButton();
		JButton button3 = new javax.swing.JButton();
		JButton button4 = new javax.swing.JButton();
		JComboBox<String> comboBox1 = new javax.swing.JComboBox<>();
		JRadioButton radioButton1 = new javax.swing.JRadioButton();
		JRadioButton radioButton2 = new javax.swing.JRadioButton();
		JRadioButton radioButton3 = new javax.swing.JRadioButton();
		JRadioButton radioButton4 = new javax.swing.JRadioButton();
		JTextField textField1 = new javax.swing.JTextField();
		JTextField textField2 = new javax.swing.JTextField();
		JTextField textField3 = new javax.swing.JTextField();
		JTextField textField4 = new javax.swing.JTextField();
		JTextField textField5 = new javax.swing.JTextField();
		JTextField textField6 = new javax.swing.JTextField();
		JTextField textField7 = new javax.swing.JTextField();
		JTextField textField8 = new javax.swing.JTextField();
		JTextField textField9 = new javax.swing.JTextField();
		JTextField textField10 = new javax.swing.JTextField();
		JTextField textField11 = new javax.swing.JTextField();
		JTextField textField12 = new javax.swing.JTextField();

		//Add listeners
		menu1.addMenuListener(this);
		menu2.addMenuListener(this);
		menu3.addMenuListener(this);
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
		comboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Generate primes", "Provide primes" }));
		radioButton1.setText("Rename output files");
		radioButton2.setText("Rename output file");
		radioButton3.setText("Rename output file");
		radioButton4.setText("Rename output file");
		textField1.setText("Prime number input file");
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
		menu1.setText("Help");
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
				panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panel1Layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
												.addGap(0, 0, Short.MAX_VALUE)
												.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(radioButton2)
														.addComponent(radioButton1)
														.addComponent(radioButton3)
														.addComponent(radioButton4)))
										.addGroup(panel1Layout.createSequentialGroup()
												.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(0, 0, Short.MAX_VALUE))
										.addGroup(panel1Layout.createSequentialGroup()
												.addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
												.addComponent(comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(panel1Layout.createSequentialGroup()
												.addComponent(textField10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
												.addComponent(textField11, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
												.addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textField8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(textField12)
										.addComponent(textField9)
										.addComponent(textField6)
										.addComponent(textField1)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
												.addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(panel1Layout.createSequentialGroup()
												.addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(30, 30, 30))
		);
		panel1Layout.setVerticalGroup(
				panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panel1Layout.createSequentialGroup()
								.addGap(38, 38, 38)
								.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(button1)
										.addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
								.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(radioButton1))
								.addGap(51, 51, 51)
								.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(button2)
										.addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(textField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(radioButton2))
								.addGap(35, 35, 35)
								.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(button3)
										.addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(textField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(textField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(radioButton3))
								.addGap(36, 36, 36)
								.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(button4)
										.addComponent(textField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(textField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(textField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(radioButton4))
								.addGap(39, 39, 39))
		);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);

		//Disable optional text fields initially
		jArray[7].setEnabled(false);
		jArray[9].setEnabled(false);
		jArray[10].setEnabled(false);
		jArray[15].setEnabled(false);
		jArray[20].setEnabled(false);
		jArray[25].setEnabled(false);

		//Set frame properties
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		//Initialize modified array to reflect no change
		modified = new int[26];
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
				for(int i = 1; i <= 5; i++){
					//If not out of bounds
				    if(component + i < 26) {
						if (jArray[component + i] instanceof JTextField) {
							jArray[component + i].setEnabled(true);

							//Turn on user input
							returnVal = 1;
							modified[component + i] = 1;
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
							modified[component + i] = 0;
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
					modified[component + 1] = 1;
				}
			}
			//Not selected
			else{
				//Disable text field
				if (jArray[component + 1] instanceof JTextField) {
					jArray[component + 1].setEnabled(false);

					//Turn off user input
					returnVal = 0;
					modified[component + 1] = 0;
				}

			}
		}

		return returnVal;
	}

	protected void textFieldHandler(int component){
		//If it is a text field and has not been modified
		if((jArray[component] instanceof JTextField) && (modified[component] == 0)) {
			JTextField tf = (JTextField) jArray[component];

			//Clear the text
			tf.setText("");

			//The component has been modified
			modified[component] = 1;
		}
	}

	protected void menuHandler(int component){
		//If it is a menu
		if(jArray[component] instanceof JMenu) {
			JMenu m = (JMenu) jArray[component];

			System.out.println(m.getText());

			//If the "About menu was selected
			if(m.getText() == "About"){
				JFrame menuFrame = new JFrame("About");
				menuFrame.setPreferredSize(new Dimension(200,200));
				JPanel menuPanel = new JPanel(new GridLayout(1,1));
				menuPanel.setPreferredSize(new Dimension(200,200));
				JLabel menuLabel = new JLabel("This is the about menu");
				menuLabel.setPreferredSize(new Dimension(200,200));

				menuPanel.add(menuLabel);
				menuFrame.add(menuPanel);

				menuFrame.pack();
				menuFrame.setVisible(true);
				menuFrame.setResizable(false);


			}

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

		//Handle radio buttons
		radioButtonHandler(component);

		//Handle the combo box
		comboBoxHandler(component);

		//Handle the Generate Primes button

		//Handle the Block button

		//Handle the Unblock button

		//Handle the Cipher button
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

	@Override
	public void menuSelected(MenuEvent e) {
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


	@Override
	public void menuDeselected(MenuEvent e) {

	}

	@Override
	public void menuCanceled(MenuEvent e) {

	}

}
