package br.com.apiRest.api.usecase.user.port;

import br.com.apiRest.api.domain.entities.UserEntity;


public interface UserPort {

    UserEntity findById(Integer id);
}
