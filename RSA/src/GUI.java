import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
public class GUI extends JFrame implements MouseListener {

	/**
	 * An instance of Blocking, which blocks/unblocks a file based on blocking
	 * size and stores the resulting file name.
	 */
	protected Blocking blocks;
	/**
	 * An array of buttons that stores the 4 options the user may click on, all with
	 * attached mouse listener.
	 */
	protected JButton[] buttons;
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
	 * Stores the 4 radio buttons that correspond to the 4 user commands, a button is
	 * checked if the user intends to provide custom parameters
	 */
	protected JRadioButton[] radioButtons;
	/**
	 * The panel inside of the GUI window that will hold buttons and labels
	 * Instantiated in the constructor.
	 */
	protected JPanel panel;
	/**
	 * Stores the 4 text fields associated with the 4 user commands, a text field is
	 * used to input custom files or file names
	 */
	protected JTextField[] textFields;


//	//Not used
//	public void finalize() throws Throwable {
//
//	}


	/**
	 * Creates the user interface and handles all user-program interactions/initializations.
	 * 
	 * The primary constructor instantiates the other classes and creates the GUI frame and grids,
	 * at which point execution is passed over to an infinite user interaction loop.
	 */
	public GUI(){


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

	/**
	 * A method required to implement MouseListener. Does nothing.
	 * 
	 * @param e
	 */
	public void mouseClicked(MouseEvent e){

	}

	/**
	 * A method required to implement MouseListener. Does nothing.
	 * 
	 * @param e
	 */
	public void mouseEntered(MouseEvent e){

	}

	/**
	 * A method required to implement MouseListener. Does nothing.
	 * 
	 * @param e
	 */
	public void mouseExited(MouseEvent e){

	}

	/**
	 * A method required to implement MouseListener. Does nothing.
	 * 
	 * @param e
	 */
	public void mousePressed(MouseEvent e){

	}

	/**
	 * A method required to implement MouseListener.
	 * 
	 * Handles the user input loop by processing any mouse releases that occur. Passes
	 * execution to helper methods which perform the RSA tasks, and exits the program
	 * upon the user exiting the GUI.
	 * 
	 * @param e
	 */
	public void mouseReleased(MouseEvent e){

	}

}