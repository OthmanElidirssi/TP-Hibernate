package ma.projet.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String marque;
    private String reference;
    @Temporal(TemporalType.DATE)
    private Date dataAchat;
    private double prix;
    private String designation;


    public Produit(){

    }
    public Produit(String marque, String reference, Date dataAchat, double prix, String designation) {
        this.marque = marque;
        this.reference = reference;
        this.dataAchat = dataAchat;
        this.prix = prix;
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDataAchat() {
        return dataAchat;
    }

    public void setDataAchat(Date dataAchat) {
        this.dataAchat = dataAchat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", reference='" + reference + '\'' +
                ", dataAchat=" + dataAchat +
                ", prix=" + prix +
                ", designation='" + designation + '\'' +
                '}';
    }
}
