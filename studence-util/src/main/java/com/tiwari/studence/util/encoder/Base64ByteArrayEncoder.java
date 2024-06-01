package com.tiwari.studence.util.encoder;

import org.apache.commons.codec.binary.Base64;

import com.google.inject.Singleton;

@Singleton
public class Base64ByteArrayEncoder implements IBiConverter<byte[], String> {
	public String convert(byte[] value) {
		byte[] base64Encoded = Base64.encodeBase64(value, false, true);
		return new String(base64Encoded);
	}

	public byte[] reverseConvert(String value) {
		return Base64.decodeBase64(value);
	}
}