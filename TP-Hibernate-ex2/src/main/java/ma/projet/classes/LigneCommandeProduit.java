package ma.projet.classes;

import jakarta.persistence.*;

@Entity
//@NamedQuery(name = "findByCommande", query = "FROM Produit p join LigneCommandeProduit l l.produit join Commande c  l.commande where c.id = :id")
//amedQuery(name = "findByCommande", query = "FROM LigneCommandeProduit  join Produit p LigneCommandeProduit.produit join LigneCommandeProduit.commande Commande c where c.id = :id")

@IdClass(LigneCommandeProduitPK.class)
public class LigneCommandeProduit {


    private int quantite;
    @Transient
    private LigneCommandeProduitPK id;

    @Id
    @ManyToOne()
    @JoinColumn(name="commande",referencedColumnName="id",insertable = false,updatable = false)
    private Commande commande;

    @Id
    @ManyToOne()
    @JoinColumn(name="produit",referencedColumnName="id",insertable = false,updatable = false)
    private Produit produit;

    public LigneCommandeProduit(LigneCommandeProduitPK id, int quantite) {
        this.id = id;
        this.quantite = quantite;
    }


    public LigneCommandeProduit(int quantite, Commande commande, Produit produit) {
        this.quantite = quantite;
        this.commande = commande;
        this.produit = produit;
    }

    public LigneCommandeProduit() {
    }

    public LigneCommandeProduitPK getId() {
        return id;
    }

    public void setId(LigneCommandeProduitPK id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }





}