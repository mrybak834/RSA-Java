import javax.swing.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

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
	 * The primary constructor takes the private and public keys as well as the type
	 * of ciphering to be done and the file name and passes execution to helper
	 * methods which encrypt or decrypt an already-blocked message file, which is then
	 * stored in a corresponding file that the user can choose to name. The name of
	 * the file is stored into the data member.
	 *
	 * @param message
	 */
	public Cipher(String message, String keyFileText, String outputFileName){

		try {
			//Determine which key is provided

			System.out.println(message);
			System.out.println(keyFileText);
			System.out.println(outputFileName);

			//0 if encryption, 1 if decryption
			int type = 0;

			//If string contains e, public key therefore encrypt.
			if(keyFileText.contains("<evalue>")){
				type = 0;
			}
			else if (keyFileText.contains("<dvalue>")){
				type = 1;
			}
			else{
				JOptionPane.showMessageDialog(null, "Key file has incorrect format");
				return;
			}

			if (type == 0) {
				if (outputFileName.equals(" "))
					encrypt(message, keyFileText, "encryptedText.txt");
				else
					encrypt(message, keyFileText, outputFileName);
			} else {
				if (outputFileName.equals(" "))
					decrypt(message, keyFileText, "decryptedText.txt");
				else
					decrypt(message, keyFileText, outputFileName);

			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error reading files for ciphering");
			return;
		}
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
	protected void decrypt(String message, String keyFileText, String outputFileName){

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
	protected void encrypt(String message, String keyFileText, String outputFileName){

	}

}