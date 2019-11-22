/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.gunRegister.service;

import br.com.senac.gunRegister.dao.FabricaConexao;
import br.com.senac.gunRegister.dao.UsuarioDao;
import br.com.senac.gunRegister.model.Usuario;
import java.sql.SQLException;
import javax.persistence.EntityManager;

/**
 *
 * @author Alunos
 */
public class UsuarioService {

    private UsuarioDao usuarioDao;
    private EntityManager em;

    public UsuarioService() {
        em = FabricaConexao.openConnection();
        usuarioDao = new UsuarioDao(em);
    }
    
    public void salvar(Usuario usuario) throws SQLException{
        usuarioDao.salvar(usuario);
    }
    
    public Usuario validateUser(String email, String passwd){
        return usuarioDao.validaUsuario(email, passwd);
    }
    
    public Usuario getUserByEmail(String email){
        return usuarioDao.pesquisarPorEmail(email);
    }
}
