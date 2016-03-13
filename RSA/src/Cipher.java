/**
 * Handles encryption and decryption of a message file based on the public and
 * private keys, and an indicator of what type of cipher is to occur.
 * 
 * The parameter file must be already blocked.
 * 
 * The default constructor takes the parameters and passes execution over to
 * encrypt or decrypt which perform the corresponding operation on
 * the file, with the result being stored in a new file that can have a user-
 * selected name.
 *
 * @version     1.0.0
 * @university  University of Illinois at Chicago
 * @course      CS342 - Software Design
 * @package     Project #03 - RSA-Java
 * @author      Marek Rybakiewicz
 * @author      Lubna Mirza
 * @license     GNU Public License <http://www.gnu.org/licenses/gpl-3.0.txt>
 */
public class Cipher {

	/**
	 * The names of the encrypted and decrypted files.
	 */
	protected String[] fileNames;
	public GUI rsaGUI;

	public Cipher(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * The primary constructor takes the private and public keys as well as the type
	 * of ciphering to be done and the file name and passes execution to helper
	 * methods which encrypt or decrypt an already-blocked message file, which is then
	 * stored in a corresponding file that the user can choose to name. The name of
	 * the file is stored into the data member.
	 * 
	 * @param keys
	 * @param type
	 * @param message
	 */
	public Cipher(KeyPair keys, int type, String message){

	}

	/**
	 * Uses the private key and the corresponding n value along with a message file to
	 * decrypt an already-encrypted message file, which is then stored into a new file.
	 * 
	 * 
	 * The decryption algorithm is:
	 * 
	 * Message = EncryptedMessage<sup>privateKey</sup> mod n
	 * 
	 * @param keys
	 */
	protected void decrypt(KeyPair keys){

	}

	/**
	 * Uses the public key and the corresponding n value along with a message file to
	 * encrypt a message file, which is then stored into a new file.
	 * 
	 * The encryption algorithm is:
	 * 
	 * NewFile = Message<sup>publicKey  </sup>mod n
	 * 
	 * @param keys
	 */
	protected void encrypt(KeyPair keys){

	}

}