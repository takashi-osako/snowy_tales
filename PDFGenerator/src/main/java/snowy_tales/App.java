package snowy_tales;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.itextpdf.text.DocumentException;

import snowy_tales.manager.PDFManager;
import snowy_tales.manager.StaticTextManager;
import snowy_tales.manager.TemplateManager;
import snowy_tales.reader.JSONReader;
import snowy_tales.tools.StaticText;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		try {
			PDFManager pdfManager = new PDFManager("/Users/tosako/test1.pdf");
			Map<String, Object> data = JSONReader
					.getMap("/Users/tosako/git/snowy_tales/PDFGenerator/src/resources/template.json");
			TemplateManager templateManager = new TemplateManager(data);
			List<StaticText> texts = templateManager.getStaticText();
			for (StaticText text : texts) {
				StaticTextManager.addToPDF(pdfManager, text);
			}
			pdfManager.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
