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

	//Array size
	private int intLength;
	// this array will contain every digit of the huge integer array
	private int digitArr[];

	public HugeInt(){

	}
	/********************Constructor Taking String***************************/
	public HugeInt(String numStr)
	{
		//retrieve the length of the string
		String numString = numStr;
		int tempLength = numString.length();

		this.digitArr = new int[tempLength];
		int tempArr[] = new int[tempLength];

		for (int i = 0; i < tempLength; i++)
		{
			tempArr[i] = numString.charAt(i)-'0';
		}

		this.digitArr = tempArr;
		this.intLength = tempLength;
	}

	/********************Constructor taking array***************************/
	public HugeInt(int[] array)
	{
		this.digitArr = array;
		this.intLength = array.length;
	}


	/********************Get Padded Array***************************/
	public int[] getPaddedArray(HugeInt argument)
	{
		int paddedArr[];

		if (this.intLength > argument.intLength)
		{
			paddedArr = new int[(this.intLength)+1];
		}
		else
		{
			paddedArr = new int[(argument.intLength)+1];
		}
		return paddedArr;
	}

	//Adding, Subtracting, Multiplication, Division, Modulus, Relational Operations

	/********************Add method***************************/
	public HugeInt add(HugeInt addend)
	{
		HugeInt result;
		int paddedArr[] = getPaddedArray(addend);

		//add first addend to the padded array
		addDigits(paddedArr, paddedArr.length-1, this.digitArr);
		//add second addend to the padded array
		addDigits(paddedArr, paddedArr.length-1, addend.digitArr);
		//store result into a new instance
		result = new HugeInt(paddedArr);
		//return instance
		return result;
	}

	//Add Method Helper Function
	private void addDigits(int[] result, int resultIndex, int[] addend)
	{
		for (int addendIndex = addend.length-1; addendIndex >=0; addendIndex--)
		{
			addDigit(result, resultIndex, addend[addendIndex]);
			resultIndex--;
		}
	}

	//Add Method Helper Function
	private void addDigit(int[] result, int resultIndex, int addendDigit)
	{
		int sum = result[resultIndex] + addendDigit;
		result[resultIndex] = sum % 10;
		int carry = sum / 10;
		if(carry > 0) {
			addDigit(result, resultIndex - 1, carry);
		}
	}

	/********************Subtraction Method***************************/
	public HugeInt subtract(HugeInt addend)
	{
		HugeInt result;
		int paddedArr[] = getPaddedArray(addend);

		//add first argument to the padded array
		addDigits(paddedArr, paddedArr.length-1, this.digitArr);
		//subtract second argument to the padded array
		subDigits(paddedArr, paddedArr.length-1, addend.digitArr);
		//store result into a new instance
		result = new HugeInt(paddedArr);
		//return instance
		return result;
	}

	//subtract method helper function
	private void subDigits(int[] result, int resultIndex, int[] val2)
	{
		for (int val2Index = val2.length-1; val2Index >=0; val2Index--)
		{
			subDigit(result, resultIndex, val2[val2Index]);
			resultIndex--;
		}
	}

	//Add Method Helper Function
	private void subDigit(int[] result, int resultIndex, int val2)
	{
		int difference;
		if (result[resultIndex] >= val2)
		{
			difference = result[resultIndex] - val2;
			result[resultIndex] = difference;
		}
		//if we need to borrow
		else
		{
			subDigit(result, resultIndex -1, 1);
			difference = (result[resultIndex]+10) - val2;
			result[resultIndex] = difference;
		}
	}

	/********************Convert to String Method***************************/
	public void toString(HugeInt value)
	{
		for (int i = 0; i < value.digitArr.length; i++)
		{
			System.out.print(value.digitArr[i]);
		}
		System.out.println("");
	}
}
//
//public class HugeInt {
//	/**
//	 * A Vector of integers that stores a huge integer value. A valid value is
//	 * unsigned, and indexed with the least significant bit in the 0<sup>th</sup>
//	 * position of the vector.
//	 */
//	protected int[] value;
//
//	/**
//	 * The constructor takes a String representation of an integer and creates a new
//	 * value that is a vector representation of the parameter.
//	 *
//	 * @param newVal
//	 */
//	public HugeInt(String newVal){
//
//	}
//
//	/**
//	 * Returns a new value, which is the result of adding the parameter
//	 * value to the local value.
//	 *
//	 * @param x
//	 */
//	protected HugeInt add(HugeInt x){
//		return null;
//	}
//
//	/**
//	 * Returns a new value, which is the result of dividing the local
//	 * value by the parameter value.
//	 *
//	 * @param x
//	 */
//	protected HugeInt divide(HugeInt x){
//		return null;
//	}
//
//	/**
//	 * Returns true if the local value is equal to the parameter value.
//	 *
//	 * @param x
//	 */
//	protected boolean equal(HugeInt x){
//		return false;
//	}
//
//	/**
//	 * Returns true if the local value is greater than the parameter
//	 * value.
//	 *
//	 * @param x
//	 */
//	protected boolean greaterThan(HugeInt x){
//		return false;
//	}
//
//	/**
//	 * Returns true if the local value is greater than or equal to the
//	 * parameter value.
//	 *
//	 * @param x
//	 */
//	protected boolean greaterThanOrEqual(HugeInt x){
//		return false;
//	}
//
//	/**
//	 * The default constructor, used as a gateway for child classes to be able to
//	 * inherit while not filling in unnecessary values.
//	 */
//	public HugeInt(){
//
//	}
//
//	/**
//	 * Returns true if the local value is less than the parameter value.
//	 *
//	 * @param x
//	 */
//	protected boolean lessThan(HugeInt x){
//		return false;
//	}
//
//	/**
//	 * Returns true if the local value is less than or equal to the parameter
//	 * value.
//	 *
//	 * @param x
//	 */
//	protected boolean lessThanOrEqual(HugeInt x){
//		return false;
//	}
//
//	/**
//	 * Returns a new value, which is the result of performing the modulus
//	 * operation on the local value using the parameter value.
//	 *
//	 * @param x
//	 */
//	protected HugeInt modulus(HugeInt x){
//		return null;
//	}
//
//	/**
//	 * Returns a new value, which is the result of multiplying the parameter
//	 * value with the local value.
//	 *
//	 * @param x
//	 */
//	protected HugeInt multiply(HugeInt x){
//		return null;
//	}
//
//	/**
//	 * Returns a new value, which is the result of subtracting the parameter
//	 * value from the local value.
//	 *
//	 * @param x
//	 */
//	protected HugeInt subtract(HugeInt x){
//		return null;
//	}
//
//	/**
//	 * Returns a new value, which is the result of exponentiating the local
//	 * value by the parameter value.
//	 *
//	 * @param x
//	 */
//	protected HugeInt toThePowerOf(HugeInt x){
//		return null;
//	}
//
//}