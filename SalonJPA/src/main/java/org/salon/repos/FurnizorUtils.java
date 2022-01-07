package org.salon.repos;

import org.salon.manager.Manager;
import org.salon.models.Furnizor;

import java.util.List;

public class FurnizorUtils {

    public static Furnizor getFurnizorByNume(String nume) {
        try {
            return (Furnizor) Manager.getManagerInstance().createQuery("SELECT a from Furnizor a WHERE a.nume= '" + nume + "'").getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            System.out.println("Nu exista o intrare cu aceste date!");
            return null;
        }
    }

    public static List getAllFurnizori() {
        return Manager.getManagerInstance().createQuery("SELECT a from Furnizor a").getResultList();
    }

    public static void addFurnizor(Furnizor furnizor) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().persist(furnizor);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am adaugat cu succes furnizorul: \n" + furnizor);

    }

    public static Furnizor findFurnizor(int id) {
        return Manager.getManagerInstance().find(Furnizor.class, id);

    }

    public static void updateFurnizor(Furnizor furnizor) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Furnizor furnizorToUpdate = findFurnizor(furnizor.getId());
        furnizorToUpdate.setNume(furnizor.getNume());
        furnizorToUpdate.setAdresaSediu(furnizor.getAdresaSediu());
        furnizorToUpdate.setProduse(furnizor.getProduse());
        furnizorToUpdate.setUstensile(furnizor.getUstensile());
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am actualizat cu succes furnizorul: \n" + furnizor);
    }

    public static void deleteFurnizor(Furnizor furnizor) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().remove(furnizor);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am sters cu succes furnizorul: \n");

    }
}
