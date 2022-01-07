package org.salon.repos;

import org.salon.manager.Manager;
import org.salon.models.Incasare;

import java.util.List;

public class IncasareUtils {

    public static List getAllIncasari() {
        return Manager.getManagerInstance().createQuery("SELECT a from Incasare a").getResultList();
    }

    public static void addIncasare(Incasare incasare) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().persist(incasare);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am adaugat cu succes incasarea: \n" + incasare);
    }

    public static Incasare findIncasare(int id) {
        return Manager.getManagerInstance().find(Incasare.class, id);
    }

    public static void updateIncasare(Incasare incasare) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Incasare incasareToUpdate = findIncasare(incasare.getId());
        incasareToUpdate.setSuma(incasare.getSuma());
        incasareToUpdate.setDataIncasare(incasare.getDataIncasare());
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am actualiat cu succes incasarea: \n" + incasare);

    }

    public static void deleteIncasare(Incasare incasare) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().remove(incasare);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am sters cu succes incasarea: \n");
    }
}
