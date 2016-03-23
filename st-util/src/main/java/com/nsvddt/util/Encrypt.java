package cn.com.nsv.ejb.util;

import java.security.MessageDigest;

/**
 * MD5方式的加密操作
 */
public class Encrypt
{
	/**
	 * 将字符串加密成32位长度的MD5码
	 * @param text 待加密的字符串
	 * @return 加密后的字符串
	 */
	public static String encodeByMD5(final String text)
	{
		String after = text;
		try
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(text.getBytes("US-ASCII"));
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digest.length; i++)
			{
				sb.append(Character.forDigit((digest[i] & 0xF0) >> 4, 16));
				sb.append(Character.forDigit((digest[i] & 0xF), 16));
			}
			after = sb.toString();
		}
		catch (Exception e)
		{
		}
		return after;
	}
}
