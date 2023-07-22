package com.example.gestion_de_produits.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDao {

    private Connection conn;

    public void ConnectPostGreSql() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost/postgres?user=postgres&password=0000";

            conn = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Produit> listProduit()
    {
        List<Produit> Produits = new ArrayList<Produit>();
        ConnectPostGreSql();

        Statement st = null ;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select *  FROM PRODUIIT");
            while (rs.next()) {
                Produits.add(new Produit(rs.getInt("ProdId"),rs.getString("nom"),rs.getString("description"),rs.getInt("Prix")));

             }

            return Produits;
           }
        catch  (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void addProduit(Produit p) {
        try {
            ConnectPostGreSql();
            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO produiit(nom,descripion,prix) VALUES(?, ?,?);");
            preparedStatement.setString(1, p.getNom());
            preparedStatement.setString(2, p.getDescription());
            preparedStatement.setInt(3, p.getPrix());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();

        }


    }
    public void deleteProduit(String id)  {

        ConnectPostGreSql();

        try {
            PreparedStatement ps =
                    conn.prepareStatement("DELETE FROM produit WHERE id = ?");
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }







}
