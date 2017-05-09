package isi.project.banking.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import no.vianett.sms.Sms;
import no.vianett.sms.component.SmsTransceiver;
import no.vianett.sms.log.SmsScreenLogger;

@Service
@Scope("prototype")
public class SmsSender {
	private SmsTransceiver transceiver = null;
	private int counter = 0;
	
	
	public SmsSender(String text, String number) {
		this.transceiver = SmsTransceiver.getInstance();
		String smsHost = "cpa.vianett.no";
		String smsPort = "31337";
		String smsUsername = "smigowski.wojciech@gmail.com";
		String smsPassword = "wf3ve";
		this.transceiver.initialize(smsHost, Integer.parseInt(smsPort), smsUsername, smsPassword,
				new SmsScreenLogger());
		Sms sms = new Sms();
		sms.setId(++this.counter);
		sms.setReplyPath(100);
		sms.setSender("1963"); // Set the sender number.
		sms.setMessage(text);
		sms.setRecipient("48" + number); // The recipients phone number.

		this.transceiver.send(sms);
	}
	
}