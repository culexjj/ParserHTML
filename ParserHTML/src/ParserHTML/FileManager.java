package ParserHTML;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * This class is manage java.nio.file.Files objects
 * @author jose-javier.culebras@yrnet.com
 * @version 1.0
 * @apiNote SE17 required
 * 
 */

public class FileManager {
	
	/* Variables */	
	private Path path;
	

	/*  Default constructor  */	
	FileManager () {
		path = null;
	}
	
	
	/* Public Methods */ 
		
	/**
	 * 
	 * @return path of the file
	 */
	
	public Path getPath () {
		
		return path;		
	}
	

	/**
	 * Create a file on the .\ path
	 * @param name of the file
	 */
	
	public void createFile (String name) {		
		
		String basePath  = new File(name).getAbsolutePath();
		path = Paths.get(basePath);
		
		try {
			Files.createFile(path);
		} catch (IOException e) {
			//e.printStackTrace();
			//System.out.print("\033[H\033[2J"); 
			System.out.print("\nERROR CREACION FICHERO: El nombre de archivo ya existe " + basePath);
			
			System.exit (-1);
		}
		
	}
	
	/**
	 * Add a line to the file
	 * @param path of the file
	 * @param line to add
	 */
	
	public void writeLine (Path path, String line) {
		try {
			Files.writeString(path, line, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.print("\nERROR: Fallo de escritura " + line);
			System.exit (-1);
		}
	}
	

}
