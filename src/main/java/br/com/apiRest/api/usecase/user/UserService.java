package br.com.apiRest.api.usecase.user;

import br.com.apiRest.api.domain.dto.UserDTO;
import br.com.apiRest.api.domain.entities.UserEntity;
import br.com.apiRest.api.domain.repositories.UserRepository;
import br.com.apiRest.api.usecase.exceptions.DataIntegratyViolationException;
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
        findByEmail(obj);
        return userRepository.save(modelMapper.map(obj, UserEntity.class));
    }

    @Override
    public UserEntity update(UserDTO obj) {
        findByEmail(obj);
        return userRepository.save(modelMapper.map(obj, UserEntity.class));
    }

    private void findByEmail(UserDTO obj){
        Optional<UserEntity> userEntity = userRepository.findByEmail(obj.getEmail());
        if(userEntity.isPresent() && !userEntity.get().getId().equals(obj.getId())){
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    }
}
