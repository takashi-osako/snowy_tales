package snowy_tales.tools;

public class StaticText extends Base {
	private String value = "";
	private int fontSize = 10;

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

}
