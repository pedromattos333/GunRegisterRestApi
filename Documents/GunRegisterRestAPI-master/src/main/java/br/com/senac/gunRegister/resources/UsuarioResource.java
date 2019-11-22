/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.gunRegister.resources;

import br.com.senac.gunRegister.service.UsuarioService;
import br.com.senac.gunRegister.model.Usuario;
import java.sql.SQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsuarioResource {

    private UsuarioService usuarioService;

    public UsuarioResource() {
        this.usuarioService = new UsuarioService();
    }
    
    @PostMapping("/usuario")
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
        try {
            usuarioService.salvar(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @GetMapping("/usuario/{codigo}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable int codigo) {

        Usuario encontrado = null;

        if (encontrado != null) {
            return ResponseEntity.ok(encontrado);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
