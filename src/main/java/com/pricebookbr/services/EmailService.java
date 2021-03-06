package com.pricebookbr.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.pricebookbr.domain.Cliente;
import com.pricebookbr.domain.Pedido;

@Service
public interface EmailService {

		void sendOrderConfirmationEmail(Pedido obj);

		void sendEmail(SimpleMailMessage msg);
		
		void sendOrderConfirmationHtmlEmail(Pedido obj);
				
		void sendHtmlEmail(MimeMessage msg);

		void sendNewPasswordEmail(Cliente cliente, String newPass);
		
		void sendChangePasswordEmail(Cliente cliente, String newPass);
}