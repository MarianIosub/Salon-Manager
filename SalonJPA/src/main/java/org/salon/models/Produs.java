package org.salon.models;

import lombok.SneakyThrows;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "PRODUSE")
public class Produs implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String denumire;
    private String firma;
    private int stoc;
    @Column(name = "data_expirare")
    private Date dataExpirare;

    public Produs() {
    }

    @SneakyThrows
    public Produs(String denumire, String firma, int stoc, String dataExpirare) {
        this.denumire = denumire;
        this.firma = firma;
        this.stoc = stoc;
        this.dataExpirare = new SimpleDateFormat("dd-MM-yyyy").parse(dataExpirare);
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

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public Date getDataExpirare() {
        return dataExpirare;
    }

    public String getDataExpirareString(){return dataExpirare.toString();}

    public void setDataExpirare(Date dataExpirare) {
        this.dataExpirare = dataExpirare;
    }

    @SneakyThrows
    public void setDataExpirare(String dataExpirare) {
        this.dataExpirare = new SimpleDateFormat("dd-MM-yyyy").parse(dataExpirare);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produs produs = (Produs) o;
        return getId() == produs.getId() && getStoc() == produs.getStoc() && Objects.equals(getDenumire(), produs.getDenumire()) && Objects.equals(getFirma(), produs.getFirma()) && Objects.equals(getDataExpirare(), produs.getDataExpirare());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDenumire(), getFirma(), getStoc(), getDataExpirare());
    }

    @Override
    public String toString() {
        return "Produs{" +
                "id=" + id +
                ", denumire='" + denumire + '\'' +
                ", firma='" + firma + '\'' +
                ", stoc=" + stoc +
                ", dataExpirare=" + dataExpirare.toString() +
                '}';
    }
}
