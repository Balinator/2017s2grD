package edu.msg.ro.business.user.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Singleton;

import edu.msg.ro.persistence.user.entity.User;

@Singleton
public class UserPassword {
	public String encryptPassword(User user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] md_password = md.digest(user.getPassword().getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < md_password.length; i++) {
			sb.append(Integer.toString((md_password[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
}
