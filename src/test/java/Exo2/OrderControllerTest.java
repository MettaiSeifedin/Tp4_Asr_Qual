package Exo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

    // Création des mocks pour OrderService et OrderDao
    @Mock
    private OrderService mockOrderService;

    @Mock
    private OrderDao mockOrderDao;

    // Injecter les mocks dans OrderController
    @InjectMocks
    private OrderController orderController;

    @Test
    public void testCreateOrder() {
        // Création d'un objet Order pour le test
        Order testOrder = new Order(1, "John Doe", 100.0);

        // Appel de la méthode createOrder de OrderController avec l'objet Order de test
        orderController.createOrder(testOrder);

        // Vérification que OrderService.createOrder est appelé avec le bon argument
        verify(mockOrderService).createOrder(testOrder);

        // Vérification que OrderDao.saveOrder est appelé avec l'objet de commande créé
        verify(mockOrderDao).saveOrder(testOrder);
    }
}
