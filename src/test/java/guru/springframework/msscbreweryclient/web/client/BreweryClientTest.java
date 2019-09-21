package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer() {
        BeerDto dto = BeerDto.builder().beerName("New Beer").build();
        URI uri = client.saveNewBeer(dto);
        assertNotNull(uri);
        System.out.printf(uri.toString());
    }

    @Test
    void testUpdateBeer() {
        // Given
        BeerDto beerDto = BeerDto.builder().beerName("New beer").build();
        client.updateBeer(UUID.randomUUID(), beerDto);
    }
}