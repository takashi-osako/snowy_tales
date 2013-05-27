package snowy_tales.reader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
	public static byte[] readFile(String fileName) throws IOException {
		File file = new File(fileName);
		byte[] buffer = null;
		BufferedInputStream bis = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(file);
			int length = (int) file.length();
			bis = new BufferedInputStream(fin);
			buffer = new byte[length];

			bis.read(buffer);

		} catch (FileNotFoundException e) {
			System.out.println("File not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the file " + ioe);
		} finally {
			if (bis != null) {
				bis.close();
			}
			if (fin != null) {
				fin.close();
			}
		}
		return buffer;
	}
}
