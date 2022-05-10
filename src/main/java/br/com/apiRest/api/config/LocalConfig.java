package br.com.apiRest.api.config;

import br.com.apiRest.api.domain.entities.UserEntity;
import br.com.apiRest.api.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDB(){
        UserEntity usuario1 = new UserEntity(null, "Valdir","valdir@mail.com", "123");
        UserEntity usuario2 = new UserEntity(null, "luiz","luiz@mail.com", "123");

        repository.saveAll(List.of(usuario1,usuario2));
    }
}
