package snowy_tales.factory;

import com.itextpdf.text.BaseColor;

public class ColorFactory {
	public static BaseColor getColor(String string_color, BaseColor default_color){
		BaseColor color = default_color;
		if (string_color != null) {
			if ("white".equals(string_color.toLowerCase())) {
				color = BaseColor.WHITE;
			} else if ("black".equals(string_color.toLowerCase())) {
				color = BaseColor.BLACK;
			}else if ("red".equals(string_color.toLowerCase())) {
				color = BaseColor.RED;
			}else if ("blue".equals(string_color.toLowerCase())) {
				color = BaseColor.BLUE;
			}else if ("yellow".equals(string_color.toLowerCase())) {
				color = BaseColor.YELLOW;
			}else if ("green".equals(string_color.toLowerCase())) {
				color = BaseColor.GREEN;
			}else if ("orange".equals(string_color.toLowerCase())) {
				color = BaseColor.ORANGE;
			}else if ("light grey".equals(string_color.toLowerCase())) {
				color = BaseColor.LIGHT_GRAY;
			}else if("cyan".equals(string_color.toLowerCase())) {
				color = BaseColor.CYAN;
			}
		}
		return color;
	}
}
