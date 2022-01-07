package org.salon.SalonJSF;

import org.salon.models.Furnizor;
import org.salon.repos.FurnizorUtils;

import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FurnizoriForm {
    private Furnizor furnizor;
    List<Furnizor> furnizori = new ArrayList<>();

    public FurnizoriForm() {
        init();
    }

    private void init() {
        this.furnizori = new ArrayList<>();
        this.furnizor = new Furnizor();
        this.furnizori = FurnizorUtils.getAllFurnizori();
        furnizori.sort(Comparator.comparingInt(Furnizor::getId));
        this.furnizor = furnizori.get(0);
    }

    public void prevFurnizor(ActionEvent e) {
        int pozitieCurenta = this.furnizori.indexOf(furnizor);
        if (pozitieCurenta == 0) {
            this.furnizor = this.furnizori.get(0);
        } else {
            this.furnizor = this.furnizori.get(pozitieCurenta - 1);
        }
    }

    public void addFurnizor(ActionEvent e) {
        this.furnizor = new Furnizor();
        this.furnizor.setNume("Nume");
        this.furnizor.setAdresaSediu("Sediu");
        this.furnizori.add(furnizor);
    }

    public void nextFurnizor(ActionEvent e) {
        int pozitieCurenta = this.furnizori.indexOf(furnizor);
        if (pozitieCurenta == furnizori.size() - 1) {
            this.furnizor = this.furnizori.get(furnizori.size() - 1);
        } else {
            this.furnizor = this.furnizori.get(pozitieCurenta + 1);
        }
    }

    public void saveFurnizor(ActionEvent e) {
        if (FurnizorUtils.findFurnizor(furnizor.getId()) == null) {
            FurnizorUtils.addFurnizor(furnizor);
            this.furnizori.add(furnizor);
        } else {
            FurnizorUtils.updateFurnizor(furnizor);
        }
        init();
    }

    public void abandonFurnizor(ActionEvent e) {
        System.out.println(furnizori);
        init();
        System.out.println(this.furnizori);
    }

    public void deleteFurnizor(ActionEvent e) {
        if (FurnizorUtils.findFurnizor(furnizor.getId()) != null) {
            this.furnizori.remove(this.furnizor);
            FurnizorUtils.deleteFurnizor(furnizor);
            init();
        }
        this.furnizor = this.furnizori.get(0);
    }

    public void setIdFurnizor(Integer id) {
        if (this.furnizori.stream().filter(c -> c.getId() == id).collect(Collectors.toList()).get(0) != null) {
            this.furnizor = this.furnizori.stream().filter(c -> c.getId() == id).collect(Collectors.toList()).get(0);
        } else {
            this.furnizor = furnizori.get(0);
        }
    }

    public Integer getIdFurnizor() {
        return this.furnizor.getId();
    }

    public List<Furnizor> getFurnizori() {
        return furnizori;
    }

    public Furnizor getFurnizor() {
        return furnizor;
    }

    public void setFurnizor(Furnizor furnizor) {
        this.furnizor = furnizor;
    }

    public void setFurnizori(List<Furnizor> furnizori) {
        this.furnizori = furnizori;
    }
}
