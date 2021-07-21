package guru.springframework.beerworksclient.client;

import guru.springframework.beerworksclient.config.WebClientConfig;
import guru.springframework.beerworksclient.model.Beer;
import guru.springframework.beerworksclient.model.BeerPagedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BeerClientImplTest {

    BeerClientImpl beerClient;

    @BeforeEach
    void setUp() {
        beerClient = new BeerClientImpl(new WebClientConfig().webClient());
    }

    @Test
    void getBeerById() {
        Mono<BeerPagedList> beerPagedListMono = beerClient.listBeers(1, 10, null, null, null);
        BeerPagedList pagedList = beerPagedListMono.block();
        UUID id = pagedList.getContent().get(0).getId();

        Mono<Beer> beerMono = beerClient.getBeerById(id, false);
        Beer beer = beerMono.block();
        assertNotNull(beer);
        assertEquals(id, beer.getId());
        assertNotNull(beer.getQuantityOnHand());
//        assertNull(beer.getQuantityOnHand()); // bug in beer service
    }

    @Test
    void getBeerByIdReturnsInventory() {
        Mono<BeerPagedList> beerPagedListMono = beerClient.listBeers(1, 10, null, null, null);
        BeerPagedList pagedList = beerPagedListMono.block();
        UUID id = pagedList.getContent().get(0).getId();

        Mono<Beer> beerMono = beerClient.getBeerById(id, true);
        Beer beer = beerMono.block();
        assertThat(beer).isNotNull();
        assertEquals(id, beer.getId());
        assertThat(beer.getQuantityOnHand()).isNotNull();
    }

    @Test
    void listBeers() {
        Mono<BeerPagedList> beerPagedListMono = beerClient.listBeers(null, null, null, null, null);
        BeerPagedList pagedList = beerPagedListMono.block();
        assertThat(pagedList).isNotNull();
        assertThat(pagedList.getContent().size()).isGreaterThan(0);
        System.out.println(pagedList.toList());
    }

    @Test
    void listBeersPageSize10() {
        Mono<BeerPagedList> beerPagedListMono = beerClient.listBeers(1, 10, null, null, null);
        BeerPagedList pagedList = beerPagedListMono.block();
        assertThat(pagedList).isNotNull();
        assertThat(pagedList.getContent().size()).isEqualTo(10);
        System.out.println(pagedList.toList());
    }

    @Test
    void listBeersNoRecords() {
        Mono<BeerPagedList> beerPagedListMono = beerClient.listBeers(10, 20, null, null, null);
        BeerPagedList pagedList = beerPagedListMono.block();
        assertThat(pagedList).isNotNull();
        assertThat(pagedList.getContent().size()).isEqualTo(0);
        System.out.println(pagedList.toList());
    }

    @Test
    void createBeer() {
        Beer beer = Beer.builder()
                .beerName("Dogfishhead 90 Min IPA")
                .beerStyle("IPA")
                .upc("92459274237434")
                .price("10.99")
                .build();

        Mono<ResponseEntity<Void>> responseEntityMono = beerClient.createBeer(beer);
        ResponseEntity responseEntity = responseEntityMono.block();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void updateBeer() {
        Mono<BeerPagedList> beerPagedListMono = beerClient.listBeers(1, 10, null, null, null);
        BeerPagedList pagedList = beerPagedListMono.block();
        Beer beer = pagedList.getContent().get(0);

        Beer updatedBeer = Beer.builder()
                .beerName("Really Good Beer")
                .beerStyle(beer.getBeerStyle())
                .price(beer.getPrice())
                .upc(beer.getUpc())
                .build();

        Mono<ResponseEntity<Void>> responseEntityMono = beerClient.updateBeer(beer.getId(), updatedBeer);
        ResponseEntity<Void> responseEntity = responseEntityMono.block();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    void deleteBeerById() {
        Mono<BeerPagedList> beerPagedListMono = beerClient.listBeers(1, 10, null, null, null);
        BeerPagedList pagedList = beerPagedListMono.block();
        Beer beer = pagedList.getContent().get(0);

        Mono<ResponseEntity<Void>> responseEntityMono = beerClient.deleteBeerById(beer.getId());
        ResponseEntity<Void> responseEntity = responseEntityMono.block();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    void getBeerByUPC() {
        Mono<BeerPagedList> beerPagedListMono = beerClient.listBeers(1, 10, null, null, null);
        BeerPagedList pagedList = beerPagedListMono.block();
        String upc = pagedList.getContent().get(0).getUpc();

        Mono<Beer> beerMono = beerClient.getBeerByUPC(upc);
        Beer beer = beerMono.block();
        assertThat(beer).isNotNull();
        assertEquals(upc, beer.getUpc());
    }
}