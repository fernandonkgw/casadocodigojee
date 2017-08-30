package br.com.casadocodigo.loja.security;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.jboss.security.Base64Encoder;

public class PassGenerator {
	
	public static void main(String[] args) {
		System.out.println(new PassGenerator().generate("123"));
	}
	
	public String generate(String senhaTexto) {
		try {
			byte[] digest = MessageDigest.getInstance("sha-256").digest(senhaTexto.getBytes());
			
			return Base64Encoder.encode(digest);
		} catch (NoSuchAlgorithmException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
