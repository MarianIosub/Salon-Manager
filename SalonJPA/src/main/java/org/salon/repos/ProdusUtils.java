package org.salon.repos;

import org.salon.manager.Manager;
import org.salon.models.Produs;

import java.util.List;

public class ProdusUtils {

    public static Produs getProdusByDenumire(String nume) {
        try {
            return (Produs) Manager.getManagerInstance().createQuery("SELECT a from Produs a WHERE a.denumire= '" + nume + "'").getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            System.out.println("Nu exista o intrare cu aceste date!");
            return null;
        }
    }

    public static List getAllProduse() {
        return Manager.getManagerInstance().createQuery("SELECT a from Produs a").getResultList();
    }

    public static void addProdus(Produs produs) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().persist(produs);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am adaugat cu succes produsul: \n" + produs);
    }

    public static Produs findProdus(int id) {
        return Manager.getManagerInstance().find(Produs.class, id);
    }

    public static void updateProdus(Produs produs) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Produs produsToUpdate = findProdus(produs.getId());
        produsToUpdate.setDenumire(produs.getDenumire());
        produsToUpdate.setFirma(produs.getFirma());
        produsToUpdate.setDataExpirare(produs.getDataExpirare());
        produsToUpdate.setStoc(produs.getStoc());
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am actualiat cu succes produsul: \n" + produs);

    }

    public static void deleteProdus(Produs produs) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().remove(produs);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am sters cu succes produs: \n");
    }
}
