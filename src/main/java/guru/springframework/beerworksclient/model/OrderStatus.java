package guru.springframework.beerworksclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatus {
    private UUID orderId;
    private String customerRef;
    private String orderStatus;
}
