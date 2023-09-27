package com.ntp.myadmin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntp.myadmin.models.Client;
import com.ntp.myadmin.repositories.ClientRepository;



@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public void save(Client client){
        clientRepository.save(client);
    }

    public Optional<Client> findById(Integer id){
        return clientRepository.findById(id);
    }

    public void delete(Integer id){
        clientRepository.deleteById(id);
    }
}
