package guru.springframework.beerworksclient.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String name;
    private UUID id;
    private Date createDate;
    private Date lastModifiedDate;
}
