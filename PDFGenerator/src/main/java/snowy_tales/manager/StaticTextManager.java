package snowy_tales.manager;

import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;

import snowy_tales.tools.StaticText;

public class StaticTextManager {

	public static void addToPDF(PDFManager pdfManager, StaticText staticText)
			throws DocumentException, IOException {

		PdfContentByte over = pdfManager.getWriter().getDirectContent();
		over.saveState();
		BaseFont bf = BaseFont.createFont(BaseFont.COURIER, BaseFont.CP1250,
				BaseFont.EMBEDDED);
		over.beginText();
		over.setFontAndSize(bf, staticText.getFontSize());
		over.setTextMatrix(staticText.getLeft(), staticText.getHeight());
		over.showText(staticText.getValue());
		over.endText();
		over.restoreState();
	}
}
