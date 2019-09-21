package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @Test
    void getCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewCustomer() {
        CustomerDto dto = CustomerDto.builder().name("New Customer").build();
        URI uri = client.saveNewCustomer(dto);
        assertNotNull(uri);
        System.out.printf(uri.toString());
    }

    @Test
    void testUpdateCustomer() {
        // Given
        CustomerDto customerDto = CustomerDto.builder().name("New customer").build();
        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomer() {
        // Given
        client.deleteCustomer(UUID.randomUUID());
    }
}