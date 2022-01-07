package org.salon.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "SERVICII")
public class Serviciu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String denumire;
    @Column(name = "durata_ore")
    private int durata;

    public Serviciu() {
    }

    public Serviciu(String denumire, int durata) {
        this.denumire = denumire;
        this.durata = durata;
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

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serviciu serviciu = (Serviciu) o;
        return getId() == serviciu.getId() && Objects.equals(getDenumire(), serviciu.getDenumire()) && Objects.equals(getDurata(), serviciu.getDurata());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDenumire(), getDurata());
    }

    @Override
    public String toString() {
        return "Serviciu{" +
                "id=" + id +
                ", denumire='" + denumire + '\'' +
                ", durata='" + durata + '\'' +
                '}';
    }
}
