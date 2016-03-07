package RSA;


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
 * specifically <b>mouseReleased </b>which toggles one of the 4 RSA options and
 * handles user input and instance variable processing.
 * @author mrybak834
 * @version 1.0
 * @created 06-Mar-2016 9:11:06 PM
 */
public class GUI {

	/**
	 * An instance of <b>Blocking</b>, which blocks/unblocks a file based on blocking
	 * size and stores the resulting file name.
	 */
	protected Blocking blocks;
	/**
	 * An instance of <b>Cipher</b>, which encrypts/decrypts a blocked file and holds
	 * the filename.
	 */
	protected Cipher ciphers;
	/**
	 * An instance of Keypair, which holds the private and public keys along with
	 * required information.
	 */
	protected KeyPair keys;
	/**
	 * The GUI window that will hold all of the associated graphical items.
	 * 
	 * Instantiated in the constructor. 
	 */
	protected Jframe rsaGUI;

	public GUI(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * Processes the user input, determining the file, blocking size, and whether to
	 * block or unblock the file.
	 * 
	 * Execution is then passed to <b>Blocking</b> which is instantiated in a local
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
	 * and what type of command to execute, and passes execution to <b>Cipher</b> by
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
	 * then passes execution over to <b>KeyPair</b> by instantiating the class as a
	 * local data member, therefore creating the key pairs along with any relevant
	 * information.
	 * 
	 * @param userInput
	 */
	protected createKey(String[] userInput){

	}

	/**
	 * A method required to implement MouseListener. Does nothing.
	 * 
	 * @param e
	 */
	public mouseClicked(MouseEvent e){

	}

	/**
	 * A method required to implement MouseListener. Does nothing.
	 * 
	 * @param e
	 */
	public mouseEntered(MouseEvent e){

	}

	/**
	 * A method required to implement MouseListener. Does nothing.
	 * 
	 * @param e
	 */
	public mouseExited(MouseEvent e){

	}

	/**
	 * A method required to implement MouseListener. Does nothing.
	 * 
	 * @param e
	 */
	public mousePressed(MouseEvent e){

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
	public mouseReleased(MouseEvent e){

	}

}