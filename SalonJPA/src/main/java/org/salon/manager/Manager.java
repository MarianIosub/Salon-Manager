package org.salon.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
    private final EntityManagerFactory factory;
    private final EntityManager manager;
    private static Manager managerInstance = null;

    private Manager() {
        this.factory = Persistence.createEntityManagerFactory("SalonJPA");
        this.manager = factory.createEntityManager();
    }

    public static EntityManager getManagerInstance() {

        if (managerInstance == null || !managerInstance.getManager().isOpen()) {
            managerInstance = new Manager();
        }

        return managerInstance.getManager();
    }

    public EntityManager getManager() {
        return manager;
    }

    public static void closeManager() {
        managerInstance = null;
    }
}
