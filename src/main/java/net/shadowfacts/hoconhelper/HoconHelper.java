package net.shadowfacts.hoconhelper;

import com.typesafe.config.Config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shadowfacts
 */
public class HoconHelper implements DeserializationContext {

	private final Map<Class, Deserializer> deserializers;

	private HoconHelper(Map<Class, Deserializer> deserializers) {
		this.deserializers = deserializers;
	}

	@Override
	public <T> T deserialize(Config config, Class<T> clazz) {
		if (deserializers.containsKey(clazz)) {
			return (T)deserializers.get(clazz).deserialize(config, this);
		} else {
			throw new RuntimeException("No deserializer for class " + clazz.getName());
		}
	}

	public static class Builder {
		private final Map<Class, Deserializer> deserializers = new HashMap<>();

		public <T> Builder register(Class<T> clazz, Deserializer<T> deserializer) {
			deserializers.put(clazz, deserializer);
			return this;
		}

		public HoconHelper create() {
			return new HoconHelper(Collections.unmodifiableMap(deserializers));
		}
	}

}
