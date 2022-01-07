package org.salon.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "FURNIZORI")
public class Furnizor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nume;
    @Column(name = "adresa_sediu")
    private String adresaSediu;
    @OneToMany
    private List<Produs> produse;
    @OneToMany
    private List<Ustensila> ustensile;

    public Furnizor() {
    }

    public Furnizor(String nume, String adresaSediu) {
        this.nume = nume;
        this.adresaSediu = adresaSediu;
        produse = new ArrayList<>();
        ustensile = new ArrayList<>();
    }

    public Furnizor(String nume, String adresaSediu, List<Produs> produse, List<Ustensila> ustensile) {
        this.nume = nume;
        this.adresaSediu = adresaSediu;
        this.produse = produse;
        this.ustensile = ustensile;
    }

    public void addProdus(Produs produs) {
        if (!produse.contains(produs)) {
            produse.add(produs);
        }
    }

    public void removeProdus(Produs produs) {
        produse.remove(produs);
    }

    public void addUstensila(Ustensila ustensila) {
        if (!ustensile.contains(ustensila)) {
            ustensile.add(ustensila);
        }
    }

    public void removeUstensila(Ustensila ustensila) {
        ustensile.remove(ustensila);
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public void setProduse(List<Produs> produse) {
        this.produse = produse;
    }

    public List<Ustensila> getUstensile() {
        return ustensile;
    }

    public void setUstensile(List<Ustensila> ustensile) {
        this.ustensile = ustensile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresaSediu() {
        return adresaSediu;
    }

    public void setAdresaSediu(String adresaSediu) {
        this.adresaSediu = adresaSediu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furnizor furnizor = (Furnizor) o;
        return getId() == furnizor.getId() && Objects.equals(getNume(), furnizor.getNume()) && Objects.equals(getAdresaSediu(), furnizor.getAdresaSediu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNume(), getAdresaSediu());
    }

    @Override
    public String toString() {
        return "Furnizor{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", adresaSediu='" + adresaSediu + '\'' +
                ", produse=" + produse +
                ", ustensile=" + ustensile +
                '}';
    }
}
