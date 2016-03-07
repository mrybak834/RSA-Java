package RSA;


/**
 * Handles blocking and unblocking of message files.
 * 
 * A blocking size must be provided by the user as well as an input file name and
 * whether to block or unblock the file.
 * 
 * The resulting file name is stored in the local data member.
 * @author mrybak834
 * @version 1.0
 * @created 06-Mar-2016 9:11:05 PM
 */
public class Blocking {

	/**
	 * Stores the names of the blocked and unblocked files
	 */
	protected String[] fileNames;
	public GUI m_GUI;

	public Blocking(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * Takes a message file along with the blocking size and an indicator whether to
	 * block or unblock.
	 * 
	 * Execution is passed to the corresponding method based on the indicator.
	 * 
	 * @param blockingSize
	 * @param message
	 * @param type
	 */
	public Blocking(int blockingSize, String message, int type){

	}

	/**
	 * Takes a blocking size along with the corresponding message file name, and
	 * splits the message into <b>blockingSize</b> sections, which are then stored
	 * into a new file that a user is allowed to name.
	 * 
	 * The result is a quasi-ASCII file, with file name stored in the local data
	 * member.
	 * 
	 * @param blockingSize
	 * @param message
	 */
	protected block(int blockingSize, String message){

	}

	/**
	 * Takes a blocking size along with the corresponding message file name, and re-
	 * combines a split message based on the <b>blockingSize</b>, storing the new
	 * message in a file.
	 * 
	 * The result is an ASCII file, with the file name stored in the local data member.
	 * 
	 * 
	 * @param blockingSize
	 * @param message
	 */
	protected unBlock(int blockingSize, String message){

	}

}