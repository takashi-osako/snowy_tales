package snowy_tales.factory;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;

public class FontFactory {
	public static Font createFont(String font_family, int font_size,
			String color, Boolean isItalic, Boolean isBold, Boolean isUnderlined) {
		Font font = null;
		int style = Font.NORMAL;
		FontFamily fontFamily = FontFamily.COURIER;
		font_family = font_family.toLowerCase();
		if ("helvetica".equals(font_family)) {
			fontFamily = FontFamily.HELVETICA;
		} else if ("symbol".equals(font_family)) {
			fontFamily = FontFamily.SYMBOL;
		} else if ("times new roman".equals(font_family)) {
			fontFamily = FontFamily.TIMES_ROMAN;
		} else if ("zapf dingbats".equals(font_family)) {
			fontFamily = FontFamily.ZAPFDINGBATS;
		}

		if (isItalic) {
			style += Font.ITALIC;
		}
		if (isBold) {
			style += Font.BOLD;
		}
		if (isUnderlined) {
			style += Font.UNDERLINE;
		}

		return new Font(fontFamily, font_size, style, ColorFactory.getColor(
				color, BaseColor.BLACK));
	}
}
