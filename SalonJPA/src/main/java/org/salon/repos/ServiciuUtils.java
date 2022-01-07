package org.salon.repos;

import org.salon.manager.Manager;
import org.salon.models.Serviciu;

import java.util.List;

public class ServiciuUtils {

    public static Serviciu getServiciuByDenumire(String nume) {
        try {
            return (Serviciu) Manager.getManagerInstance().createQuery("SELECT a from Serviciu a WHERE a.denumire= '" + nume + "'").getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            System.out.println("Nu exista o intrare cu aceste date!");
            return null;
        }
    }

    public static List getAllServicii() {
        return Manager.getManagerInstance().createQuery("SELECT a from Serviciu a").getResultList();
    }

    public static void addServiciu(Serviciu serviciu) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().persist(serviciu);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am adaugat cu succes serviciul: \n" + serviciu);
    }

    public static Serviciu findServiciu(int id) {
        return Manager.getManagerInstance().find(Serviciu.class, id);
    }

    public static void updateServiciu(Serviciu serviciu) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Serviciu serviciuToUpdate = findServiciu(serviciu.getId());
        serviciuToUpdate.setDenumire(serviciu.getDenumire());
        serviciuToUpdate.setDurata(serviciu.getDurata());
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am actualiat cu succes servicul: \n" + serviciu);

    }

    public static void deleteServiciu(Serviciu serviciu) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().remove(serviciu);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am sters cu succes serviciul: \n");
    }
}
