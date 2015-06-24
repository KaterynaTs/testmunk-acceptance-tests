package Framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjectProperties {

    private String browserName;

	private ProjectProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("global.properties"));
            properties.putAll(System.getProperties());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        browserName = properties.getProperty("browserName");
	}

	private static ProjectProperties properties;

	public static ProjectProperties getInstance() {
		if (properties == null) {
			properties = new ProjectProperties();
		}
		return properties;
	}

    public String getBrowserName() {
        return browserName;
    }
}
