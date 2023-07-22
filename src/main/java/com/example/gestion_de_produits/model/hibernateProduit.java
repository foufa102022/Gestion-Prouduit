package com.example.gestion_de_produits.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.SQLException;
import java.util.List;

public class hibernateProduit {



    protected SessionFactory sessionFactory = null;
    public hibernateProduit() throws SQLException {
        final StandardServiceRegistry registry = new
                StandardServiceRegistryBuilder()
                .configure()
                .build();
        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }
    public void createProduit(Produit p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save( p) ;
        session.getTransaction().commit();
        session.close();
    }
    public List<Produit> listproduits() {
        Session session = sessionFactory.openSession();session.beginTransaction();
        List<Produit> produits = (List<Produit>) session.createQuery( "from Produit" ).list();
        session.getTransaction().commit();
        session.close();
        return produits;
    }
    public void deleteProduit(Produit p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete( p ) ;
        session.getTransaction().commit();
        session.close();
    }


}
