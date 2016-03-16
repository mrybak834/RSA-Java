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
	public int digitArr[];

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
		HugeInt trimmedResult = trimArray(result);
		//return instance
		return trimmedResult;
	}

	//Add Method Helper Function
	private void addDigits(int[] result, int resultIndex, int... addend)
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
		//trim result
		HugeInt trimmedResult = trimArray(result);
		//return instance
		return trimmedResult;
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

	//Subtract Method Helper Function
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

	/********************Multiplication Method***************************/

	//Errors So Far: str1 cannot be smaller than str2.

	public HugeInt multiply(HugeInt val2) {
		HugeInt result;
		//get padded array from multiplying two values
		int[] paddedArr = paddedMultArray(val2);
		//call helper function
		multiplyDigits(paddedArr, paddedArr.length-1, this.digitArr, val2.digitArr);

		result = new HugeInt(paddedArr);
		HugeInt trimmedResult = trimArray(result);
		//return instance
		return trimmedResult;
	}

	//helper function to get padded array for multiplying two numbers
	private int[] paddedMultArray (HugeInt val2)
	{
		int paddedArr[];
		int productSize;
		productSize = this.digitArr.length + val2.digitArr.length;
		paddedArr = new int[productSize];
		return paddedArr;
	}

	//making sure to multiply each digit from val2 to each digit from val1
	private void multiplyDigits(int[] multArr, int multArrIndex, int[] val1, int[] val2) {
		int lastArrPos;
		for(int i = 0; i < val1.length; i++) {
			for(int j = 0; j < val2.length; j++)
			{
				multiplyDigit(multArr, multArrIndex - (i + j),val1[val1.length-i-1], val2[val2.length-j-1]);
			}
		}
	}
	//multiplication method
	private void multiplyDigit(int[] result, int resultIndex, int val1, int val2) {
		int product = val1 * val2;
		int productVal = product%10;
		int carry = product/10;
		addDigits(result, resultIndex, carry, productVal);
	}

	/********************Division Method***************************/
	public void divide(HugeInt val2) {

		//Trim both arrays to make sure we don't have any leading zeroes
		HugeInt dividend = trimArray(this);
		HugeInt divisor = trimArray(val2);

		HugeInt result = new HugeInt(dividend.digitArr);

		//compare to make sure that the dividend is larger than the divisor
		int comparison = compare(dividend,divisor);
		if (comparison != 0 && comparison != 2)
		{
			System.out.println("Invalid Division Request");
		}
		int index = 1;
		System.out.println("LENGTH" + dividend.digitArr.length);
		for(int i = 1; i <= dividend.digitArr.length; i++)
		{
			if (canSubtract(i,dividend.digitArr,divisor.digitArr) == 1)
			{
				index = i;
				break;
			}
		}

		//capturing the length of the divisor
		int divisorLength = divisor.digitArr.length;
		int[] array = new int[index];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = dividend.digitArr[i];

			System.out.println("hey" + array[i]);
		}
		//call the helper divide function that will divide the two
		divideDigits(array,divisor.digitArr);



	}

	public void divideDigits(int[] dividend, int[] divisor) {
		int counter = 0;

		while (compare(dividend,divisor) == 0)
		{
			subDigits(dividend,dividend.length-1,divisor);
			dividend = trimArray(dividend);
			counter++;
		}
		System.out.println("COUNTER");
		System.out.println(counter);


	}

	/********************Can I Subtract?***************************/
	//returns 1 means yes 0 means no
	public int canSubtract (int index, int[] dividend, int[] divisor)
	{
		int[] newArray = new int[index];
		for (int i = 0; i < index; i++)
		{
			newArray[i] = dividend[i];
		}

		if (compare(newArray,divisor) == 0 || compare(newArray,divisor) ==2)
		{
			return 1;
		}
		return 0;
	}


	/********************Comparator Method***************************/
	//RETURNS 0 IF VAL 1 > VAL 2
	//RETURNS 1 IF VAL 1 < VAL 2
	//RETURNS 2 IF VAL 1 = VAL 2
	//RETURNS -1 ON ERROR

	public int compare(HugeInt val1, HugeInt val2)
	{
		//checking if there's more digits in val1 than in val2
		if (val1.digitArr.length > val2.digitArr.length)
		{
			return 0;
		}
		//checking if there's more digits in val2 than in val1
		if (val1.digitArr.length < val2.digitArr.length)
		{
			return 1;
		}
		//if they're the same length, we need to check more in-depth.
		if (val1.digitArr.length == val2.digitArr.length)
		{
			for (int i = 0; i < val1.digitArr.length; i++)
			{
				if (val1.digitArr[i] > val1.digitArr[i])
				{
					return 0;
				}
				if (val1.digitArr[i] < val1.digitArr[i])
				{
					return 1;
				}
			}
			//they must be equal
			return 2;
		}
		return -1;
	}


	public int compare(int[] val1, int[] val2)
	{
		//checking if there's more digits in val1 than in val2
		if (val1.length > val2.length)
		{
			return 0;
		}
		//checking if there's more digits in val2 than in val1
		if (val1.length < val2.length)
		{
			return 1;
		}
		//if they're the same length, we need to check more in-depth.
		if (val1.length == val2.length)
		{
			for (int i = 0; i < val1.length; i++)
			{
				if (val1[i] > val2[i])
				{
					return 0;
				}
				if (val1[i] < val2[i])
				{
					return 1;
				}
			}
			//they must be equal
			return 2;
		}
		return -1;
	}

	/********************Removing Zeroes from Padded Array Method***************************/
	public HugeInt trimArray(HugeInt val1)
	{
		int index = 0;
		//finding the index that starts the actual value
		for (int i = 0; i < val1.digitArr.length; i++)
		{
			if (val1.digitArr[i] != 0)
			{
				index = i;
				break;
			}
		}

		//making a new array of appropriate size
		int[] newInt = new int[val1.digitArr.length-index];

		for (int i = 0; i< newInt.length; i++)
		{
			newInt[i] = val1.digitArr[i+index];
		}
		HugeInt result = new HugeInt(newInt);
		return result;
	}

	//TRIM METHOD FOR ARRAY
	public int[] trimArray(int[] val1)
	{
		int index = 0;
		//finding the index that starts the actual value
		for (int i = 0; i < val1.length; i++)
		{
			if (val1[i] != 0)
			{
				index = i;
				break;
			}
		}

		//making a new array of appropriate size
		int[] newInt = new int[val1.length-index];

		for (int i = 0; i< newInt.length; i++)
		{
			newInt[i] = val1[i+index];
		}
		return newInt;
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