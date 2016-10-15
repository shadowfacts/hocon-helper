package net.shadowfacts.hoconhelper;

import com.typesafe.config.Config;

/**
 * @author shadowfacts
 */
public interface DeserializationContext {

	<T> T deserialize(Config config, Class<T> clazz);

}
