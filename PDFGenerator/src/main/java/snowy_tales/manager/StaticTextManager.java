package snowy_tales.manager;

import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;

import snowy_tales.factory.ColorFactory;
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

		// background color.
		BaseColor gbcolor = ColorFactory.getColor(text.getBackgrounColor(),
				BaseColor.WHITE);
		if (gbcolor != null) {
			under.setColorFill(gbcolor);
		}
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

		ColumnText column = createText(under, rectangle, text);
		column.go(); // draw content of column
	}

	private static int getTextAlign(String text_align) {
		int align = 0;
		text_align = text_align.toLowerCase();
		if (text_align.equals("left")) {
			align = Element.ALIGN_LEFT;
		} else if (text_align.equals("right")) {
			align = Element.ALIGN_RIGHT;
		} else if (text_align.equals("center")) {
			align = Element.ALIGN_CENTER;
		} else if (text_align.equals("justify")) {
			align = Element.ALIGN_JUSTIFIED;
		}
		return align;
	}

	private ColumnText createText(PdfContentByte content, Rectangle rectangle,
			StaticText text) throws DocumentException {
		ColumnText column = new ColumnText(content);
		Font font = FontFactory.createFont(text.getFontFamily(),
				text.getFontSize(), text.getColor(), text.isItalic(),
				text.isBold(), text.isUnderlined());
		Phrase phrase = new Phrase(text.getValue(), font);
		column.setSimpleColumn(rectangle);
		column.addText(phrase);

		if ("middle".equals(text.getVerticalAlign())) {
			ColumnText simulateColumn = ColumnText.duplicate(column);

			// simulate and find how many lines are written
			simulateColumn.go(true);
			int lineWritten = simulateColumn.getLinesWritten();
			if (lineWritten > 0) {
				float leading = simulateColumn.getLeading();
				float top = (rectangle.getTop() - rectangle.getBottom()) / 2.0f
						+ leading / 2.0f + rectangle.getBottom();

				float new_top = top + (leading * lineWritten) / 2.0f;
				column.setYLine(new_top);
			}
		} else if ("bottom".equals(text.getVerticalAlign())) {
			ColumnText simulateColumn = ColumnText.duplicate(column);

			// simulate and find how many lines are written
			simulateColumn.go(true);
			int lineWritten = simulateColumn.getLinesWritten();
			if (lineWritten > 0) {
				float leading = simulateColumn.getLeading();
				float new_top = rectangle.getBottom() + (leading * lineWritten)
						+ 3;
				column.setYLine(new_top);
			}
		}

		return column;
	}
}
