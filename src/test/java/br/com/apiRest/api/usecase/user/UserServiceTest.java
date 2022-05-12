package br.com.apiRest.api.usecase.user;

import br.com.apiRest.api.domain.dto.UserDTO;
import br.com.apiRest.api.domain.entities.UserEntity;
import br.com.apiRest.api.domain.repositories.UserRepository;
import br.com.apiRest.api.usecase.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {

    public static final Integer ID   = 1;
    public static final String NAME  = "valdir";
    public static final String EMAIL = "valdir@mail.com";
    public static final String SENHA = "123";
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private ModelMapper modelMapper;

    private UserEntity userEntity;
    private UserDTO userDTO;
    private Optional<UserEntity> userEntityOptional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThanReturnAnUserInstance() {
        when(userRepository.findById(anyInt())).thenReturn(userEntityOptional);

        UserEntity response = userService.findById(ID);

        assertNotNull(response);
        assertEquals(UserEntity.class, response.getClass());
        assertEquals(ID,response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void whenFindByIdThanReturnAnObjectNotFoundException(){
        when(userRepository.findById(anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado"));

        try{
            userService.findById(ID);
        }catch (Exception ex){
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals("Objeto não encontrado", ex.getMessage());
        }
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser(){
        userEntity = new UserEntity(ID, NAME, EMAIL, SENHA);
        userDTO = new UserDTO(ID, NAME, EMAIL, SENHA);
        userEntityOptional = Optional.of(new UserEntity(ID, NAME, EMAIL, SENHA));
    }
}
