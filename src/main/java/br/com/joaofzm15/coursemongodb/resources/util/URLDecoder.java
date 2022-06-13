package br.com.joaofzm15.coursemongodb.resources.util;

import java.io.UnsupportedEncodingException;

public class URLDecoder {

	public static String decodeParam(String text) {
		try {
			return java.net.URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
