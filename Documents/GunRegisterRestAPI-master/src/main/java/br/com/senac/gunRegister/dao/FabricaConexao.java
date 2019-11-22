
package br.com.senac.gunRegister.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class FabricaConexao {

    private static EntityManagerFactory factory;
    
  
    static {
        factory = Persistence.createEntityManagerFactory("GunPU");
    }
    
    public static EntityManager openConnection() {
        return factory.createEntityManager();
    }
}
