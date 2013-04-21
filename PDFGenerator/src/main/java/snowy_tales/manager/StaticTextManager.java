package snowy_tales.manager;

import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;

import snowy_tales.tools.StaticText;

public class StaticTextManager {

	private PDFManager pdfManager = null;

	public StaticTextManager(PDFManager pdfManager) {
		this.pdfManager = pdfManager;
	}

	/**
	 * return rectangle shape
	 * 
	 * @return
	 */
	public Rectangle getRectangle(StaticText text) {
		// Rectangle(Left-Bottom,
		Rectangle pageRectangle = this.pdfManager.getDocument().getPageSize();
		float llx = text.getLeft(); // lower left x
		float lly = pageRectangle.getHeight() - text.getTop()
				- text.getHeight(); // lower left y
		float urx = llx + text.getWidth(); // upper right x
		float ury = lly + text.getHeight(); // upper right y
		Rectangle rectangle = new Rectangle(llx, lly, urx, ury);
		return rectangle;
	}

	/**
	 * Add static text to PDF
	 * 
	 * @param text
	 * @throws DocumentException 
	 */
	public void add(StaticText text) throws DocumentException {
		Rectangle rectangle = getRectangle(text);
		// PDF under layer
		PdfContentByte under = this.pdfManager.getWriter().getDirectContent();

		under.saveState();

		// background color. this is just temporary.
		BaseColor color = WebColors.getRGBColor("#F2F2F2");
		under.setColorFill(color);
		under.rectangle(rectangle.getLeft(), rectangle.getBottom(),
				rectangle.getWidth(), rectangle.getHeight());
		// fill background color
		under.fill();

		// PDF over layer
		PdfContentByte over = pdfManager.getWriter().getDirectContent();
		over.rectangle(rectangle.getLeft(), rectangle.getBottom(),
				rectangle.getWidth(), rectangle.getHeight());
		// stroke border
		over.stroke();

		under.restoreState();

		// preparing filing a text
		ColumnText column = new ColumnText(under);
		column.setSimpleColumn(new Phrase(text.getValue()),
				rectangle.getLeft(), rectangle.getBottom(),
				rectangle.getRight(), rectangle.getTop(), text.getFontSize(),
				Element.ALIGN_LEFT);
		column.go(); //draw content of column
	}
}
