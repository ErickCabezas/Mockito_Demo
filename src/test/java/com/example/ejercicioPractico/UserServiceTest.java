package com.example.ejercicioPractico;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindUserById() {

        // Crear el mock
        User user = new User("1", "John");

        // Definir el comportamiento del mock
        when(userRepository.findUserById("1")).thenReturn(user);

        // Llamar al método a probar
        User result = userService.getUserById("1");

        // Verificar el resultado
        assertNotNull(result);
        assertEquals("John", result.getName());

        // Verificar que el metodo findUserBy fue llamado exactamente una vez con el parámetro "1"
        verify(userRepository, times(1)).findUserById("1");
    }
}
