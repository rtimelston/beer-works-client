package guru.springframework.beerworksclient.client;

import guru.springframework.beerworksclient.model.Customer;
import guru.springframework.beerworksclient.model.CustomerOrder;
import guru.springframework.beerworksclient.model.Order;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public class OrderClientImpl implements OrderClient {
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
