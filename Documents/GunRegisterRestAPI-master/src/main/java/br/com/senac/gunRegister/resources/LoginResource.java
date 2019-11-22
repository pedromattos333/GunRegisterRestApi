
package br.com.senac.gunRegister.resources;

import br.com.senac.gunRegister.model.Usuario;
import br.com.senac.gunRegister.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginResource {

    private UsuarioService usuarioService;

    public LoginResource() {
        this.usuarioService = new UsuarioService();
    }

    @GetMapping("/login/{email}/{senha}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable String email, @PathVariable String senha) {
        Usuario encontrado = null;
        try {
            encontrado = usuarioService.validateUser(email, senha);
            
            if (encontrado != null) {
                return ResponseEntity.ok(encontrado);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/login")
    public ResponseEntity<Usuario> validarUsuario(){
        Usuario encontrado = null;
        String email = "";
        String senha = "";
        
        try {
            encontrado = usuarioService.validateUser(email, senha);
            
            if (encontrado != null) {
                return ResponseEntity.ok(encontrado);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ResponseEntity.notFound().build();
    }
}
