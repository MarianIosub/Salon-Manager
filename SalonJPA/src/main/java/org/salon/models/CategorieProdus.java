package org.salon.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CATEGORII_PRODUSE")
public class CategorieProdus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String denumire;
    @OneToMany
    private List<Produs> produse;

    public CategorieProdus() {
    }

    public CategorieProdus(String denumire) {
        this.denumire = denumire;
        produse = new ArrayList<>();
    }

    public CategorieProdus(String denumire, List<Produs> produse) {
        this.denumire = denumire;
        this.produse = produse;
    }

    public void addProdus(Produs produs) {
        if (!produse.contains(produs)) {
            produse.add(produs);
        }
    }

    public void removeProdus(Produs produs) {
        produse.remove(produs);
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public void setProduse(List<Produs> produse) {
        this.produse = produse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieProdus that = (CategorieProdus) o;
        return getId() == that.getId() && Objects.equals(getDenumire(), that.getDenumire());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDenumire());
    }

    @Override
    public String toString() {
        return "CategorieProdus{" +
                "id=" + id +
                ", denumire='" + denumire + '\'' +
                ", produse=" + produse +
                '}';
    }
}
