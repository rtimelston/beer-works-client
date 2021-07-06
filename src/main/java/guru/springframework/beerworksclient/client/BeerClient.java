package guru.springframework.beerworksclient.client;

import guru.springframework.beerworksclient.model.Beer;
import guru.springframework.beerworksclient.model.BeerPagedList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface BeerClient {
    Mono<Beer> getBeerById(UUID id, Boolean showInventoryOnHand);

    Mono<BeerPagedList> listBeers(Integer pageNumber, Integer pageSize, String beerName,
                                  String beerStyle, Boolean showInventoryOnHand);

    Mono<ResponseEntity<Void>> createBeer(Beer beer);

    Mono<ClientResponse> updateBeer(Beer beer);

    Mono<ClientResponse> deleteBeerById(UUID id);

    Mono<Beer> getBeerByUPC(String upc);
}
