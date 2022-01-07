package org.salon.models;

import lombok.SneakyThrows;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "SALARII")
public class Salariu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int suma;
    @Column(name = "data_salariu")
    private Date dataSalariu;
    @Column(name = "tip_plata")
    private String tipPlata;

    public Salariu() {
    }

    @SneakyThrows
    public Salariu(int suma, String dataSalariu, String tipPlata) {
        this.suma = suma;
        this.dataSalariu = new SimpleDateFormat("dd-MM-yyyy").parse(dataSalariu);
        this.tipPlata = tipPlata;
    }

    public int getId() {
        return id;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public Date getDataSalariu() {
        return dataSalariu;
    }

    @SneakyThrows
    public void setDataSalariu(String dataSalariu) {
        this.dataSalariu = new SimpleDateFormat("dd-MM-yyyy").parse(dataSalariu);;
    }public void setDataSalariu(Date dataSalariu) {
        this.dataSalariu = dataSalariu;
    }

    public String getTipPlata() {
        return tipPlata;
    }

    public void setTipPlata(String tipPlata) {
        this.tipPlata = tipPlata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salariu salariu = (Salariu) o;
        return getId() == salariu.getId() && getSuma() == salariu.getSuma() && Objects.equals(getDataSalariu(), salariu.getDataSalariu()) && Objects.equals(getTipPlata(), salariu.getTipPlata());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSuma(), getDataSalariu(), getTipPlata());
    }

    @Override
    public String toString() {
        return "Salariu{" +
                "id=" + id +
                ", suma=" + suma +
                ", dataSalariu=" + dataSalariu.toString() +
                ", tipPlata='" + tipPlata + '\'' +
                '}';
    }
}
