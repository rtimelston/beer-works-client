package guru.springframework.beerworksclient.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrder {
    private UUID customerId;
    private String customerRef;
    private List<BeerOrderLine> beerOrderLines;
    private String orderStatus;
    private URI orderStatusCallbackUrl;
    private UUID id;
    private Integer version;
    private Date createdDate;
    private Date lastModifiedDate;
}
