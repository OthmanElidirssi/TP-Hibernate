package org.example;

import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProduitService service=new ProduitService(HibernateUtil.getSessionFactory());


        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, Calendar.OCTOBER);
        calendar.set(Calendar.DAY_OF_MONTH, 8);

        Date specificDate = calendar.getTime();




        SessionFactory factory=service.getFactory();

        Session session=factory.openSession();

        Query<Produit> query=session.createQuery("From Produit p where p.dataAchat between :start and :end",Produit.class);

        query.setParameter("start",specificDate);
        query.setParameter("end",specificDate);

        List<Produit> list=query.list();

        for (Produit produit:list){
            System.out.println(produit);
        }



    }
}