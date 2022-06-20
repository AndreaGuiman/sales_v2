package com.gad.sales_v2.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll(){
        return (List<Client>) clientRepository.findAll();
    }

    public Client saveOrUpdate(ClientDTO clientDTO){
        if(!existsClientByVatOrIdNumber(clientDTO.getVatOrIdNumber())) {
            return clientRepository.save(new Client(
                    clientDTO.getName(),
                    clientDTO.getVatOrIdNumber(),
                    clientDTO.getBankName(),
                    clientDTO.getBankAccount(),
                    clientDTO.getEmail(),
                    clientDTO.getTelephoneNumber(),
                    true,
                    clientDTO.getAddress()
            ));
        }
        Client client = clientRepository.foundByVat(clientDTO.getVatOrIdNumber());
        client.setName(clientDTO.getName());
        client.setAddress(clientDTO.getAddress());
        client.setBankAccount(clientDTO.getBankAccount());
        client.setBankName(clientDTO.getBankName());
        client.setTelephoneNumber(clientDTO.getTelephoneNumber());
        client.setEmail(clientDTO.getEmail());
        return clientRepository.save(client);
    }

    public Boolean update(ClientDTO clientDTO){
        return saveOrUpdate(clientDTO).getId() > 0;
    }

    public Iterable<Client> saveOrUpdateAll(List<Client> clients){
        return clientRepository.saveAll(clients);
    }

    public Client getById(Long id){
        return clientRepository.getById(id);
    }

    public List<String> getByNameSearchValue(String searchValue) {
        return clientRepository.getByNameSearchValue(searchValue);
    }

    public Long getIdByName(String name) {
        return clientRepository.getIdByName(name);
    }

    public Boolean existsClientByVatOrIdNumber(String vatOrIdNumber){
        return clientRepository.existsClientByVatOrIdNumber(vatOrIdNumber);
    }
}

