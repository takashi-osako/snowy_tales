package snowy_tales.factory;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;

public class FontFactory {
	public static Font createFont(String font_family, int font_size, String color) {
		Font font = null;
		if ("Courier".equals(font_family)) {
			font = new Font(FontFamily.COURIER, font_size, Font.NORMAL, ColorFactory.getColor(color, BaseColor.BLACK));
		}
		return font;
	}
}
