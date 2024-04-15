package Exo1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    UserRepository mockRepository ;
    @Test
    public void testGetUserById() {

        // Création d'un utilisateur de test
        User testUser = new User();
        testUser.setId(1);
        testUser.setName("Met");

        // Définition du comportement du mock pour la méthode findUserById
        when(mockRepository.findUserById(1)).thenReturn(testUser);

        // Création de l'instance de UserService avec le mock
        UserService userService = new UserService(mockRepository);

        // Appel de la méthode getUserById avec l'ID de l'utilisateur de test
        User result = userService.getUserById(1);

        // Vérification que le résultat correspond à l'utilisateur de test
        assertEquals(testUser, result);
        verify(mockRepository).findUserById(testUser.getId());
    }
}
