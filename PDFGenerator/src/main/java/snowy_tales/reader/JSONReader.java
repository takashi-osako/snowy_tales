package snowy_tales.reader;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JSONReader {
	public static Map<String, Object> getMap(String content)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> userInMap = mapper.readValue(content,
				new TypeReference<Map<String, Object>>() {
				});
		return userInMap;
	}
}
