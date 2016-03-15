import java.util.Vector;

/**
 * Handles all operations and storage for very large integers.
 * 
 * The single data member is a value, which is the vector-based
 * representation of a large integer.
 * 
 * The default constructor hugeInt() acts as a dummy constructor for use in
 * child classes.
 * The main constructor hugeInt(String) takes a string representation of an
 * integer and generates a value.
 * 
 * All other methods are mathematical operations that can be performed on the
 * local value, given an outside value.
 * The math operations include:
 *    Addition, subtraction, multiplication, division, modulus, relational
 * operations, and exponentiation.
 *
 * @version     1.0.0
 * @university  University of Illinois at Chicago
 * @course      CS342 - Software Design
 * @package     Project #03 - RSA-Java
 * @author      Marek Rybakiewicz
 * @author      Lubna Mirza
 * @license     GNU Public License <http://www.gnu.org/licenses/gpl-3.0.txt>
 */
public class HugeInt {
	/**
	 * A Vector of integers that stores a huge integer value. A valid value is
	 * unsigned, and indexed with the least significant bit in the 0<sup>th</sup>
	 * position of the vector.
	 */
	protected Vector<Integer> value;

	/**
	 * The constructor takes a String representation of an integer and creates a new
	 * value that is a vector representation of the parameter.
	 * 
	 * @param newVal
	 */
	public HugeInt(String newVal){

	}

	/**
	 * Returns a new value, which is the result of adding the parameter
	 * value to the local value.
	 * 
	 * @param x
	 */
	protected HugeInt add(HugeInt x){
		return null;
	}

	/**
	 * Returns a new value, which is the result of dividing the local
	 * value by the parameter value.
	 * 
	 * @param x
	 */
	protected HugeInt divide(HugeInt x){
		return null;
	}

	/**
	 * Returns true if the local value is equal to the parameter value.
	 * 
	 * @param x
	 */
	protected boolean equal(HugeInt x){
		return false;
	}

	/**
	 * Returns true if the local value is greater than the parameter
	 * value.
	 * 
	 * @param x
	 */
	protected boolean greaterThan(HugeInt x){
		return false;
	}

	/**
	 * Returns true if the local value is greater than or equal to the
	 * parameter value.
	 * 
	 * @param x
	 */
	protected boolean greaterThanOrEqual(HugeInt x){
		return false;
	}

	/**
	 * The default constructor, used as a gateway for child classes to be able to
	 * inherit while not filling in unnecessary values. 
	 */
	public HugeInt(){

	}

	/**
	 * Returns true if the local value is less than the parameter value.
	 * 
	 * @param x
	 */
	protected boolean lessThan(HugeInt x){
		return false;
	}

	/**
	 * Returns true if the local value is less than or equal to the parameter
	 * value.
	 * 
	 * @param x
	 */
	protected boolean lessThanOrEqual(HugeInt x){
		return false;
	}

	/**
	 * Returns a new value, which is the result of performing the modulus
	 * operation on the local value using the parameter value.
	 * 
	 * @param x
	 */
	protected HugeInt modulus(HugeInt x){
		return null;
	}

	/**
	 * Returns a new value, which is the result of multiplying the parameter
	 * value with the local value.
	 * 
	 * @param x
	 */
	protected HugeInt multiply(HugeInt x){
		return null;
	}

	/**
	 * Returns a new value, which is the result of subtracting the parameter
	 * value from the local value.
	 * 
	 * @param x
	 */
	protected HugeInt subtract(HugeInt x){
		return null;
	}

	/**
	 * Returns a new value, which is the result of exponentiating the local
	 * value by the parameter value.
	 * 
	 * @param x
	 */
	protected HugeInt toThePowerOf(HugeInt x){
		return null;
	}

}