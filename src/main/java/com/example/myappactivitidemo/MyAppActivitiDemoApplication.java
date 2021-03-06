package com.example.myappactivitidemo;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MyAppActivitiDemoApplication {

    @Bean
    CommandLineRunner init(final RepositoryService repositoryService,
                           final RuntimeService runtimeService,
                           final TaskService taskService) {
        System.out.println("CommandLineRunner");
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Map<String, Object> variables = new HashMap<String, Object>();
                variables.put("applicantName", "John Doe");
                variables.put("email", "john.doe@activiti.com");
                variables.put("phoneNumber", "123456789");
                runtimeService.startProcessInstanceByKey("hireProcess", variables);
            }
        };

    }

    public static void main(String[] args) {
        SpringApplication.run(MyAppActivitiDemoApplication.class, args);
    }

}
