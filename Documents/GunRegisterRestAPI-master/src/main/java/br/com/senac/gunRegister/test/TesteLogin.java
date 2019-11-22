/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.gunRegister.test;

import br.com.senac.gunRegister.dao.FabricaConexao;
import br.com.senac.gunRegister.dao.UsuarioDao;
import br.com.senac.gunRegister.model.Usuario;
import javax.persistence.EntityManager;


public class TesteLogin {

    public static void main(String[] args) {
        EntityManager em = FabricaConexao.openConnection();
        UsuarioDao userDao = new UsuarioDao(em);

        Usuario user = userDao.validaUsuario("pedromattos33@teste.com", "");

        if (user != null) {
            System.out.println("Nome: " + user.getNome() + " Email: " + user.getEmail());
        }
    }
}
