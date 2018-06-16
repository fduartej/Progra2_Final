package com.example.demoBatch.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailServiceImpl")
public class MailServiceImpl{

	@Autowired
	private JavaMailSender javaMailSender;	
	
	public void enviarCorreo(String correo,String mensaje) {
		
			SimpleMailMessage mailmessage = new SimpleMailMessage();
			
			mailmessage.setFrom("programacion.usmp@gmail.com");
			mailmessage.setTo(correo);
			mailmessage.setSubject("Bienvenido, para ver la lista de autos disponibles, seleccione el siguiente enlace: ");
			mailmessage.setText(mensaje);
			
			javaMailSender.send(mailmessage);
	}

}
