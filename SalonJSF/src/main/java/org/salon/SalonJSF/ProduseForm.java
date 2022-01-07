package org.salon.SalonJSF;

import org.salon.models.Produs;
import org.salon.repos.ProdusUtils;

import javax.faces.event.ActionEvent;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProduseForm {
    private Produs produs;
    List<Produs> produse;

    public ProduseForm() {
        init();
    }

    private void init() {
        this.produse = ProdusUtils.getAllProduse();
        produse.sort(Comparator.comparingInt(Produs::getId));
        this.produs = produse.get(0);
    }

    public void prevProdus(ActionEvent e) {
        int pozitieCurenta = this.produse.indexOf(produs);
        if (pozitieCurenta == 0) {
            this.produs = this.produse.get(0);
        } else {
            this.produs = this.produse.get(pozitieCurenta - 1);
        }
    }

    public void addProdus(ActionEvent e) {
        this.produs = new Produs();
        this.produs.setDenumire("Denumire");
        this.produs.setFirma("Firma");
        this.produs.setStoc(0);
        this.produse.add(produs);
    }

    public void nextProdus(ActionEvent e) {
        int pozitieCurenta = this.produse.indexOf(produs);
        if (pozitieCurenta == produse.size() - 1) {
            this.produs = this.produse.get(produse.size() - 1);
        } else {
            this.produs = this.produse.get(pozitieCurenta + 1);
        }
    }

    public void saveProdus(ActionEvent e) {
        if (ProdusUtils.findProdus(produs.getId()) == null) {
            ProdusUtils.addProdus(produs);
            this.produse.add(produs);
        } else {
            ProdusUtils.updateProdus(produs);
        }
        init();
    }

    public void abandonProdus(ActionEvent e) {
        init();
    }

    public void deleteProdus(ActionEvent e) {
        if (ProdusUtils.findProdus(produs.getId()) != null) {
            this.produse.remove(this.produs);
            ProdusUtils.deleteProdus(produs);
            init();
        }
        this.produs = this.produse.get(0);
    }

    public void setIdProdus(Integer id) {
        if (this.produse.stream().filter(c -> c.getId() == id).collect(Collectors.toList()).get(0) != null) {
            this.produs = this.produse.stream().filter(c -> c.getId() == id).collect(Collectors.toList()).get(0);
        } else {
            this.produs = produse.get(0);
        }
    }

    public Integer getIdProdus() {
        return this.produs.getId();
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public Produs getProdus() {
        return produs;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
    }

    public void setProduse(List<Produs> produse) {
        this.produse = produse;
    }
}
