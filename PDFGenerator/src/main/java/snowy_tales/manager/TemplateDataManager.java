package snowy_tales.manager;

import java.util.LinkedHashMap;

public class TemplateDataManager {
	private LinkedHashMap<String, Object> data;

	public TemplateDataManager(LinkedHashMap<String, Object> data) {
		this.data = data;
	}

	public float getFloatValue(String name) {
		float rtn = 0;
		Object value = getValue(name);
		if (value instanceof Float) {
			rtn = (Float) value;
		} else if (value instanceof Double) {
			double t = (Double) value;
			rtn = (float) t;
		} else if (value instanceof Integer) {
			int t = (Integer) value;
			rtn = t;
		} else if (value instanceof String) {
			rtn = Float.parseFloat((String) value);
		}
		return rtn;
	}

	public int getIntValue(String name) {
		int rtn = 0;
		Object value = getValue(name);
		if (value instanceof Float) {
			float t = (Float) value;
			rtn = (int) t;
		} else if (value instanceof Double) {
			double t = (Double) value;
			rtn = (int) t;
		} else if (value instanceof Integer) {
			int t = (Integer) value;
			rtn = t;
		} else if (value instanceof String) {
			rtn = Integer.parseInt((String) value);
		}
		return rtn;
	}

	public String getStringValue(String name) {
		Object value = getValue(name);
		String rtn = "";
		if (value != null) {
			rtn = value.toString();
		}
		return rtn;
	}

	private Object getValue(String name) {
		LinkedHashMap<String, Object> target_data = (LinkedHashMap<String, Object>) this.data
				.get(name);
		return target_data.get("value");
	}
}
