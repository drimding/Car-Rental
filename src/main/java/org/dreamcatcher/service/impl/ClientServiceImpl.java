package org.dreamcatcher.service.impl;

import org.dreamcatcher.dao.ClientDao;
import org.dreamcatcher.entity.Client;
import org.dreamcatcher.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by drimcatcher on 09.06.2016.
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientDao clientDao;
    public List<Client> getAllClients() {

        return clientDao.findAll();
    }

    public void setNewClient(String clientName, String clientAddress) {
        if (!clientName.isEmpty())
        {
            clientDao.saveAndFlush(new Client(clientName,clientAddress));
        }
    }
}
