package org.salon.repos;

import org.salon.manager.Manager;
import org.salon.models.Angajat;
import org.salon.models.Client;

import java.util.List;
import java.util.stream.Collectors;

public class ClientUtils {

    public static Client getClientByName(String nume, String prenume) {
        try {
            return (Client) Manager.getManagerInstance().createQuery("SELECT a from Client a WHERE a.nume= '" + nume + "' AND a.prenume='" + prenume + "'").getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            System.out.println("Nu exista o intrare cu aceste date!");
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Client> getAllClienti() {
        return (List<Client>) Manager.getManagerInstance().createQuery("Select a from Client a").getResultList().stream()
                .filter(a -> !(a instanceof Angajat)).collect(Collectors.toList());
    }

    public static void addClient(Client client) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().persist(client);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am adaugat cu succes clientul: \n" + client);
    }

    public static Client findClient(int id) {
        return Manager.getManagerInstance().find(Client.class, id);
    }

    /**
     * Metoda extrage clientul cu id-ul dat, apoi il modifica cu modificarile date prin parametru,
     * si apoi ii face merge inapoi in BD.
     *
     * @param client clientul pe care dorim sa il actualizam
     */
    public static void updateClient(Client client) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Client clientToUpdate = findClient(client.getId());
        clientToUpdate.setNume(client.getNume());
        clientToUpdate.setPrenume(client.getPrenume());
        clientToUpdate.setNumarTelefon(client.getNumarTelefon());
        clientToUpdate.setSex(client.getSex());
        clientToUpdate.setVarsta(client.getVarsta());
        clientToUpdate.setProgramari(client.getProgramari());
        Manager.getManagerInstance().merge(clientToUpdate);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am actualiat cu succes clientul: \n" + clientToUpdate);

    }

    public static void deleteClient(Client client) {
        if (!Manager.getManagerInstance().getTransaction().isActive()) {
            Manager.getManagerInstance().getTransaction().begin();
        }
        Manager.getManagerInstance().remove(client);
        Manager.getManagerInstance().getTransaction().commit();
        Manager.getManagerInstance().close();
        System.out.println("Am sters cu succes clientul \n");
    }

}
