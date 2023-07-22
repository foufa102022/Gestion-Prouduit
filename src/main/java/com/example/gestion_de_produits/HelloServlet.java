package com.example.gestion_de_produits;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import com.example.gestion_de_produits.model.Produit;
import com.example.gestion_de_produits.model.ProduitDao;
import com.example.gestion_de_produits.model.hibernateProduit;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @Override

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {

//        ProduitDao PDao = new ProduitDao();
//        List<Produit> Produits = PDao.listProduit();

        hibernateProduit hdDao = null;
        List<Produit> produits = null;
        try {
            hibernateProduit PDao = new hibernateProduit();
            produits = PDao.listproduits();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        request.setAttribute("Produit", produits);

        this.getServletContext().getRequestDispatcher("/ProductList.jsp").forward(request,response);





    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int ProdId = Integer.parseInt(req.getParameter("id"));
        String nom = req.getParameter("nom");
        String description = req.getParameter("description");
        int Prix = Integer.parseInt(req.getParameter("Prix"));


        ProduitDao pDao =new ProduitDao();
        pDao.addProduit(new Produit(1,nom,description,Prix));

        doGet(req , res);

}}