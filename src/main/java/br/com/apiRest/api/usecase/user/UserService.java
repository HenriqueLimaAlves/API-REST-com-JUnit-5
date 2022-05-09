package br.com.apiRest.api.usecase.user;

import br.com.apiRest.api.domain.entities.UserEntity;
import br.com.apiRest.api.domain.repositories.UserRepository;
import br.com.apiRest.api.usecase.user.port.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserPort {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity findById(Integer id) {
        Optional<UserEntity> obj = userRepository.findById(id);
        return obj.orElse(null);
    }
}