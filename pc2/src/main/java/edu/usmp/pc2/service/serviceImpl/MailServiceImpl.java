package edu.usmp.pc2.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailServiceImpl")
public class MailServiceImpl{

	@Autowired
	private JavaMailSender javaMailSender;	
	
	public void enviarCorreo(String correo) {
		
			SimpleMailMessage mailmessage = new SimpleMailMessage();
			
			mailmessage.setFrom("programacion.usmp@gmail.com");
			mailmessage.setTo(correo);
			mailmessage.setSubject("Calculo de Renta Entrega 1");
			mailmessage.setText("Bienvenido al sistema");
			
			javaMailSender.send(mailmessage);
	}

}
