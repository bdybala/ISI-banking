package isi.project.banking.auth;


import no.vianett.sms.SmsEventListener;
import no.vianett.sms.Sms;
import no.vianett.sms.SmsEvent;
import no.vianett.sms.component.SmsTransceiver;
import no.vianett.sms.log.SmsScreenLogger;
import no.vianett.sms.event.SmsDeliveredEvent;
import no.vianett.sms.event.SmsSendingFailedEvent;
import no.vianett.sms.event.SmsDeliveryFailedEvent;
import java.util.Random;

public class AuthSMS {
	private String generateCode() {
		Random rand = new Random();
		String pass  = "";

		for(int i=0; i < 10; i++) {
			pass += rand.nextInt(10);
		}
		return pass;
	}

	public String send() {
		
		String pass = generateCode();
		System.out.println(pass);
		new SmsSender("Twoje haslo to: " + pass, "608595488");
		
		return pass;
	}
	

}


