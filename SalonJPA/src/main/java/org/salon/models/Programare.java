package org.salon.models;

import lombok.SneakyThrows;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PROGRAMARI")
public class Programare implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "data_programare")
    private Date dataProgramare;
    @Column(name = "posibilitate_anulare")
    private boolean posibilitateAnulare;
    @OneToOne
    private Incasare incasare;
    @OneToMany
    private List<Serviciu> servicii;

    public Programare() {
    }

    @SneakyThrows
    public Programare(String dataProgramare, boolean posibilitateAnulare) {
        this.dataProgramare = new SimpleDateFormat("dd-MM-yyyy").parse(dataProgramare);
        this.posibilitateAnulare = posibilitateAnulare;
        this.incasare = null;
        servicii = new ArrayList<>();
    }

    @SneakyThrows
    public Programare(String dataProgramare, boolean posibilitateAnulare, Incasare incasare) {
        this.dataProgramare = new SimpleDateFormat("dd-MM-yyyy").parse(dataProgramare);
        this.posibilitateAnulare = posibilitateAnulare;
        this.incasare = incasare;
        servicii = new ArrayList<>();
    }

    @SneakyThrows
    public Programare(String dataProgramare, boolean posibilitateAnulare, Incasare incasare, List<Serviciu> servicii) {
        this.dataProgramare = new SimpleDateFormat("dd-MM-yyyy").parse(dataProgramare);
        this.posibilitateAnulare = posibilitateAnulare;
        this.incasare = incasare;
        this.servicii = servicii;
    }

    public void addServiciu(Serviciu serviciu) {
        if (!servicii.contains(serviciu)) {
            servicii.add(serviciu);
        }
    }

    public void removeServiciu(Serviciu serviciu) {
        servicii.remove(serviciu);
    }

    public List<Serviciu> getServicii() {
        return servicii;
    }

    public void setServicii(List<Serviciu> servicii) {
        this.servicii = servicii;
    }

    public Incasare getIncasare() {
        return incasare;
    }

    public void setIncasare(Incasare incasare) {
        this.incasare = incasare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataProgramare() {
        return dataProgramare;
    }

    @SneakyThrows
    public void setDataProgramare(String dataProgramare) {
        this.dataProgramare = new SimpleDateFormat("dd-MM-yyyy").parse(dataProgramare);
    }

    public void setDataProgramare(Date dataProgramare) {
        this.dataProgramare = dataProgramare;
    }

    public boolean isPosibilitateAnulare() {
        return posibilitateAnulare;
    }

    public void setPosibilitateAnulare(boolean posibilitateAnulare) {
        this.posibilitateAnulare = posibilitateAnulare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Programare that = (Programare) o;
        return getId() == that.getId() && isPosibilitateAnulare() == that.isPosibilitateAnulare() && Objects.equals(getDataProgramare(), that.getDataProgramare());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDataProgramare(), isPosibilitateAnulare());
    }

    @Override
    public String toString() {
        return "Programare{" +
                "id=" + id +
                ", dataProgramare=" + dataProgramare +
                ", posibilitateAnulare=" + posibilitateAnulare +
                ", incasare=" + incasare +
                ", servicii=" + servicii +
                '}';
    }
}
