package snowy_tales.factory;

import com.itextpdf.text.BaseColor;

public class ColorFactory {
	public static BaseColor getColor(String string_color, BaseColor default_color){
		BaseColor color = default_color;
		if (string_color != null) {
			string_color = string_color.toLowerCase();
			if ("white".equals(string_color)) {
				color = BaseColor.WHITE;
			} else if ("black".equals(string_color)) {
				color = BaseColor.BLACK;
			}else if ("red".equals(string_color)) {
				color = BaseColor.RED;
			}else if ("blue".equals(string_color)) {
				color = BaseColor.BLUE;
			}else if ("yellow".equals(string_color)) {
				color = BaseColor.YELLOW;
			}else if ("green".equals(string_color)) {
				color = BaseColor.GREEN;
			}else if ("orange".equals(string_color)) {
				color = BaseColor.ORANGE;
			}else if ("lightgray".equals(string_color)) {
				color = BaseColor.LIGHT_GRAY;
			}else if ("cyan".equals(string_color)) {
				color = BaseColor.CYAN;
			}else if ("darkgray".equals(string_color)){
				color = BaseColor.DARK_GRAY;
			}else if ("pink".equals(string_color)){
				color = BaseColor.PINK;
			}else if ("magenta".equals(string_color)){
				color = BaseColor.MAGENTA;
			}
		}
		return color;
	}
}
