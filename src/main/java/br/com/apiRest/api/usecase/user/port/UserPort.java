package br.com.apiRest.api.usecase.user.port;

import br.com.apiRest.api.domain.dto.UserDTO;
import br.com.apiRest.api.domain.entities.UserEntity;

import java.util.List;


public interface UserPort {

    UserEntity findById(Integer id);
    List<UserEntity> findAll();
    UserEntity create(UserDTO obj);

}
