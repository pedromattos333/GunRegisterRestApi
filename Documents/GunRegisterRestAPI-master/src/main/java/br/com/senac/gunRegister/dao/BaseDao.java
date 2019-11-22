package br.com.senac.gunRegister.dao;

import java.util.List;

public interface BaseDao {

    void salvar(Object object);

    void alterar(Object object);

    void excluir(Object object);

    Object pesquisarPorId(Long id);
    
    Object pesquisarPorNome(String nome);
}