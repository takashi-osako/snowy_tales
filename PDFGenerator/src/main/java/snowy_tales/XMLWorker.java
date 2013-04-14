/**
 * 
 */
package snowy_tales;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * @author dorisip
 *
 */
public class XMLWorker {
	
	public void createPDF(String htmlFileName) {
	    Document document = new Document();
	    document.addAuthor("testing");
	    document.addCreationDate();
	    document.addProducer();
	    document.addCreator("Me");
	    document.addTitle("Demo for iText XMLWorker");
	    document.setPageSize(PageSize.LETTER);
	    
	    PdfWriter writer;
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream("/Users/dorisip/results.pdf"));
			document.open();
			
			// this works
			//URL myWebPage = new URL("http://demo.mysamplecode.com/");
			//InputStreamReader reader = new InputStreamReader(myWebPage.openStream());
			//XMLWorkerHelper.getInstance().parseXHtml(writer, document, reader);
			
			XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(htmlFileName));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
	}
}
