package slackmessage;

import com.mendix.systemwideinterfaces.MendixRuntimeException;
import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtils {
	public static String encryptString(String key, String valueToEncrypt) throws Exception {
		if (valueToEncrypt == null) {
			return null;
		}
		if (key == null) {
			throw new MendixRuntimeException("Key should not be empty");
		}
		if (key.length() != 16) {
			throw new MendixRuntimeException("Key length should be 16");
		}
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		SecretKeySpec k = new SecretKeySpec(key.getBytes(), "AES");
		c.init(Cipher.ENCRYPT_MODE, k);
		byte[] encryptedData = c.doFinal(valueToEncrypt.getBytes());
		byte[] iv = c.getIV();

		return Base64.getEncoder().encodeToString(iv) + ";" + Base64.getEncoder().encodeToString(encryptedData);
	}

	public static String decryptString(String key, String valueToDecrypt) throws Exception {
		if (valueToDecrypt == null) {
			return null;
		}
		if (key == null) {
			throw new MendixRuntimeException("Key should not be empty");
		}
		if (key.length() != 16) {
			throw new MendixRuntimeException("Key length should be 16");
		}
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		SecretKeySpec k = new SecretKeySpec(key.getBytes(), "AES");
		String[] s = valueToDecrypt.split(";");
		if (s.length < 2) //Not an encrypted string, just return the original value.
		{
			return valueToDecrypt;
		}
		byte[] iv = Base64.getDecoder().decode(s[0].getBytes());
		byte[] encryptedData = Base64.getDecoder().decode(s[1].getBytes());
		c.init(Cipher.DECRYPT_MODE, k, new IvParameterSpec(iv));
		return new String(c.doFinal(encryptedData));
	}
}
