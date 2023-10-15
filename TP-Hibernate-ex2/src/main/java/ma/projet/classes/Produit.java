package ma.projet.classes;

import jakarta.persistence.*;

import javax.swing.*;

@Entity
@NamedNativeQuery(name = "betweenDate", query = "SELECT p.* FROM produit p inner join lignecommandeproduit l on p.id = l.produit inner join commande c on c.id = l.commande where c.date BETWEEN :d1 and :d2", resultClass = Produit.class)
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reference;
    private double prix;
    @ManyToOne
    private Categorie categorie;
    public Produit() {

    }

    public Produit(String reference, double prix, Categorie categorie) {
        this.reference = reference;
        this.prix = prix;
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }


}

