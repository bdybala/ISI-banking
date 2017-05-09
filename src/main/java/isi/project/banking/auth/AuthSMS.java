package isi.project.banking.auth;

import java.util.Random;

public class AuthSMS {
	private String generateCode() {
		Random rand = new Random();
		String pass  = "";

		for(int i=0; i < 8; i++) {
			pass += rand.nextInt(10);
		}
		return pass;
	}

	public String sendCode() {
		
		String pass = generateCode();
		//new SmsSender("Twoj kod to: " + pass, "608595488");
		return pass;
	}
	

}


