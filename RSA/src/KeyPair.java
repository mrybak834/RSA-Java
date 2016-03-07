package RSA;


/**
 * Handles all operations on RSA key values.
 * 
 * The data members are the private key, the public key, and the associated N and
 * Phi values used in key creation. The name of the prime number list file is
 * stored, alongside the names of the files in which the key values are located.
 * 
 * 
 * The primary constructor <b>KeyPair </b>takes two prime number <b>value</b>s. A
 * call is made to the super class's dummy default constructor, then a check to
 * see if the <b>value</b>s are prime and of correct cardinality based on the
 * blocking number. The data members are then generated from the <b>value</b>s,
 * and finally XML files are created for the private and public keys respectively.
 * 
 * 
 * The secondary constructor <b>KeyPair</b> is used when prime numbers are
 * supposed to be read from a file. Two prime numbers are gathered and stored as
 * strings and new <b>value</b>s are created from them. The primary <b>KeyPair</b>
 * constructor is then called on those values.
 * 
 * The first file processing method takes a file of prime numbers and create new
 * <b>value</b>s from them, and the second stores the data members into 2 XML
 * files for the private and public key.
 * 
 * The key handler methods check if the given value is prime, and generate the
 * public key, private key, as well as the n and phi values.
 * @version 1.0
 * @created 06-Mar-2016 9:11:06 PM
 */
public class KeyPair extends HugeInt {

	/**
	 * An array that stores the names of the 2 files that hold key information. Useful
	 * if the user chooses to rename the files before creation.
	 * 
	 * Default file names are set in the constructor. 
	 */
	protected String[] keyFiles;
	/**
	 * The n <b>value</b> used in the decryption algorithm. The result of multiplying
	 * the two associated prime numbers <b>value</b>s. 
	 */
	protected value nKey;
	/**
	 * The <b>value</b> needed to generate the key pair. 
	 */
	private value phi;
	/**
	 * Holds the local prime number list initially, but can be changed to accept a
	 * user-generated list. 
	 */
	protected String primesFile;
	/**
	 * A <b>value</b> representation of the private RSA key
	 */
	protected value privateKey;
	/**
	 * A <b>value</b> representation of the public RSA key
	 */
	protected value publicKey;

	public KeyPair(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * The primary constructor takes two prime number<b> value</b>s. A helper method
	 * checks the primality and cardinality, after which execution is passed to other
	 * methods that create the key pairs via trial and error and store them in the
	 * data members.
	 * 
	 * Lastly, these values are stored into 2 files based on the private and public
	 * key. The constructor generates the file names, which may be overridden by the
	 * user and are stored in the data member.
	 * 
	 * @param p1
	 * @param p2
	 */
	public KeyPair(value p1, value p2){

	}

	/**
	 * The secondary constructor takes a file that contains prime numbers and picks 2
	 * valid primes of correct magnitude and creates new <b>value</b>s out of them.
	 * Execution is then passed to the primary constructor.
	 * 
	 * @param file
	 */
	public KeyPair(String file){

	}

	/**
	 * Creates 2 key files: one that stores the private key, and one that stores the
	 * public key, along with both files storing the nKey value.
	 * The files are stored in XML format.
	 * 
	 * A prompt asks the user before file generation if they would like to rename the
	 * files, and the names of the files are stored locally.
	 * 
	 * @param publicKey
	 * @param privateKey
	 * @param nKey
	 */
	protected createKeyFiles(value publicKey, value privateKey, value nKey){

	}

	/**
	 * Takes 2 valid prime <b>value</b>s and creates the N key, which is the result of
	 * multiplying the 2 <b>value</b>s together by calling the super class's multiply
	 * method.
	 * 
	 * @param p1
	 * @param p2
	 */
	protected createNKey(value p1, value p2){

	}

	/**
	 * Creates the phi <b>value</b> that is needed in order to generate the key pair.
	 * Stores the <b>value </b>in the data member.
	 * 
	 * phi = (p1 - 1) * (p2 - 1)
	 * 
	 * @param p1
	 * @param p2
	 */
	private createPhi(value p1, value p2){

	}

	/**
	 * Creates the private key, which is the second key to be created since it relies
	 * on the public key.
	 * 
	 * Private key (d) = (1 + (k)(phi)) / publicKey,
	 * where k is an integer value such that (1 + (k)(phi)) can be evenly divided by
	 * the public key.
	 * 
	 * @param publicKey
	 * @param phi
	 */
	public int createPrivateKey(value publicKey, value phi){
		return 0;
	}

	/**
	 * Creates the public key, which is the first one to be created.
	 * 
	 * Public key (e) = a value that is less than NKey and is relatively prime to phi.
	 * 
	 * @param phi
	 * @param nKey
	 */
	public int createPublicKey(value phi, value nKey){
		return 0;
	}

	/**
	 * Takes 2 prime number <b>value</b>s and returns true only if both of the values
	 * are prime numbers and are large enough (greater than 127 and a cardinality
	 * greater than the blocking number) to be used. If one of the <b>value</b>s is
	 * not usable, a new correct <b>value</b> replaces the unusable <b>value</b>.
	 * 
	 * @param p1
	 * @param p2
	 */
	protected boolean primality(value p1, value p2){
		return false;
	}

}