package mylab.order.di.xml;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mylab-order-di.xml"})
public class OrderSpringTest {

    @Autowired
    private ShoppingCart cart;
    
    @Autowired
    private OrderService service;

    @Test
    public void testShoppingCartConfiguration() {
        // ShoppingCart가 null이 아님을 확인
        assertNotNull(cart);
        
        // products가 null이 아님을 확인
        assertNotNull(cart.getProducts());
        
        // products 리스트 크기가 2인지 확인
        assertEquals(2, cart.getProducts().size());
        
        // 첫 번째 상품이 "노트북"인지 확인
        assertEquals("노트북", cart.getProducts().get(0).getName());
        
        // 두 번째 상품이 "스마트폰"인지 확인
        assertEquals("스마트폰", cart.getProducts().get(1).getName());
    }

    @Test
    public void testOrderServiceConfiguration() {
        // OrderService가 null이 아님을 확인
        assertNotNull(service);
        
        // service의 shoppingCart가 null이 아님을 확인
        assertNotNull(service.getShoppingCart());
        
        // calculateOrderTotal()이 950000.0인지 확인 (delta 허용 범위 사용)
        assertEquals(950000.0, service.calculateOrderTotal(), 0.01);
    }
}