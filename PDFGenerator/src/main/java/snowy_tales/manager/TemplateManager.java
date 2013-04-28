package snowy_tales.manager;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import snowy_tales.factory.ComponentFactory;
import snowy_tales.tools.StaticText;

public class TemplateManager {
	private List<StaticText> staticText = new ArrayList<StaticText>();

	public TemplateManager(Map<String, Object> data) {
		List<LinkedHashMap<String, Object>> list = (List<LinkedHashMap<String, Object>>) data
				.get("components");
		for (LinkedHashMap<String, Object> component : list) {
			staticText.add(ComponentFactory.createStaticText(component));
		}
	}

	public List<StaticText> getStaticText() {
		return staticText;
	}

}
