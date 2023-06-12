package br.ifc.edu.e7;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(200.0, "Cartão SD 128 GB", "SanDisk"));
        produtos.add(new Produto(150.0, "Teclado", "Redragon"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        for (Produto x : produtos) {
            em.persist(x);
        }
        tx.commit();

        Query query = em.createQuery("from Produto", Produto.class);
        List<Produto> returnProdutos = (List<Produto>) query.getResultList();
        for(Produto x : returnProdutos){
            System.out.println(x.toString());
        }
        em.close();
        emf.close();
    }
}


