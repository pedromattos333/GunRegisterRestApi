/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.gunRegister.util;

import br.com.senac.gunRegister.model.Usuario;
import br.com.senac.gunRegister.service.UsuarioService;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Recuperar {

    private final UsuarioService usuarioService;
    private final String emailUsuario = "pedromattos333@gmail.com";
    private final String emailSenha = "pedro333";

    public Recuperar() {
        this.usuarioService = new UsuarioService();
    }

    public boolean send(String email) {

        Usuario usuario = usuarioService.getUserByEmail(email);

        if (usuario != null) {

            Properties props = new Properties();
            
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(emailUsuario, emailSenha);
                        }
                    });

          
            session.setDebug(true);

            try {

                Message mensagem = new MimeMessage(session);
                mensagem.setFrom(new InternetAddress(emailUsuario));
             

                Address[] toUser = InternetAddress.parse(usuario.getEmail());
              
                
                mensagem.setRecipients(Message.RecipientType.TO, toUser);
                mensagem.setSubject("Recuperação de senha");
                mensagem.setText("Não responda esse e-mail!"
                        + "\n\nSua senha de acesso é:"
                        + "\nSenha: " + usuario.getSenha());
                      
           
                Transport.send(mensagem);

                System.out.println("Enviado");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }
}
