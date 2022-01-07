package org.salon.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLIENTI")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nume;
    private String prenume;
    private String sex;
    private int varsta;
    @Column(name = "numar_telefon")
    private int numarTelefon;
    @OneToMany
    private List<Programare> programari;

    public Client() {
    }

    public Client(String nume, String prenume, String sex, int varsta, int numarTelefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.sex = sex;
        this.varsta = varsta;
        this.numarTelefon = numarTelefon;
        programari = new ArrayList<>();
    }

    public Client(String nume, String prenume, String sex, int varsta, int numarTelefon, List<Programare> programari) {
        this.nume = nume;
        this.prenume = prenume;
        this.sex = sex;
        this.varsta = varsta;
        this.numarTelefon = numarTelefon;
        this.programari = programari;
    }

    public void addProgramare(Programare programare) {
        if (!programari.contains(programare)) {
            programari.add(programare);
        }
    }

    public void removeProgramare(Programare programare) {
        programari.remove(programare);
    }

    public List<Programare> getProgramari() {
        return programari;
    }

    public void setProgramari(List<Programare> programari) {
        this.programari = programari;
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

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public int getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(int numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return getId() == client.getId() && getVarsta() == client.getVarsta() && getNumarTelefon() == client.getNumarTelefon()
                && getNume().equals(client.getNume()) && getPrenume().equals(client.getPrenume()) &&
                Objects.equals(getSex(), client.getSex());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNume(), getPrenume(), getSex(), getVarsta(), getNumarTelefon());
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", sex='" + sex + '\'' +
                ", varsta=" + varsta +
                ", numarTelefon=" + numarTelefon +
                ", programari=" + programari +
                '}';
    }
}
