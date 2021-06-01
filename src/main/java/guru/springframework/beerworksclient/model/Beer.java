package guru.springframework.beerworksclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beer {
    @Null
    private UUID id;

    @NotBlank
    private String beerName;

    @NotBlank
    private String beerStyle;

    private String upc;

    private Integer quantityOnHand;

    private String price;

    private Integer version;

    private Date createdDate;

    private Date lastModifiedDate;
}
