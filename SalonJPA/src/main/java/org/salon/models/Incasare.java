package org.salon.models;

import lombok.SneakyThrows;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "INCASARI")
public class Incasare implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int suma;
    @Column(name = "data_incasare")
    private Date dataIncasare;

    public Incasare() {
    }

    @SneakyThrows
    public Incasare(int suma, String dataIncasare) {
        this.suma = suma;
        this.dataIncasare = new SimpleDateFormat("dd-MM-yyyy").parse(dataIncasare);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public Date getDataIncasare() {
        return dataIncasare;
    }

    @SneakyThrows
    public void setDataIncasare(String dataIncasare) {
        this.dataIncasare = new SimpleDateFormat("dd-MM-yyyy").parse(dataIncasare);;
    }
    public void setDataIncasare(Date dataIncasare) {
        this.dataIncasare = dataIncasare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Incasare incasare = (Incasare) o;
        return getId() == incasare.getId() && getSuma() == incasare.getSuma() && Objects.equals(getDataIncasare(), incasare.getDataIncasare());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSuma(), getDataIncasare());
    }

    @Override
    public String toString() {
        return "Incasare{" +
                "id=" + id +
                ", suma=" + suma +
                ", dataIncasare=" + dataIncasare.toString() +
                '}';
    }
}
