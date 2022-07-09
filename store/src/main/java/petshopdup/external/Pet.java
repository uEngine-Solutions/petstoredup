package petshopdup.external;

import java.util.Date;
import lombok.Data;

@Data
public class Pet {

    private Long id;
    private String name;
    private int appearance;
    private int energy;
    private Address address;
    // keep

}
