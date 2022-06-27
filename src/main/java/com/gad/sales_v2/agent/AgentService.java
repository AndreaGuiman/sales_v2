package com.gad.sales_v2.agent;

import com.gad.sales_v2.user.User;
import com.gad.sales_v2.user.UserRole;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class AgentService {
    private final AgentRepository agentRepository;

    @Autowired
    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public Agent saveOrUpdate(AgentDTO agentDTO){
        Agent agent = new Agent(
                agentDTO.getFirstName(),
                agentDTO.getLastName(),
                agentDTO.getTelephoneNumber(),
                true,
                new User(
                        agentDTO.getUsername(),
                        agentDTO.getPassword(),
                        UserRole.AGENT.name()
                )
        );
        return agentRepository.save(agent);
    }

    public List<Agent> getAllActive(){
        return agentRepository.getAllByActiveTrue();
    }

    public Iterable<Agent> findAll(){
        return agentRepository.findAll();
    }

    public Agent delete(Agent agent){
        agent.setActive(false);
        return agentRepository.save(agent);
    }

    public AgentDTO getByUserId(Long id){
        return getAgentDTO(agentRepository.getByUserId(id));
    }

    public List<String> getNames() {
        return agentRepository.getNames();
    }

    public Long getByName(String name) {
        return agentRepository.getByName(name);
    }

    private AgentDTO getAgentDTO(String result){
        if(result != null){
            String[] tokens = result.split(",");
            return new AgentDTO(Long.parseLong(tokens[0]), tokens[1]);
        }
        return new AgentDTO();
    }

    public Agent getPhoto(Long id) throws IOException {
        Agent agent = agentRepository.getPhoto(id);
        agent.setPhoto(getPhotoBase64(agent.getPhoto()));
        return agent;
    }

    private String getPhotoBase64(String imagePath) throws IOException {
        String imgBase64 = "data:image/png;base64,";
        File image = new File(imagePath);
        byte[] fileContent = FileUtils.readFileToByteArray(image);
        return imgBase64.concat(Base64.encodeBase64String(fileContent));
    }
}
