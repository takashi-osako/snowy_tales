package snowy_tales.tools;

public class StaticText extends Base {
	private String value = "";
	private int fontSize = 10;
	private String fontFamily = null;
	private String textAlign = null;
	private String verticalAlign = null;
	private String color = null;
	private String backgrounColor = null;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public String getFontFamily() {
		return fontFamily;
	}

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}

	public String getTextAlign() {
		return textAlign;
	}

	public void setTextAlign(String textAlign) {
		this.textAlign = textAlign;
	}

	public String getVerticalAlign() {
		return verticalAlign;
	}

	public void setVerticalAlign(String verticalAlign) {
		this.verticalAlign = verticalAlign;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBackgrounColor() {
		return backgrounColor;
	}

	public void setBackgrounColor(String backgrounColor) {
		this.backgrounColor = backgrounColor;
	}
}
