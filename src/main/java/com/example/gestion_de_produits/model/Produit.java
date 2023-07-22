package com.example.gestion_de_produits.model;


import jakarta.persistence.*;

@Entity
@Table(name = "produiit")


public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produiit_SEQ")
    @SequenceGenerator(name = "produiit_SEQ", sequenceName = "produit_id_seq", allocationSize = 1)

    private Integer id;
    @Column(name ="nom")
    private String nom;
    @Column(name ="description")
    private String description;
    @Column(name ="prix")
    private int Prix;

    public Produit() {
    }

    public Produit(int id, String nom, String description, int prix) {
        id = id;
        this.nom = nom;
        this.description = description;
        Prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setProdId(int id) {
        id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrix() {
        return Prix;
    }

    public void setPrix(int prix) {
        Prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "ProdId=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", Prix=" + Prix +
                '}';
    }
}

