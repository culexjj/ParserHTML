# ParserHTML
Parser HTML file produces by NTFS Permissions Reporter Free Edition

I usually use NTFS Permissions Reporter Free Edition for cheking the ACL.
It isn't easy manage the output files from large drives with windows native tools so I create this parser for the more tricky part

The app is fixed for these four columns (Path / Account Type/ Display Name / SID) but you can tune it up for any number just updating the variable:

		int columnas = 4; //Numero columnas archivo html

The input/output files have to be on the same path that the .jar 

Note: you need at least JDK 20 & jsoup-1.16.1 library
