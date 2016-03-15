import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
 * Handles blocking and unblocking of message files.
 * 
 * A blocking size must be provided by the user as well as an input file name and
 * whether to block or unblock the file.
 * 
 * The resulting file name is stored in the local data member.
 * @version     1.0.0
 * @university  University of Illinois at Chicago
 * @course      CS342 - Software Design
 * @package     Project #03 - RSA-Java
 * @author      Marek Rybakiewicz
 * @author      Lubna Mirza
 * @license     GNU Public License <http://www.gnu.org/licenses/gpl-3.0.txt>
 */
public class Blocking {

	/**
	 * Takes a message file along with the blocking size and an indicator whether to
	 * block or unblock.
	 * 
	 * Execution is passed to the corresponding method based on the indicator.
	 * 
	 * @param blockingSize
	 * @param message
	 * @param type
	 */
	public Blocking(int blockingSize, String message, int type, String fileName){
		if(type == 0){
			block(blockingSize, message, fileName);
		}
		else{
			unblock(blockingSize, message, fileName);
		}
	}

	/**
	 * Takes a blocking size along with the corresponding message file name, and
	 * splits the message into blockingSize sections, which are then stored
	 * into a new file that a user is allowed to name.
	 * 
	 * The result is a quasi-ASCII file, with file name stored in the local data
	 * member.
	 * 
	 * @param blockingSize
	 * @param message
	 */
	protected void block(int blockingSize, String message, String fileName){
		try {
			int blockedSoFar = 0;
			int firstIteration = 0;

			//Create a new file
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");

			String temp = "";
			//Convert to reversed TROY ASCII
			for(char c : message.toCharArray()){
				if(blockedSoFar%blockingSize == 0 && firstIteration == 1){
					//Reverse temp string, write to file
					String revText = "";
					char[] rev= temp.toCharArray();
					for (int i = rev.length-1; i >= 0; i = i - 2){
						revText += rev[i - 1];
						revText += rev[i];
					}
					writer.println(revText);

					//Reset string
					temp = "";
				}
				//Mark as passed, add newlines freely
				firstIteration = 1;

				int asciiVal = (int)c;

				//Check special characters, convert and save to file
				if(asciiVal == 0)
					temp = temp+"00";
				else if(asciiVal == 11)
					temp = temp+"01";
				else if(asciiVal == 9)
					temp = temp+"02";
				else if(asciiVal == 10)
					temp = temp+"03";
				else if(asciiVal == 13)
					temp = temp+"04";
				else{
					asciiVal = asciiVal - 27;
					//If less than 10, pad
					if(asciiVal < 10){
						String val = "0"+asciiVal;
						temp = temp+val;
					}
					else {
						temp = temp+asciiVal;
					}
				}
				blockedSoFar++;
			}
			//Clean up any remainder
			String revText = "";
			char[] rev= temp.toCharArray();
			//Pad
			for(int i = 0; i < ((blockingSize*2)-(rev.length)); i++){
				revText += "0";
			}
			//Add rest of digits
			for (int i = rev.length-1; i >= 0; i = i - 2){
				revText += rev[i - 1];
				revText += rev[i];
			}
			writer.print(revText);

			writer.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error converting file. Blocking number must be positive");
			return;
		}
	}

	/**
	 * Takes a blocking size along with the corresponding message file name, and re-
	 * combines a split message based on the blockingSize, storing the new
	 * message in a file.
	 * 
	 * The result is an ASCII file, with the file name stored in the local data member.
	 * 
	 * 
	 * @param blockingSize
	 * @param message
	 */
	protected void unblock(int blockingSize, String message, String fileName){
		try {
			//Create a new file
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");

			int lineCount = 0;

			//Get the number of lines
			Scanner scanner = new Scanner(message);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				lineCount++;
			}
			scanner.close();

			//Create a new array of lines
			String[] lines = new String[lineCount];


			//Populate array
			scanner = new Scanner(message);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				lines[lineCount-1] = line;
				lineCount--;
			}
			scanner.close();



			//Check if blocking size is too big
			if(blockingSize > (lines[0].length()/2)){
				JOptionPane.showMessageDialog(null, "The blocking number was larger than the blocking size of a line.");
				return;
			}
			else{
				//Parse each line based on blocking size
				for(int i = 0; i < lines.length; i++ ){
					char[] temp = lines[i].toCharArray();
					for(int j = 0; j < blockingSize*2; j = j + 2){
						String s = "" + temp[j] + temp[j+1];
						int stringInt = Integer.parseInt(s);

						char c;
						//Check for special cases
						if(stringInt == 00)
							c = (char)0;
						else if(stringInt == 01)
							c = (char)11;
						else if(stringInt == 02)
							c = (char)9;
						else if(stringInt == 03)
							c = (char)10;
						else if(stringInt == 04)
							c = (char)13;
						else{
							stringInt = stringInt + 27;
							c = (char)stringInt;
						}

						writer.print(c);
					}
				}
			}
			writer.close();

			//Reverse the result and restore in file
			String text = new Scanner(new File(fileName)).useDelimiter("\\Z").next();

			String revText = "";
			char[] rev= text.toCharArray();
			for (int i = rev.length-1; i >= 0; i--){
				revText += rev[i];
			}

			writer = new PrintWriter(fileName, "UTF-8");
			writer.print(revText);

			writer.close();

		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "File output error");
			return;
		}
	}

}