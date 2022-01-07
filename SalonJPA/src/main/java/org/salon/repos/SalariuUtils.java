package org.salon.repos;

import org.salon.manager.Manager;
import org.salon.models.Client;
import org.salon.models.Salariu;

import java.util.List;

public class SalariuUtils {

    public static List getAllSalarii() {
        return Manager.getManagerInstance().createQuery("SELECT a from Salariu a").getResultList();
    }

    public static void addSalariu(Salariu salariu) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().persist(salariu);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am adaugat cu succes salariul: \n" + salariu);
    }

    public static Salariu findSalariu(int id) {
        return Manager.getManagerInstance().find(Salariu.class, id);
    }

    public static void updateSalariu(Salariu salariu) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Salariu salariuToUpdate = findSalariu(salariu.getId());
        salariuToUpdate.setDataSalariu(salariu.getDataSalariu());
        salariuToUpdate.setSuma(salariu.getSuma());
        salariuToUpdate.setTipPlata(salariu.getTipPlata());
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am actualiat cu succes salariul: \n" + salariu);

    }

    public static void deleteClient(Client client) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().remove(client);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am sters cu succes clientul: \n");
    }
}
