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

import snowy_tales.factory.FontFactory;
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
		column.setSimpleColumn(
				new Phrase(text.getValue(), FontFactory.createFont(
						text.getFontFamily(), text.getFontSize())),
				rectangle.getLeft(), rectangle.getBottom(),
				rectangle.getRight(), rectangle.getTop(),
				(float) (text.getFontSize() * 1.5), StaticTextManager.getTextAlign(text.getTextAlign()));
		column.go(); // draw content of column
	}

	private static int getTextAlign(String text_align) {
		int align = 0;
		text_align = text_align.toLowerCase();
		if (text_align.equals("left")) {
			align = Element.ALIGN_LEFT;
		} else if (text_align.equals("right")) {
			align = Element.ALIGN_RIGHT;
		}else if (text_align.equals("center")) {
			align = Element.ALIGN_CENTER;
		}else if (text_align.equals("justify")) {
			align = Element.ALIGN_JUSTIFIED;
		}
		return align;
	}
}
