package org.salon.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "USTENSILE")
public class Ustensila implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String denumire;
    private String firma;
    private boolean electric;

    public Ustensila() {
    }

    public Ustensila(String denumire, String firma, boolean electric) {
        this.denumire = denumire;
        this.firma = firma;
        this.electric = electric;
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

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ustensila ustensila = (Ustensila) o;
        return getId() == ustensila.getId() && isElectric() == ustensila.isElectric() && Objects.equals(getDenumire(), ustensila.getDenumire()) && Objects.equals(getFirma(), ustensila.getFirma());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDenumire(), getFirma(), isElectric());
    }

    @Override
    public String toString() {
        return "Ustensila{" +
                "id=" + id +
                ", denumire='" + denumire + '\'' +
                ", firma='" + firma + '\'' +
                ", electric=" + electric +
                '}';
    }
}
