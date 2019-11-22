
package br.com.senac.gunRegister.dao;

import javax.persistence.EntityManager;


public abstract class BaseDaoImpl implements BaseDao{

    protected EntityManager em;

    public BaseDaoImpl(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public void salvar(Object object) {

        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public void alterar(Object object) {

        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
    }

    @Override
    public void excluir(Object object) {

        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
    }
}
