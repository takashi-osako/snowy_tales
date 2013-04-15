package snowy_tales.manager;

import java.util.LinkedHashMap;

import snowy_tales.tools.Base;
import snowy_tales.tools.StaticText;

public class ComponentCreator {
	public static StaticText createStaticText(LinkedHashMap<String, Object> data) {
		StaticText text = new StaticText();
		initBase(text, data);
		text.setValue((String) data.get("value"));
		return text;
	}

	private static void initBase(Base base, LinkedHashMap<String, Object> data) {
		float top = 0;
		float left = 0;
		float height = 0;
		float width = 0;
		if (data.get("top") instanceof Float) {
			top = (Float) data.get("top");
		} else if (data.get("top") instanceof Integer) {
			int t = (Integer) data.get("top");
			top = t;
		}
		base.setTop(top);

		if (data.get("left") instanceof Float) {
			left = (Float) data.get("left");
		} else if (data.get("left") instanceof Integer) {
			int t = (Integer) data.get("left");
			left = t;
		}
		base.setLeft(left);
		if (data.get("height") instanceof Float) {
			height = (Float) data.get("height");
		} else if (data.get("height") instanceof Integer) {
			int t = (Integer) data.get("height");
			height = t;
		}
		base.setHeight(height);
		if (data.get("width") instanceof Float) {
			width = (Float) data.get("width");
		} else if (data.get("width") instanceof Integer) {
			int t = (Integer) data.get("width");
			width = t;
		}
		base.setWidth(width);
	}
}
