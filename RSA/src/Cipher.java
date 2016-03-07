package RSA;


/**
 * Handles encryption and decryption of a message file based on the public and
 * private keys, and an indicator of what type of cipher is to occur.
 * 
 * The parameter file must be already blocked.
 * 
 * The default constructor takes the parameters and passes execution over to
 * <b>encrypt</b> or <b>decrypt</b> which perform the corresponding operation on
 * the file, with the result being stored in a new file that can have a user-
 * selected name.
 * @author mrybak834
 * @version 1.0
 * @created 06-Mar-2016 9:11:05 PM
 */
public class Cipher {

	/**
	 * The names of the encrypted and decrypted files.
	 */
	protected String[] fileNames;
	public GUI m_GUI;

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
	 * @param publicKey
	 * @param privateKey
	 * @param type
	 * @param message
	 */
	public Cipher(value publicKey, value privateKey, int type, String message){

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
	 * @param privateKey
	 * @param nKey
	 */
	protected decrypt(value privateKey, value nKey){

	}

	/**
	 * Uses the public key and the corresponding n value along with a message file to
	 * encrypt a message file, which is then stored into a new file.
	 * 
	 * The encryption algorithm is:
	 * 
	 * NewFile = Message<sup>publicKey  </sup>mod n
	 * 
	 * @param publicKey
	 * @param nKey
	 */
	protected encrypt(value publicKey, value nKey){

	}

}