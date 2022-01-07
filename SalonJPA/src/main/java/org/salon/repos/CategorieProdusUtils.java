package org.salon.repos;

import org.salon.manager.Manager;
import org.salon.models.CategorieProdus;

import java.util.List;

public class CategorieProdusUtils {

    public static CategorieProdus getCategorieByDenumire(String nume) {
        try {
            return (CategorieProdus) Manager.getManagerInstance().createQuery("SELECT a from CategorieProdus a WHERE a.denumire= '" + nume + "'").getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            System.out.println("Nu exista o intrare cu aceste date!");
            return null;
        }
    }

    public static List getAllCategoriiProdus() {
        return Manager.getManagerInstance().createQuery("SELECT a from CategorieProdus a").getResultList();
    }

    public static void addCategorieProdus(CategorieProdus categorieProdus) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().persist(categorieProdus);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am adaugat cu succes categoria: \n" + categorieProdus);

    }

    public static CategorieProdus findCategorieProdus(int id) {
        return Manager.getManagerInstance().find(CategorieProdus.class, id);

    }

    public static void updateCategorieProdus(CategorieProdus categorieProdus) {
        Manager.getManagerInstance().getTransaction().begin();
        CategorieProdus categorieProdusToUpdate = findCategorieProdus(categorieProdus.getId());
        categorieProdusToUpdate.setDenumire(categorieProdus.getDenumire());
        categorieProdusToUpdate.setProduse(categorieProdus.getProduse());
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am actualizat cu succes categoria: \n" + categorieProdus);
    }

    public static void deleteCategorieProdus(CategorieProdus categorieProdus) {
        Manager.getManagerInstance().getTransaction().begin();
        Manager.getManagerInstance().remove(categorieProdus);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am sters cu succes categoria: \n");
    }
}
