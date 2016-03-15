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
        return result;
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