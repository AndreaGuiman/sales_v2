package com.gad.sales_v2.agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("agents")
public class AgentController {
    private final AgentService agentService;

    @Autowired
    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping
    public Iterable<Agent> findAll(){
        return agentService.findAll();
    }

    @GetMapping("active")
    public List<Agent> getAllActive(){
        return agentService.getAllActive();
    }

    @GetMapping("names")
    public List<String> getNames(){
        return agentService.getNames();
    }

    @GetMapping("user-id/{id}")
    public AgentDTO getByUserId(@PathVariable("id") Long id){
        return agentService.getByUserId(id);
    }

    @GetMapping("name/{name}")
    public Long getNames(@PathVariable("name") String name){
        return agentService.getByName(name);
    }

    @GetMapping("photo/{id}")
    public Agent getPhoto(@PathVariable("id") Long id) throws IOException {
        return agentService.getPhoto(id);
    }

    @PostMapping
    public Agent save(@RequestBody AgentDTO agentDTO){
        return agentService.saveOrUpdate(agentDTO);
    }

    @PutMapping
    public Agent update(@RequestBody AgentDTO agentDTO){
        return agentService.saveOrUpdate(agentDTO);
    }

    @DeleteMapping
    public Agent delete(@RequestBody Agent agent){
        return agentService.delete(agent);
    }
}


