package guru.springframework.beerworksclient.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beer {
    private String beerName;
    private String beerStyle;
    private String upc;
    private Integer quantityOnHand;
    private String price;
    private UUID id;
    private Integer version;
    private Date createdDate;
    private Date lastModifiedDate;
}
