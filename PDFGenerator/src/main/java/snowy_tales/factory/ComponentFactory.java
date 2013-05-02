package snowy_tales.factory;

import java.util.LinkedHashMap;

import snowy_tales.manager.TemplateDataManager;
import snowy_tales.tools.Base;
import snowy_tales.tools.StaticText;

public class ComponentFactory {
	public static StaticText createStaticText(LinkedHashMap<String, Object> data) {
		StaticText text = new StaticText();
		TemplateDataManager templateDataManager = new TemplateDataManager(data);
		initBase(text, templateDataManager);
		text.setValue((String) data.get("value"));
		text.setFontSize(templateDataManager.getIntValue("font-size"));
		text.setFontFamily(templateDataManager.getStringValue("font-family"));
		text.setTextAlign(templateDataManager.getStringValue("text-align"));
		text.setColor(templateDataManager.getStringValue("color"));
		text.setBackgrounColor(templateDataManager
				.getStringValue("background-color"));
		text.setVerticalAlign(templateDataManager
				.getStringValue("vertical-align"));

		return text;
	}

	private static void initBase(Base base,
			TemplateDataManager templateDataManager) {
		float top = templateDataManager.getFloatValue("top");
		float left = templateDataManager.getFloatValue("left");
		float height = templateDataManager.getFloatValue("height");
		float width = templateDataManager.getFloatValue("width");

		base.setTop(top);

		base.setLeft(left);

		base.setHeight(height);

		base.setWidth(width);
	}
}
