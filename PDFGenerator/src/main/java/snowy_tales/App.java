package snowy_tales;

import java.util.List;
import java.util.Map;
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
	
	public static void createPdf(String name){
		System.out.println("Creating pdf");
		try {
			PDFManager pdfManager = new PDFManager("/tmp/" + name + ".pdf");
			StaticTextManager staticTextManager = new StaticTextManager(pdfManager);
			Map<String, Object> data = JSONReader
					.getMap("/tmp/template.json");
			TemplateManager templateManager = new TemplateManager(data);
			List<StaticText> texts = templateManager.getStaticText();
			for (StaticText text : texts) {
				staticTextManager.add(text);
			}
			pdfManager.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		App.createPdf("test1");
	}
}
