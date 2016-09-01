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
 * BASE64、MD5、SHA、HMAC
 * java 几种加密算法
 * 
 * BASE64的加密解密是双向的，可以求反解。 
   MD5、SHA以及HMAC是单向加密，任何数据加密后只会产生唯一的一个加密串，
       通常用来校验数据在传输过程中是否被修改。其中HMAC算法有一个密钥，
       增强了数据传输过程中的安全性，强化了算法外的不可控因素。
 * 加密/解密相关知识可参考
 * 		snowolf的博客 http://snowolf.iteye.com/category/68576
 * @author admin
 *
 */

public class CodecAndCryp {

	 public static final String KEY_SHA = "SHA";  
	 public static final String KEY_MD5 = "MD5";  
	 /** 
     * MAC算法可选以下多种算法 
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
	 * BASE64解密 
	 */
	public static byte[] decryptBASE64(String key) throws IOException{
		return (new BASE64Decoder()).decodeBuffer(key);
	}
	
	/**
	 * BASE64加密
	 * BASE加密后产生的字节位数是8的倍数，如果不够位数以=符号填充
	 */
	public static String encryptBASE64(byte[] key){
		return (new BASE64Encoder()).encodeBuffer(key);
	}
	
	/**
	 *  MD5 -- message-digest algorithm 5 （信息-摘要算法）缩写
	 *  通常我们不直接使用上述MD5加密。通常将MD5产生的字节数组交给BASE64再加密一把，得到相应的字符串。 
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
	 *  SHA(Secure Hash Algorithm，安全散列算法）
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
     * 初始化HMAC密钥 
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
     * HMAC加密 
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
		//base64加密/解密
		String s = "湖北武汉";
		String encode = CodecAndCryp.encryptBASE64(s.getBytes());
		System.err.println("BASE64加密:\n" + encode);
		System.err.println("BASE64解密:\n" +new String(CodecAndCryp.decryptBASE64(encode)));
		
		//MD5加密
		String s1= "a123123";
		System.err.println("MD5加密:\n" +new String(encryptBASE64(encryptMD5(s1.getBytes()))));
		Assert.assertArrayEquals(encryptMD5(s1.getBytes()), encryptMD5(s1.getBytes()));
		
		//SHA加密
		String s2= "a123123";
		System.err.println("SHA加密:\n" +new String(encryptBASE64(encryptSHA(s2.getBytes()))));
		Assert.assertArrayEquals(encryptMD5(s1.getBytes()), encryptMD5(s1.getBytes()));
		
		//HMAC加密 
		String s3= "a123123";
		String key = initMacKey();
		System.err.println("HMAC加密:\n" +new String(encryptBASE64(encryptHMAC(s3.getBytes(),key))));
		
	    BigInteger md5 = new BigInteger(encryptMD5(s1.getBytes()));  
	    System.err.println("MD5:\n" + md5.toString(16));  
	    
	    BigInteger sha = new BigInteger(encryptSHA(s1.getBytes()));  
        System.err.println("SHA:\n" + sha.toString(32));  
        
        BigInteger mac  = new BigInteger(encryptHMAC(s3.getBytes(),key));  
        System.err.println("HMAC:\n" + mac.toString(16));  
	}
}
