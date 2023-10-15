package ma.projet.classes;

import jakarta.persistence.Embeddable;

import java.io.Serializable;


public class LigneCommandeProduitPK implements Serializable {

    private int produit;

    private int commande;

    public LigneCommandeProduitPK() {
    }

    public LigneCommandeProduitPK(int produit, int commande) {
        this.produit = produit;
        this.commande = commande;
    }

    public int getProduit() {
        return produit;
    }

    public void setProduit(int produit) {
        this.produit = produit;
    }

    public int getCommande() {
        return commande;
    }

    public void setCommande(int commande) {
        this.commande = commande;
    }



}

