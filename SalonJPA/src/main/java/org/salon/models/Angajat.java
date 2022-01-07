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
@Table(name = "ANGAJATI")
public class Angajat extends Client implements Serializable {
    @Column(name = "data_angajare")
    private Date dataAngajare;
    @OneToOne
    private Salariu salariu;
    @OneToMany
    private List<Programare> programariAngajat;

    public Angajat() {

    }

    @SneakyThrows
    public Angajat(String nume, String prenume, String sex, int varsta, int numarTelefon, String dataAngajare) {
        super(nume, prenume, sex, varsta, numarTelefon);
        this.dataAngajare = new SimpleDateFormat("dd-MM-yyyy").parse(dataAngajare);
        programariAngajat = new ArrayList<>();
    }

    @SneakyThrows
    public Angajat(String nume, String prenume, String sex, int varsta, int numarTelefon, String dataAngajare, Salariu salariu) {
        super(nume, prenume, sex, varsta, numarTelefon);
        this.dataAngajare = new SimpleDateFormat("dd-MM-yyyy").parse(dataAngajare);
        this.salariu = salariu;
        programariAngajat = new ArrayList<>();
    }

    @SneakyThrows
    public Angajat(String nume, String prenume, String sex, int varsta, int numarTelefon, String dataAngajare, Salariu salariu, List<Programare> programari) {
        super(nume, prenume, sex, varsta, numarTelefon);
        this.dataAngajare = new SimpleDateFormat("dd-MM-yyyy").parse(dataAngajare);
        this.salariu = salariu;
        this.programariAngajat = programari;
    }

    public void addProgramare(Programare programare) {
        if (!programariAngajat.contains(programare)) {
            programariAngajat.add(programare);
        }
    }

    public void removeProgramare(Programare programare) {
        programariAngajat.remove(programare);
    }

    public List<Programare> getProgramariAngajat() {
        return programariAngajat;
    }

    public void setProgramariAngajat(List<Programare> programari) {
        this.programariAngajat = programari;
    }

    public void setDataAngajare(Date dataAngajare) {
        this.dataAngajare = dataAngajare;
    }

    public Salariu getSalariu() {
        return salariu;
    }

    public void setSalariu(Salariu salariu) {
        this.salariu = salariu;
    }

    public String getDataAngajare() {
        return dataAngajare.toString();
    }

    @SneakyThrows
    public void setDataAngajare(String dataAngajare) {
        this.dataAngajare = new SimpleDateFormat("dd-MM-yyyy").parse(dataAngajare);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Angajat angajat = (Angajat) o;
        return getId() == angajat.getId() && getVarsta() == angajat.getVarsta() && getDataAngajare() == angajat.getDataAngajare() && Objects.equals(getNume(), angajat.getNume()) && Objects.equals(getPrenume(), angajat.getPrenume()) && Objects.equals(getSex(), angajat.getSex());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNume(), getPrenume(), getSex(), getVarsta(), getDataAngajare());
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "id=" + getId() +
                ", nume='" + getNume() + '\'' +
                ", prenume='" + getPrenume() + '\'' +
                ", sex='" + getSex() + '\'' +
                ", varsta=" + getVarsta() +
                ", dataAngajare=" + dataAngajare +
                ", salariu=" + salariu +
                ", programari=" + getProgramariAngajat() +
                '}';
    }
}
