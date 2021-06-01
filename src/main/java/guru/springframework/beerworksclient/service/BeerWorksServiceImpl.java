package guru.springframework.beerworksclient.service;

import guru.springframework.beerworksclient.domain.Customer;
import guru.springframework.beerworksclient.domain.CustomerOrder;
import guru.springframework.beerworksclient.domain.Order;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public class BeerWorksServiceImpl implements BeerWorksService {
    @Override
    public ClientResponse createNewCustomer() {
        return null;
    }

    @Override
    public Mono<Customer> getByCustomerId(UUID uuid) {
        return null;
    }

    @Override
    public ClientResponse updateByCustomerId(UUID id) {
        return null;
    }

    @Override
    public Mono<List<CustomerOrder>> listCustomerOrders(UUID id) {
        return null;
    }

    @Override
    public Mono<Order> createOrder(CustomerOrder customerOrder) {
        return null;
    }

    @Override
    public Mono<CustomerOrder> getCustomerOrderById(UUID customerId, UUID id) {
        return null;
    }

    @Override
    public ClientResponse pickupCustomerOrder(UUID customerId, UUID id) {
        return null;
    }
}
