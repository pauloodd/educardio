package struts.mensagens;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {

	private static final String BUNDLE_NAME = "struts/messages/MessageResources"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME); 

	private Messages() {
	}

	public static String getString(String key) {
		String ret;

		try {
			ret = RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			ret = "!" + key + "!";
		}

		return ret;
	}
}
