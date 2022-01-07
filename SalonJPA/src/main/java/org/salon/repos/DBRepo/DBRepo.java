package org.salon.repos.DBRepo;

import org.salon.manager.Manager;

public class DBRepo {
    public static void dropDataBase() {
        Manager.getManagerInstance().getTransaction().begin();
        Manager.getManagerInstance().createNativeQuery("BEGIN; DROP SCHEMA public CASCADE;\n" +
                "CREATE SCHEMA public;\n" +
                "GRANT ALL ON SCHEMA public TO postgres;\n" +
                "GRANT ALL ON SCHEMA public TO public; END; ").executeUpdate();
        Manager.getManagerInstance().getTransaction().commit();
    }
}
