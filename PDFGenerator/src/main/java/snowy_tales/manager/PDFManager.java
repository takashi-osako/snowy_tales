package snowy_tales.manager;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFManager {
	private Document document;
	private PdfWriter writer;

	public PDFManager(String output_filename)
			throws FileNotFoundException, DocumentException {
		// create Letter size document with no margins
		this.document = new Document(PageSize.LETTER, 0, 0, 0, 0);
		writer = PdfWriter.getInstance(this.document, new FileOutputStream(
				output_filename));
		this.document.open();
	}

	public void close() {
		this.document.close();
	}

	public Document getDocument() {
		return document;
	}

	public PdfWriter getWriter() {
		return writer;
	}
}
