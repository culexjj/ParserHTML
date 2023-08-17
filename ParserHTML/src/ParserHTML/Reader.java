package ParserHTML;


/**
 * This class is a  console reader for Integer & String values
 * @author esculebj
 * @version 0.1
 * 
 */

import java.util.Scanner;


public class Reader {
	
	/* Variables */	
	private String string;
	private int integer;
	private Scanner scanner;
	
	/*  Default constructor  */	
	Reader () {
		
		this.string = "";
		this.integer = 0;
		scanner = new Scanner(System.in);
		
	}
	
	/* Public Methods */ 
	
	
	/**
	 * ReadInteger
	 * @return a number
	 */
	public int readInteger () {
		
		integer = scanner.nextInt();		
				
		return integer;
		
	}
	
	/**
	 * ReadString
	 * @return a string
	 */
	public String readString () {
				
		string = scanner.next();		
				
		return string;		
		
	}

}
