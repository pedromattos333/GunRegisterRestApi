package br.com.senac.gunRegister.util;

import javax.persistence.Persistence;

public class Gerador {

    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("GunPU");
    }

}
