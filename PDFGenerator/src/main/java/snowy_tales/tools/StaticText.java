package snowy_tales.tools;

public class StaticText extends Base {
	private String value = "";
	private int fontSize = 10;
	private String fontFamily = null;
	private String textAlign = null;
	private String verticalAlign = null;
	private String color = null;
	private String backgrounColor = null;
	private Boolean italic = false;
	private Boolean bold = false;
	private Boolean underline = false;
	private String borderStyle = null;
	private int borderWidth = 0;

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

	public Boolean isItalic() {
		return this.italic;
	}

	public void setItalic(Boolean isItalic) {
		this.italic = isItalic;
	}

	public Boolean isBold() {
		return this.bold;
	}

	public void setBold(Boolean isBold) {
		this.bold = isBold;
	}

	public Boolean isUnderlined() {
		return this.underline;
	}

	public void setUnderlined(Boolean isUnderlined) {
		this.underline = isUnderlined;
	}

	public String getBorderStyle() {
		return borderStyle;
	}

	public void setBorderStyle(String borderStyle) {
		this.borderStyle = borderStyle;
	}

	public int getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(int borderWidth) {
		this.borderWidth = borderWidth;
	}
}
