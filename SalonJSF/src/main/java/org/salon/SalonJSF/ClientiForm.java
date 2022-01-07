package org.salon.SalonJSF;

import org.salon.models.Client;
import org.salon.repos.ClientUtils;

import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ClientiForm {
    private Client client;
    List<Client> clienti = new ArrayList<>();

    public ClientiForm() {
        init();
    }

    private void init() {
        this.clienti = ClientUtils.getAllClienti();
        clienti.sort(Comparator.comparingInt(Client::getId));
        this.client = clienti.get(0);
    }

    public void prevClient(ActionEvent e) {
        int pozitieCurenta = this.clienti.indexOf(client);
        if (pozitieCurenta == 0) {
            this.client = this.clienti.get(0);
        } else {
            this.client = this.clienti.get(pozitieCurenta - 1);
        }
    }

    public void addClient(ActionEvent e) {
        this.client = new Client();
        this.client.setNume("Nume");
        this.client.setPrenume("Prenume");
        this.clienti.add(client);
    }

    public void nextClient(ActionEvent e) {
        int pozitieCurenta = this.clienti.indexOf(client);
        if (pozitieCurenta == clienti.size() - 1) {
            this.client = this.clienti.get(clienti.size() - 1);
        } else {
            this.client = this.clienti.get(pozitieCurenta + 1);
        }
    }

    public void saveClient(ActionEvent e) {
        if (ClientUtils.findClient(client.getId()) == null) {
            ClientUtils.addClient(client);
            this.clienti.add(client);
        } else {
            ClientUtils.updateClient(client);
        }
        init();
    }

    public void abandonClient(ActionEvent e) {
        init();
    }

    public void deleteClient(ActionEvent e) {
        if (ClientUtils.findClient(client.getId()) != null) {
            this.clienti.remove(this.client);
            ClientUtils.deleteClient(client);
            init();
        }
        this.client = this.clienti.get(0);
    }

    public void setIdClient(Integer id) {
        if (this.clienti.stream().filter(c -> c.getId() == id).collect(Collectors.toList()).get(0) != null) {
            this.client = this.clienti.stream().filter(c -> c.getId() == id).collect(Collectors.toList()).get(0);
        } else {
            this.client = clienti.get(0);
        }
    }

    public List<Client> getClienti() {
        return clienti;
    }

    public Client getClient() {
        return client;
    }

    public Integer getIdClient() {
        return this.client.getId();
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setClienti(List<Client> clienti) {
        this.clienti = clienti;
    }
}
