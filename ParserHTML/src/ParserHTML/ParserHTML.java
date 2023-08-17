package ParserHTML;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParserHTML {

	public static void main(String[] args) {
		
		/* Variables */
		
		String linea = "";
		String temp = null;
		int columnas = 4; //Numero columnas archivo html
		int contador = 0;
		
		String pathInputFile;
		Path pathOutputFile;
		File inputFile = null;//Fichero de entrada (representacion abstracta)
		Document document = null;
		Reader reader = new Reader();
		FileManager fileManager = new FileManager();
		
		//Limpiar consola
		try {
			final String os = System.getProperty("os.name");
			 if (os.contains("Windows"))
		            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		        else
		            Runtime.getRuntime().exec("clear");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("\n");
		System.out.print("Parser archivos HTML generados por NTFS permissions Reporter V 1.5.0.0 \n");
		System.out.print("Columnas a exportar (4): Path, Account Type, Display Name, SID \n");
		System.out.print("\n");
		
		System.out.print("Nombre del fichero de entrada : ");		
		String entrada = reader.readString();
		
		System.out.print("Nombre del fichero de salida: ");
		String salida = reader.readString();		
		fileManager.createFile(salida);
		pathOutputFile = fileManager.getPath();
		
		System.out.print("\n");
		System.out.print("\n");
		System.out.print("Inicio de ejecucion \n");
		System.out.print("\n");
		System.out.print("\n");
		System.out.print("El proceso de parsing es proporcional al tamaño del fichero de entrada \n");
		System.out.print("\n");
		System.out.print("............  \n");
		System.out.print("............  \n");
		System.out.print("............  \n");
		
		
		 
		try {
			pathInputFile  = new File(entrada).getAbsolutePath();
			inputFile = new File(pathInputFile);
	    } catch (NullPointerException e) {
	    	//e.printStackTrace();
	        System.out.print("\nERROR: Argumento incorrecto " );	
			System.exit (-1);
	    }
			
		try {
			document = Jsoup.parse(inputFile, "UTF-8", entrada);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.print("\nERROR: Fallo Jsoup, fichero de entrada : " + document);	
			System.exit (-1);
        }
			
		
		/* Bucle de lectura */
		
		Elements rows = document.select("td"); //Lectura etiquetas <td> ... </td>	
		
		for(Element row : rows){
			temp = row.getElementsByTag("td").text() + ";"; 
				
			if (contador < columnas)  {
				linea = linea + temp;
				contador = contador + 1;
			} else {		
				linea = linea + "\n";
				fileManager.writeLine(pathOutputFile, linea);		
				contador = 1;
				linea = temp ;
			}		
        
		}
		

		System.out.print("\n");
		System.out.print("Fin de ejecucion   \n");
		
		System.out.print("\n");
		System.out.print("Archivo de salida : " + pathOutputFile); 
	}

}
