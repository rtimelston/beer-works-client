package guru.springframework.beerworksclient.service;

import guru.springframework.beerworksclient.domain.Customer;
import guru.springframework.beerworksclient.domain.CustomerOrder;
import guru.springframework.beerworksclient.domain.Order;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface BeerWorksService {
    ClientResponse createNewCustomer();

    Mono<Customer> getByCustomerId(UUID uuid);

    ClientResponse updateByCustomerId(UUID id);

    Mono<List<CustomerOrder>> listCustomerOrders(UUID id);

    Mono<Order> createOrder(CustomerOrder customerOrder);

    Mono<CustomerOrder> getCustomerOrderById(UUID customerId, UUID id);

    ClientResponse pickupCustomerOrder(UUID customerId, UUID id);
}
