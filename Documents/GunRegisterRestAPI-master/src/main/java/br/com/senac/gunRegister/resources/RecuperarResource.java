/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.gunRegister.resources;

import br.com.senac.gunRegister.model.Usuario;
import br.com.senac.gunRegister.util.Recuperar;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RecuperarResource {

    private Recuperar sendRecover;

    public RecuperarResource() {
        this.sendRecover = new Recuperar();
    }

    @GetMapping("/recuperar/{email}")
    public ResponseEntity<Usuario> accountRecover(@PathVariable String email) {

        try {
            boolean r = sendRecover.send(email);
            if (r) {
                return ResponseEntity.ok().build();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ResponseEntity.notFound().build();
    }
}
