package net.shadowfacts.hoconhelper;

import com.typesafe.config.Config;

/**
 * @author shadowfacts
 */
public interface Deserializer<T> {

	T deserialize(Config config, DeserializationContext context);

}
