package com.fivestar.crypto;

//import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt {
	
	private static final String key = "C686FBC86A3F4C92A6FD651E3A41BA3D";
	private static final String initVector = "1231233213214566";
	
	
	public static String encrypt(String strToEncrypt)
	{
		Random rand = new SecureRandom();
		byte[] bytes = new byte[16];
		rand.nextBytes(bytes);	
			//byte[] ivGen = generateIV();
			//IvParameterSpec iv = new IvParameterSpec(ivGen);
		
		try {
			
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
	       //String ivValue = Base64.getEncoder().encodeToString(iv.getIV());
			//SecretKeySpec skeySpec = new SecretKeyspec(secretKey.getBytes("UTF-8"),"AES");
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec,iv);
			
			byte[] encrypted = cipher.doFinal(strToEncrypt.getBytes("UTF-8"));
			//String original = new String(cipher.doFinal(Base64.getEncoder().encode(Encrypt);
			
			
			return Base64.getEncoder().encodeToString(encrypted);
	}		
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
		return null;
		
	}
}