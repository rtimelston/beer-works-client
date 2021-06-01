package guru.springframework.beerworksclient.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeerOrderLine {
    private UUID beerId;
    private String upc;
    private Integer orderQuantity;
    private Integer quantityAllocated;
    private UUID id;
    private Integer version;
    private Date createdDate;
    private Date lastModifiedDate;
}
