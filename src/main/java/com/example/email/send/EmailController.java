package com.example.email.send;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.email.EmailMessage;
import com.example.email.EmailServer;

@RestController
@RequestMapping("/email")
public class EmailController {

    // O Spring injetará o EmailServer (@Service)
    private final EmailServer emailServer; 

    // O Spring injeta automaticamente, desde que EmailServer seja um @Service
    public EmailController(EmailServer emailServer) {
        this.emailServer = emailServer; 
    }

    // Endpoint: POST http://localhost:8080/email/send
    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailMessage message) {
        
        boolean success = emailServer.sendEmail(message);

        if (success) {
            // Isso cria um JSON manual: { "mensagem": "Email enviado com sucesso." }
            return ResponseEntity.ok("{ \"mensagem\": \"Email enviado com sucesso.\" }");
        } else {
            return ResponseEntity.badRequest().body("{ \"erro\": \"Falha ao enviar o email. Verifique os endereços.\" }");
        }
    }
}