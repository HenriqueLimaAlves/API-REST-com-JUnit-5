package br.com.apiRest.api.usecase.user;

import br.com.apiRest.api.domain.dto.UserDTO;
import br.com.apiRest.api.domain.entities.UserEntity;
import br.com.apiRest.api.domain.repositories.UserRepository;
import br.com.apiRest.api.usecase.exceptions.ObjectNotFoundException;
import br.com.apiRest.api.usecase.user.port.UserPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserPort {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserEntity findById(Integer id) {
        Optional<UserEntity> obj = userRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    @Override
    public UserEntity create(UserDTO obj) {
        return userRepository.save(modelMapper.map(obj, UserEntity.class));
    }
}
