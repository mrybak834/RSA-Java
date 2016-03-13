import java.util.Vector;

/**
 * Handles all operations on RSA key values.
 * 
 * The data members are the private key, the public key, and the associated N and
 * Phi values used in key creation. The name of the prime number list file is
 * stored, alongside the names of the files in which the key values are located.
 * 
 * 
 * The primary constructor KeyPair takes two prime number values. A
 * call is made to the super class's dummy default constructor, then a check to
 * see if the values are prime and of correct cardinality based on the
 * blocking number. The data members are then generated from the values,
 * and finally XML files are created for the private and public keys respectively.
 * 
 * 
 * The secondary constructor KeyPair is used when prime numbers are
 * supposed to be read from a file. Two prime numbers are gathered and stored as
 * strings and new values are created from them. The primary KeyPair
 * constructor is then called on those values.
 * 
 * The first file processing method takes a file of prime numbers and create new
 * values from them, and the second stores the data members into 2 XML
 * files for the private and public key.
 * 
 * The key handler methods check if the given value is prime, and generate the
 * public key, private key, as well as the n and phi values.
 *
 * @version     1.0.0
 * @university  University of Illinois at Chicago
 * @course      CS342 - Software Design
 * @package     Project #03 - RSA-Java
 * @author      Marek Rybakiewicz
 * @author      Lubna Mirza
 * @license     GNU Public License <http://www.gnu.org/licenses/gpl-3.0.txt>
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
	 * The n value used in the decryption algorithm. The result of multiplying
	 * the two associated prime numbers values. 
	 */
	protected HugeInt nKey;
	/**
	 * The value needed to generate the key pair. 
	 */
	private HugeInt phi;
	/**
	 * Holds the local prime number list initially, but can be changed to accept a
	 * user-generated list. 
	 */
	protected String primesFile;
	/**
	 * A value representation of the private RSA key
	 */
	protected HugeInt privateKey;
	/**
	 * A value representation of the public RSA key
	 */
	protected HugeInt publicKey;

	public KeyPair(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * The primary constructor takes two prime number values. A helper method
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
	public KeyPair(HugeInt p1, HugeInt p2){

	}

	/**
	 * The secondary constructor takes a file that contains prime numbers and picks 2
	 * valid primes of correct magnitude and creates new values out of them.
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
	 * @param keys
	 */
	protected void createKeyFiles(KeyPair keys){

	}

	/**
	 * Takes 2 valid prime values and creates the N key, which is the result of
	 * multiplying the 2 values together by calling the super class's multiply
	 * method.
	 * 
	 * @param p1
	 * @param p2
	 */
	protected void createNKey(HugeInt p1, HugeInt p2){

	}

	/**
	 * Creates the phi value that is needed in order to generate the key pair.
	 * Stores the value in the data member.
	 * 
	 * phi = (p1 - 1) * (p2 - 1)
	 * 
	 * @param p1
	 * @param p2
	 */
	private void createPhi(HugeInt p1, HugeInt p2){

	}


	/**
	 * Creates the public key, which is the first one to be created.
	 *
	 * Public key (e) = a value that is less than NKey and is relatively prime to phi.
	 *
	 * @param phi
	 * @param nKey
	 */
	public int createPublicKey(HugeInt phi, KeyPair nKey){
		return 0;
	}

	/**
	 * Creates the private key, which is the second key to be created since it relies
	 * on the public key.
	 * 
	 * Private key (d) = (1 + (k)(phi)) / publicKey,
	 * where k is an integer value such that (1 + (k)(phi)) can be evenly divided by
	 * the public key.
	 * 
	 * @param keys
	 * @param phi
	 */
	public int createPrivateKey(KeyPair keys, HugeInt phi){
		return 0;
	}


	/**
	 * Takes 2 prime number values and returns true only if both of the values
	 * are prime numbers and are large enough (greater than 127 and a cardinality
	 * greater than the blocking number) to be used. If one of the values is
	 * not usable, a new correct value replaces the unusable value.
	 * 
	 * @param p1
	 * @param p2
	 */
	protected boolean primality(HugeInt p1, HugeInt p2){
		return false;
	}

}