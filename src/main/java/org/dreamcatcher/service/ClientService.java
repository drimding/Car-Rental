package org.dreamcatcher.service;

import org.dreamcatcher.entity.Client;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by drimcatcher on 09.06.2016.
 */

public interface ClientService {
     List<Client> getAllClients();

    void setNewClient(String clientName, String clientAddress);
}
