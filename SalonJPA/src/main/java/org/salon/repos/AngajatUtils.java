package org.salon.repos;

import org.salon.manager.Manager;
import org.salon.models.Angajat;

import java.util.List;

public class AngajatUtils {

    public static Angajat getAngajatByName(String nume, String prenume) {
        try {
            return (Angajat) Manager.getManagerInstance().createQuery("SELECT a from Angajat a WHERE a.nume= '" + nume + "' AND a.prenume='" + prenume + "'").getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            System.out.println("Nu exista o intrare cu aceste date!");
            return null;
        }
    }

    public static List getAllAngajati() {
        return Manager.getManagerInstance().createQuery("SELECT a from Angajat a").getResultList();
    }

    public static void addAngajat(Angajat angajat) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().persist(angajat);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am adaugat cu succes angajatul: \n" + angajat);

    }

    public static Angajat findAngajat(int id) {
        return Manager.getManagerInstance().find(Angajat.class, id);
    }

    public static void updateAngajat(Angajat angajat) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Angajat angajatToUpdate = findAngajat(angajat.getId());
        angajatToUpdate.setNume(angajat.getNume());
        angajatToUpdate.setPrenume(angajat.getPrenume());
        angajatToUpdate.setSex(angajat.getSex());
        angajatToUpdate.setVarsta(angajat.getVarsta());
        angajatToUpdate.setDataAngajare(angajat.getDataAngajare());
        angajatToUpdate.setNumarTelefon(angajat.getNumarTelefon());
        angajatToUpdate.setSalariu(angajat.getSalariu());
        angajatToUpdate.setProgramariAngajat(angajatToUpdate.getProgramariAngajat());
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am actualizat cu succes angajatul: \n" + angajat);
    }

    public static void deleteAngajat(Angajat angajat) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().remove(angajat);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am sters cu succes angajatul: \n");
    }
}
