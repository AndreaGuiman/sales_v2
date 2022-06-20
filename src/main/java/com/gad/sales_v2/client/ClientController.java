package com.gad.sales_v2.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAll() {
        return clientService.findAll();
    }

    @GetMapping("{id}")
    public Client getById(@PathVariable("id") Long id) {
        return clientService.getById(id);
    }

    @PostMapping()
    public Client save(@RequestBody ClientDTO clientDTO) {
        return clientService.saveOrUpdate(clientDTO);
    }

    @GetMapping("names/{searchValue}")
    public List<String> getNamesBySearchValue(@PathVariable("searchValue") String searchValue){
        return clientService.getByNameSearchValue(searchValue);
    }

    @GetMapping("name/{name}")
    public Long getIdByName(@PathVariable("name") String name){
        return clientService.getIdByName(name);
    }

    @GetMapping("exists/{vatOrIdNumber}")
    public Boolean exists(@PathVariable("vatOrIdNumber") String vatOrIdNumber){
        return clientService.existsClientByVatOrIdNumber(vatOrIdNumber);
    }

    @PutMapping
    public Boolean update(@RequestBody ClientDTO clientDTO){
        return clientService.update(clientDTO);
    }
}
