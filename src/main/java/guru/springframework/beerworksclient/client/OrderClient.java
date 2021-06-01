package guru.springframework.beerworksclient.client;

import guru.springframework.beerworksclient.model.*;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface OrderClient {

    ClientResponse createNewCustomer();

    Mono<Customer> getByCustomerId(UUID uuid);

    ClientResponse updateByCustomerId(UUID id);

    Mono<List<CustomerOrder>> listCustomerOrders(UUID id);

    Mono<Order> createOrder(CustomerOrder customerOrder);

    Mono<CustomerOrder> getCustomerOrderById(UUID customerId, UUID id);

    ClientResponse pickupCustomerOrder(UUID customerId, UUID id);
}
