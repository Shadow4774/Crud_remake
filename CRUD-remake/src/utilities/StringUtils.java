package utilities;

public class StringUtils {

	/**
	 * Checks if the provided string is either null or empty (no string was provided)
	 * @param string String to check
	 * @return True if string was null or empty, False otherwise
	 */
	public static boolean isNullOrWhiteSpace(String string) {
		return (string == null || string.trim().length() == 0);
	}
}
