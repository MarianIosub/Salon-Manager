package org.salon.repos;

import org.salon.manager.Manager;
import org.salon.models.Programare;

import java.util.List;

public class ProgramareUtils {

    public static List getAllProgramari() {
        return Manager.getManagerInstance().createQuery("SELECT a from Programare a").getResultList();
    }

    public static void addProgramare(Programare programare) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().persist(programare);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am adaugat cu succes programarea: \n" + programare);
    }

    public static Programare findProgramare(int id) {
        return Manager.getManagerInstance().find(Programare.class, id);
    }

    public static void updateProgramare(Programare programare) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Programare programareToUpdate = findProgramare(programare.getId());
        programareToUpdate.setDataProgramare(programare.getDataProgramare());
        programareToUpdate.setPosibilitateAnulare(programare.isPosibilitateAnulare());
        programareToUpdate.setIncasare(programare.getIncasare());
        programareToUpdate.setServicii(programare.getServicii());
        Manager.getManagerInstance().merge(programareToUpdate);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am actualizat cu succes programarea: \n" + programare);

    }

    public static void deleteProgramare(Programare programare) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().remove(programare);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am sters cu succes programarea: \n");
    }
}
