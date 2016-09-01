package com.czx.encryption;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Assert;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * BASE64��MD5��SHA��HMAC
 * java ���ּ����㷨
 * 
 * BASE64�ļ��ܽ�����˫��ģ������󷴽⡣ 
   MD5��SHA�Լ�HMAC�ǵ�����ܣ��κ����ݼ��ܺ�ֻ�����Ψһ��һ�����ܴ���
       ͨ������У�������ڴ���������Ƿ��޸ġ�����HMAC�㷨��һ����Կ��
       ��ǿ�����ݴ�������еİ�ȫ�ԣ�ǿ�����㷨��Ĳ��ɿ����ء�
 * ����/�������֪ʶ�ɲο�
 * 		snowolf�Ĳ��� http://snowolf.iteye.com/category/68576
 * @author admin
 *
 */

public class CodecAndCryp {

	 public static final String KEY_SHA = "SHA";  
	 public static final String KEY_MD5 = "MD5";  
	 /** 
     * MAC�㷨��ѡ���¶����㷨 
     *  
     * <pre> 
     * HmacMD5  
     * HmacSHA1  
     * HmacSHA256  
     * HmacSHA384  
     * HmacSHA512 
     * </pre> 
     */  
	 public static final String KEY_MAC = "HmacMD5";  
	
	/**
	 * BASE64���� 
	 */
	public static byte[] decryptBASE64(String key) throws IOException{
		return (new BASE64Decoder()).decodeBuffer(key);
	}
	
	/**
	 * BASE64����
	 * BASE���ܺ�������ֽ�λ����8�ı������������λ����=�������
	 */
	public static String encryptBASE64(byte[] key){
		return (new BASE64Encoder()).encodeBuffer(key);
	}
	
	/**
	 *  MD5 -- message-digest algorithm 5 ����Ϣ-ժҪ�㷨����д
	 *  ͨ�����ǲ�ֱ��ʹ������MD5���ܡ�ͨ����MD5�������ֽ����齻��BASE64�ټ���һ�ѣ��õ���Ӧ���ַ����� 
	 * @param args
	 * @throws Exception 
	 * @throws Exception
	 */
	public static byte[] encryptMD5(byte[] data) throws Exception{
		MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
		md5.update(data);  
		return md5.digest();
	}
	
	/**
	 *  SHA(Secure Hash Algorithm����ȫɢ���㷨��
	 * @param args
	 * @throws Exception 
	 * @throws Exception
	 */
	public static byte[] encryptSHA(byte[] data) throws Exception{
		MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
		sha.update(data);  
		return sha.digest();
	}
	
	/** 
     * ��ʼ��HMAC��Կ 
     *  
     * @return 
     * @throws Exception 
     */  
	 public static String initMacKey() throws Exception {  
		 KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);
		 SecretKey secretKey = keyGenerator.generateKey();
		 return encryptBASE64(secretKey.getEncoded());  
	 }  
	 
	 /** 
     * HMAC���� 
     *  
     * @param data 
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static byte[] encryptHMAC(byte[] data, String key) throws Exception {  
  
        SecretKey secretKey = new SecretKeySpec(decryptBASE64(key), KEY_MAC);  
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());  
        mac.init(secretKey);  
  
        return mac.doFinal(data);  
    }  

	
	public static void main(String[] args) throws Exception {
		//base64����/����
		String s = "�����人";
		String encode = CodecAndCryp.encryptBASE64(s.getBytes());
		System.err.println("BASE64����:\n" + encode);
		System.err.println("BASE64����:\n" +new String(CodecAndCryp.decryptBASE64(encode)));
		
		//MD5����
		String s1= "a123123";
		System.err.println("MD5����:\n" +new String(encryptBASE64(encryptMD5(s1.getBytes()))));
		Assert.assertArrayEquals(encryptMD5(s1.getBytes()), encryptMD5(s1.getBytes()));
		
		//SHA����
		String s2= "a123123";
		System.err.println("SHA����:\n" +new String(encryptBASE64(encryptSHA(s2.getBytes()))));
		Assert.assertArrayEquals(encryptMD5(s1.getBytes()), encryptMD5(s1.getBytes()));
		
		//HMAC���� 
		String s3= "a123123";
		String key = initMacKey();
		System.err.println("HMAC����:\n" +new String(encryptBASE64(encryptHMAC(s3.getBytes(),key))));
		
	    BigInteger md5 = new BigInteger(encryptMD5(s1.getBytes()));  
	    System.err.println("MD5:\n" + md5.toString(16));  
	    
	    BigInteger sha = new BigInteger(encryptSHA(s1.getBytes()));  
        System.err.println("SHA:\n" + sha.toString(32));  
        
        BigInteger mac  = new BigInteger(encryptHMAC(s3.getBytes(),key));  
        System.err.println("HMAC:\n" + mac.toString(16));  
	}
}
