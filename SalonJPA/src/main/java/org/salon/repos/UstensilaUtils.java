package org.salon.repos;

import org.salon.manager.Manager;
import org.salon.models.Ustensila;

import java.util.List;

public class UstensilaUtils {

    public static Ustensila getUstensilaByDenumire(String nume) {
        try {
            return (Ustensila) Manager.getManagerInstance().createQuery("SELECT a from Ustensila a WHERE a.denumire= '" + nume + "'").getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            System.out.println("Nu exista o intrare cu aceste date!");
            return null;
        }
    }

    public static List getAllUstensile() {
        return Manager.getManagerInstance().createQuery("SELECT a from Ustensila a").getResultList();
    }

    public static void addUstensila(Ustensila ustensila) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().persist(ustensila);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am adaugat cu succes ustensila: \n" + ustensila);
    }

    public static Ustensila findUstensila(int id) {
        return Manager.getManagerInstance().find(Ustensila.class, id);
    }

    public static void updateUstensila(Ustensila ustensila) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Ustensila ustensilaToUpdate = findUstensila(ustensila.getId());
        ustensilaToUpdate.setDenumire(ustensila.getDenumire());
        ustensilaToUpdate.setFirma(ustensila.getFirma());
        ustensilaToUpdate.setElectric(ustensila.isElectric());
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am actualiat cu succes ustensila: \n" + ustensila);

    }

    public static void deleteUstensila(Ustensila ustensila) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().remove(ustensila);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am sters cu succes ustensila: \n");
    }
}
