
package br.com.senac.gunRegister.dao;

import br.com.senac.gunRegister.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class UsuarioDao extends BaseDaoImpl {

    public UsuarioDao(EntityManager em) {
        super(em);
    }

    @Override
    public Object pesquisarPorNome(String nome) {
        return null;
    }

    @Override
    public Object pesquisarPorId(Long id) {
        throw new UnsupportedOperationException("pesquisa por id"); 
    }

    public Usuario pesquisarPorEmail(String email) {
        Usuario user = null;

        try {
            em.getTransaction().begin();
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class);
            user = query.setParameter("email", email).getSingleResult();

            if (user != null) {
                em.getTransaction().commit();
                return user;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        em.getTransaction().commit();
        return null;
    }

    public Usuario validaUsuario(String email, String senha) {

        Usuario user = null;

        try {
            em.getTransaction().begin();
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class);
            user = query.setParameter("email", email).getSingleResult();

            if (user != null) {
                if (user.getSenha().equals(senha)) {
                    em.getTransaction().commit();
                    return user;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        em.getTransaction().commit();
        return null;
    }
}
