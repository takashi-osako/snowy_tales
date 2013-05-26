package snowy_tales.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
	public static byte[] readFile(String fileName) {
		File file = new File(fileName);
		byte [] buffer =null;  
		try {
			// TODO: don't read the file all at once?
			FileInputStream in = new FileInputStream(file);
			int length = (int)file.length();
			buffer = new byte [length];
			in.read(buffer);
			in.close();
			 
		} catch (FileNotFoundException e) {
			System.out.println("File not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the file " + ioe);
		}
		return buffer;
	}
}
