package utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordOps {

	/**
	 * Encrypts the provided string using SHA-256 algorythm
	 * @param base String to encrypt
	 * @return encrypted string
	 */
	public static String crypt(String base) {
		byte[] digested;
		String crypted = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(base.getBytes());
			digested = md.digest();
//			crypted = new String(digested);
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < digested.length; i++) {
				hexString.append(Integer.toHexString(0xFF & digested[i]));
			}
			crypted = hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return crypted;
	}
	
	/**
	 * Checks if the provided unencrypted password is the same as the encrypted, stored one
	 * @param passUncrypted Password entered by user at login
	 * @param passCrypted Password stored on DB
	 * @return True if password matches, False otherwise
	 */
	public static boolean verifyPass(String passUncrypted, String passCrypted) {
		if(StringUtils.isNullOrWhiteSpace(passCrypted) || StringUtils.isNullOrWhiteSpace(passUncrypted))
			return false;
		
		String tempCrypted = crypt(passUncrypted);
		return passCrypted.equals(tempCrypted);
	}
}
