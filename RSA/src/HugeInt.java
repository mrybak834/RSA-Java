package RSA;


/**
 * Handles all operations and storage for very large integers.
 * 
 * The single data member is a <b>value</b>, which is the vector-based
 * representation of a large integer.
 * 
 * The default constructor <b>hugeInt()</b> acts as a dummy constructor for use in
 * child classes.
 * The main constructor <b>hugeInt(String)</b> takes a string representation of an
 * integer and generates a <b>value</b>.
 * 
 * All other methods are mathematical operations that can be performed on the
 * local <b>value</b>, given an outside <b>value.</b>
 * The math operations include:
 *    Addition, subtraction, multiplication, division, modulus, relational
 * operations, and exponentiation.
 * @version 1.0
 * @created 06-Mar-2016 9:11:06 PM
 */
public class HugeInt {

	/**
	 * A Vector of integers that stores a huge integer value. A valid <b>value</b> is
	 * unsigned, and indexed with the least significant bit in the 0<sup>th</sup>
	 * position of the vector.
	 */
	protected Vector<Integer> value;
	public GUI m_GUI;

	public HugeInt(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * The constructor takes a String representation of an integer and creates a new
	 * <b>value</b> that is a vector representation of the parameter.
	 * 
	 * @param newVal
	 */
	public HugeInt(String newVal){

	}

	/**
	 * Returns a new <b>value</b>, which is the result of adding the parameter
	 * <b>value</b> to the local <b>value</b>.
	 * 
	 * @param x
	 */
	protected value add(value x){
		return null;
	}

	/**
	 * Returns a new <b>value</b>, which is the result of dividing the local
	 * <b>value</b> by the parameter <b>value</b>.
	 * 
	 * @param x
	 */
	protected value divide(value x){
		return null;
	}

	/**
	 * Returns true if the local <b>value</b> is equal to the parameter <b>value</b>.
	 * 
	 * @param x
	 */
	protected boolean equal(value x){
		return false;
	}

	/**
	 * Returns true if the local <b>value</b> is greater than the parameter
	 * <b>value</b>.
	 * 
	 * @param x
	 */
	protected boolean greaterThan(value x){
		return false;
	}

	/**
	 * Returns true if the local <b>value</b> is greater than or equal to the
	 * parameter <b>value</b>.
	 * 
	 * @param x
	 */
	protected boolean greaterThanOrEqual(value x){
		return false;
	}

	/**
	 * The default constructor, used as a gateway for child classes to be able to
	 * inherit while not filling in unnecessary values. 
	 */
	public Hugeint(){

	}

	/**
	 * Returns true if the local <b>value</b> is less than the parameter <b>value</b>.
	 * 
	 * @param x
	 */
	protected boolean lessThan(value x){
		return false;
	}

	/**
	 * Returns true if the local <b>value</b> is less than or equal to the parameter
	 * <b>value</b>.
	 * 
	 * @param x
	 */
	protected boolean lessThanOrEqual(value x){
		return false;
	}

	/**
	 * Returns a new <b>value</b>, which is the result of performing the modulus
	 * operation on the local <b>value</b> using the parameter <b>value</b>.
	 * 
	 * @param x
	 */
	protected value modulus(value x){
		return null;
	}

	/**
	 * Returns a new <b>value</b>, which is the result of multiplying the parameter
	 * <b>value</b> with the local <b>value</b>.
	 * 
	 * @param x
	 */
	protected value multiply(value x){
		return null;
	}

	/**
	 * Returns a new <b>value</b>, which is the result of subtracting the parameter
	 * <b>value</b> from the local <b>value</b>.
	 * 
	 * @param x
	 */
	protected value subtract(value x){
		return null;
	}

	/**
	 * Returns a new <b>value</b>, which is the result of exponentiating the local
	 * <b>value</b> by the parameter <b>value</b>.
	 * 
	 * @param x
	 */
	protected value toThePowerOf(value x){
		return null;
	}

}