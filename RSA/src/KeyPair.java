import javax.swing.*;
import java.io.PrintWriter;
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
		createNKey(p1,p2);
		createPhi(p1,p2);








		publicKey = p1;
		privateKey = p2;
	}

	/**
	 * Creates 2 key files: one that stores the private key, and one that stores the
	 * public key, along with both files storing the nKey value.
	 * The files are stored in XML format.
	 *
	 */
	protected void createKeyFiles(String privateFileName, String publicFileName){
		//Ends in xml, everything working, proceed
		try{
			//Create a new private key file
			PrintWriter writer = new PrintWriter(privateFileName, "UTF-8");

			writer.println("<rsakey>");
			writer.print("	<dvalue>");

			//Print key
			for(int i: privateKey.digitArr){
				writer.print(i);
			}

			writer.println("</dvalue>");


			writer.print("	<nvalue>");
			//Print key
			for(int i: nKey.digitArr){
				writer.print(i);
			}
			writer.println("</nvalue>");

			writer.print("</rsakey>");

			writer.close();




			//Create a new public key file
			writer = new PrintWriter(publicFileName, "UTF-8");

			writer.println("<rsakey>");
			writer.print("	<evalue>");

			//Print key
			for(int i: publicKey.digitArr){
				writer.print(i);
			}
			writer.println("</evalue>");


			writer.print("	<nvalue>");
			//Print key
			for(int i: nKey.digitArr){
				writer.print(i);
			}
			writer.println("</nvalue>");

			writer.print("</rsakey>");

			writer.close();


		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Keys could not be written to file");
			return;
		}
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
		nKey = p1.multiply(p2);
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
		HugeInt p1sub = p1.subtract(new HugeInt("1"));
		HugeInt p2sub = p2.subtract(new HugeInt("1"));

		phi = p1sub.multiply(p2sub);
	}



	private static boolean relativelyPrime(HugeInt a, HugeInt b) {
		HugeInt t;
		while(b.compare(b, new HugeInt("0")) == 0 || b.compare(b, new HugeInt("0")) == 3){
			t = a;
			a = b;
			b = t.mod(b);
		}
		return a.compare(a, new HugeInt("1")) == 2;
	}

	/**
	 * Creates the public key, which is the first one to be created.
	 *
	 * Public key (e) = a value that is less than NKey and is relatively prime to phi.
	 *

	 */
	public void createPublicKey(){
		HugeInt e = nKey.subtract(new HugeInt("1"));

		while(!relativelyPrime(e, phi)){
			if(e.compare(e, new HugeInt("0")) == 2){
				JOptionPane.showMessageDialog(null, "Could not produce a public key");
				return;
			}

			e = e.subtract(new HugeInt("1"));
		}

		publicKey = e;
	}

	/**
	 * Creates the private key, which is the second key to be created since it relies
	 * on the public key.
	 * 
	 * Private key (d) = (1 + (k)(phi)) / publicKey,
	 * where k is an integer value such that (1 + (k)(phi)) can be evenly divided by
	 * the public key.
	 *
	 */
	public int createPrivateKey(){
		//Create dividend
		HugeInt dividend = new HugeInt("1");
		dividend = dividend.add(phi);


		return 0;
	}


	/**
	 * Takes 2 prime number values and returns true only if both of the values
	 * are prime numbers and are large enough (greater than 127 and a cardinality
	 * greater than the blocking number) to be used.
	 * 
	 * @param p1
	 */
	protected boolean primality(HugeInt p1) {
		if (p1.compare(p1, new HugeInt("1")) == 1 || p1.compare(p1, new HugeInt("1")) == 2) {
			return false;
		} else if (p1.compare(p1, new HugeInt("3")) == 1 || p1.compare(p1, new HugeInt("3")) == 2) {
			return true;
		} else if (p1.compare(p1.mod(new HugeInt("2")), new HugeInt("0")) == 2 || p1.compare(p1.mod(new HugeInt("3")), new HugeInt("0")) == 2) {
			return false;
		}

		int i = 5;

		while (p1.compare(p1, new HugeInt(Integer.toString((i * i)))) == 0 || p1.compare(p1, new HugeInt(Integer.toString((i * i)))) == 2) {
			if (p1.compare(p1.mod(new HugeInt(Integer.toString(i))), new HugeInt("0")) == 2 || p1.compare(p1.mod(new HugeInt(Integer.toString((i + 2)))), new HugeInt("0")) == 2)
				return false;

			i = i + 6;
		}
		return true;

	}

}