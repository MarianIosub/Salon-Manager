package org.salon.SalonJSF;

import org.salon.models.Ustensila;
import org.salon.repos.UstensilaUtils;

import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UstensileForm {
    private Ustensila ustensila;
    List<Ustensila> ustensile = new ArrayList<>();

    public UstensileForm() {
        init();
    }

    private void init() {
        this.ustensile = UstensilaUtils.getAllUstensile();
        ustensile.sort(Comparator.comparingInt(Ustensila::getId));
        this.ustensila = ustensile.get(0);
    }

    public void prevUstensila(ActionEvent e) {
        int pozitieCurenta = this.ustensile.indexOf(ustensila);
        if (pozitieCurenta == 0) {
            this.ustensila = this.ustensile.get(0);
        } else {
            this.ustensila = this.ustensile.get(pozitieCurenta - 1);
        }
    }

    public void addUstensila(ActionEvent e) {
        this.ustensila = new Ustensila();
        this.ustensila.setDenumire("Denumire");
        this.ustensila.setFirma("Firma");
        this.ustensile.add(ustensila);
    }

    public void nextUstensila(ActionEvent e) {
        int pozitieCurenta = this.ustensile.indexOf(ustensila);
        if (pozitieCurenta == ustensile.size() - 1) {
            this.ustensila = this.ustensile.get(ustensile.size() - 1);
        } else {
            this.ustensila = this.ustensile.get(pozitieCurenta + 1);
        }
    }

    public void saveUstensila(ActionEvent e) {
        if (UstensilaUtils.findUstensila(ustensila.getId()) == null) {
            UstensilaUtils.addUstensila(ustensila);
            this.ustensile.add(ustensila);
        } else {
            UstensilaUtils.updateUstensila(ustensila);
        }
        init();
    }

    public void abandonUstensila(ActionEvent e) {
        init();
    }

    public void deleteUstensila(ActionEvent e) {
        if (UstensilaUtils.findUstensila(ustensila.getId()) != null) {
            this.ustensile.remove(this.ustensila);
            UstensilaUtils.deleteUstensila(ustensila);
            init();
        }
        this.ustensila = this.ustensile.get(0);
    }

    public void setIdUstensila(Integer id) {
        if (this.ustensile.stream().filter(c -> c.getId() == id).collect(Collectors.toList()).get(0) != null) {
            this.ustensila = this.ustensile.stream().filter(c -> c.getId() == id).collect(Collectors.toList()).get(0);
        } else {
            this.ustensila = ustensile.get(0);
        }
    }

    public List<Ustensila> getUstensile() {
        return ustensile;
    }

    public Ustensila getUstensila() {
        return ustensila;
    }

    public Integer getIdUstensila() {
        return this.ustensila.getId();
    }

    public void setUstensila(Ustensila ustensila) {
        this.ustensila = ustensila;
    }

    public void setUstensile(List<Ustensila> ustensile) {
        this.ustensile = ustensile;
    }
}
