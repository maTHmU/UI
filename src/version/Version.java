package version;

import java.util.*;

public class Version {

	private static final String VERSION_NAME = "maTHmU v1.0.0";

	@SuppressWarnings("deprecation")
	private static final Date CREATED_DATE = new Date(109, 6, 2, 12, 30);

	public static String getVersionName() {
		return VERSION_NAME;
	}

	public static Date getCreatedDate() {
		return CREATED_DATE;
	}

}
