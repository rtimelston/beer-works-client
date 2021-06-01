package guru.springframework.beerworksclient.client;

import guru.springframework.beerworksclient.model.Beer;
import guru.springframework.beerworksclient.model.BeerPagedList;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class BeerClientImpl implements BeerClient {
    @Override
    public Mono<Beer> getBeerById(UUID id, Boolean showInventoryOnHand) {
        return null;
    }

    @Override
    public Mono<BeerPagedList> listBeers(Integer pageNumber, Integer pageSize, String beerName,
                                         String beerStyle, Boolean showInventoryOnHand) {
        return null;
    }

    @Override
    public Mono<ClientResponse> createBeer(Beer beer) {
        return null;
    }

    @Override
    public Mono<ClientResponse> updateBeer(Beer beer) {
        return null;
    }

    @Override
    public Mono<ClientResponse> deleteBeerById(UUID id) {
        return null;
    }

    @Override
    public Mono<Beer> getBeerByUPC(String upc) {
        return null;
    }
}
