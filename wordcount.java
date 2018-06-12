package wordcount;
/*Nhi Tuong CSC 
 * 
 * Purpose: To gain experiences with string objects and algorithms manipulations.
 * 			To read the user's text file and scan the amount of words and print it. To also
 * 			calculate different count attribute and add the attribute to the user's file without
 * 			overriding the previous data. 
 * Solution:The first solution was to use a scanner to ask for the user's input and 
 * 			code cases that identifies possible errors or empty text files that allows the user
 * 			to adjust files as needed.
 * 			Then reading the text file and saving it to a string variable that would be
 * 			used in multiple method parameters. The methods would implement specific algorithms
 * 			to manipulate the data in the string variable to get a desire output. Then the method is 
 * 			called and printed to show different file numeric attributes. This method
 * 			allows the user to preserve the original text file while the copy gets manipulated.
 * 			Then a texteditor is used (printwriter) to add the printed attributes/results to 
 * 			the user's text file that does not override any previous data.
 * Data Structure: String Objects
 * How to use the Program: The program will ask for a file name once the user runs it.
 * 			Please input the output name. 
 * 			There is no need to add the extension file tag. It is implemented in the code. The 
 * 			output.txt file must be in the wordcount folder, where the src and bin are located 
 * 			in order for the .txt file to be reached. Everything else is self executed.
 * 			The user's file will be changed at the end of the program. So the user should
 * 			reopen the text file to see the results added. 
 * Purpose of Each Class - There is only one class. The wordcount class executes different
 * 			algorithms that uses method such as: word count, sentence count, alphanumeric character count,
 * 			punctuation count, vowel count, and line count. Each method calculate certain word/character
 * 			/punctuation count and are called to the text file object and print out the word count results.
 * 			Use scanner and file to read input and strings that allows methods to effectively execute 
 * 			implemented algorithms. 
 * 
 * 
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class wordcount {
	/* Precondition: To have a text file in the correct directory. 
	 * Postcondition: Prints out the attributes of input text file. 
	 * invariant: file text string
	 */
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(System.in); //ask user's for input file
		System.out.println("please input a text file name without extention tag");
		String filename = sc.nextLine(); //takes a file name and store it in a variable
		String filec = filename + ".txt";
		
		
		File inFile = new File(filec);
		String fileContent = "";
		int linecount = 0;
        try {
        	
        	Scanner fileInput = new Scanner(inFile);
        	
        	while(fileInput.hasNext()){
        	
        	fileContent += fileInput.nextLine() + '\n';
        	
        	linecount ++;		
        			
        } System.out.println();
        		
        		fileInput.close();
        }	catch (FileNotFoundException e){
        		System.out.println(
                    "Unable to find file '" + 
                    filec + "'");
        		System.exit(1);
       	}
        
        
        //continue with program
        
        
        String doc = fileContent;
        if (doc != ""){
        	System.out.println(fileContent);
        	
        } else {
        	System.out.println("file is empty.");
         System.exit(1);
        }
        doc = fileContent.replace("\n", " "); //removes break lines added from while loop.
        //print results and word counts 
        System.out.println();
        System.out.println("This file's total word count is: " + getWordCount(doc));
        System.out.println("This file's line count is: " + linecount);
        System.out.println("This file's alphanumeric character count is: " + getAlpCount(doc));
        System.out.println("This file contains a total of " + numSentence(doc) + " sentences.");
        System.out.println("This file has a total of " + countVowels(doc) + " vowels.");
        System.out.println("This file has a total of " + countPun(doc) + " punctuations.");
        sc.close();
        
        //Print result in output text file
        //creating a printWriter object
        PrintWriter newFile = new PrintWriter("output.txt");
        newFile.println(fileContent); //pull original text file content
        newFile.println("This file's total word count is: " + getWordCount(doc));
        newFile.println("This file's line count is: " + linecount);
        newFile.println("This file's alphanumeric character count is: " + getAlpCount(doc));
        newFile.println("This file contains a total of " + numSentence(doc) + " sentences.");
        newFile.println("This file has a total of " + countVowels(doc) + " vowels.");
        newFile.println("This file has a total of " + countPun(doc) + " punctuations.");
        newFile.close();
        //close PrintWrite 
       
	}
	/* Precondition: Have to have a string. 
	 * Postcondition: return a int count variable. 
	 * 
	 */
	public static int getWordCount (String C){
		int count = 0;
		String countfile = C;
		Scanner sc = new Scanner(countfile);
		while (sc.hasNext()){

				count++;
				sc.next();
			
		}sc.close();
		return count;
		
		
	}
	/* Precondition: Have to have a string. 
	 * Postcondition: return a int count variable. 
	 * 
	 */
	public static int getAlpCount(String C){
		int count = 0;
		String countfile = C;
		for (int i = 0; i < countfile.length(); i++){
			char c = countfile.charAt(i);
			if('0'<=c && c<='9'){
				count++;
			} else if('a'<=c && c<='z'){
				count++;
			} else if('A'<=c && c<='Z'){
				count++;
			}
		}return count;
			
	}
	/* Precondition: Have to have a string. 
	 * Postcondition: return a int count variable. 
	 * 
	 */
	public static int numSentence(String C){
		
		String countFile = C;		
		int count = countFile.split("[!?.:]+").length - 1;
		return count;
	}
	/* Precondition: Have to have a string. 
	 * Postcondition: return a int count variable. 
	 */
	public static int countVowels(String C){
		
		int count = 0;
		String countFile = C;
		for (int i = 0; i < countFile.length(); i++) {
			char c = countFile.charAt(i);
			switch ( c ){
			case 'a':
			case 'e':
			case 'i':		//check each char using a for loop for vowels and
			case 'o':		//incrementing count to keep track of vowels. 
			case 'u': 
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U': 	
				count++;
			default: 
				//does nothing
			}
		}return count;
	}
	/* Precondition: Have to have a string. 
	 * Postcondition: return a int count variable. 
	 * 
	 */
	public static int countPun (String C){
		int count = 0;
		String countFile = C;
		for (int i = 0; i < countFile.length(); i++) {
			char c = countFile.charAt(i);
				switch ( c ){
				case '!': 
				case '.':
				case '?':		//Scan each char for punctuation that acts as  
				case ';':		//delimiters. 
				case ':': 
				case '-':
				case '"':
				case ',':
				case '(': 
				case ')':
				case '’':	
							count++;
							
			default: //do nothing
				}
			}return count;
	}
}


		
	
	
	
	
