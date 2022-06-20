package com.gad.sales_v2.agent;

import com.gad.sales_v2.user.User;

import java.util.List;

import static com.gad.sales_v2.user.UserRole.ADMIN;
import static com.gad.sales_v2.user.UserRole.AGENT;

public class AgentConfig {
    public static void createAndSaveAgents(AgentRepository agentRepository){
        agentRepository.saveAll(List.of(
                new Agent(
                        "Andrei",
                        "Ionescu",
                        "0723564171",
                        true,
                        getImagePath("agentAvatar"),
                        new User(
                                "test",
                                "test",
                                AGENT.name()
                        )
                ),
                new Agent(
                        "Vlad",
                        "Popescu",
                        "0741234123",
                        true,
                        getImagePath("agentAvatar"),
                        new User(
                                "vlad.popescu",
                                "1q2w3e",
                                AGENT.name()
                        )
                ),
                new Agent(
                        "Sorin",
                        "Balan",
                        "0734123451",
                        true,
                        getImagePath("agentAvatar"),
                        new User(
                                "sorin.balan",
                                "parola123",
                                AGENT.name()
                        )
                ),
                new Agent(
                        "Mihai",
                        "Dragomir",
                        "0734123451",
                        true,
                        getImagePath("agentAvatar"),
                        new User(
                                "admin",
                                "admin",
                                ADMIN.name()
                        )
                )
        ));
    }

    private static String getImagePath(String agentPhoto){
        return String.format(
                "C:\\Users\\Andrea\\Desktop\\Licenta\\resources\\agent-photos\\%s.png",
                agentPhoto);
    }
}
