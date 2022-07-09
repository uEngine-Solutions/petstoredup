package petshopdup.domain;

import java.util.*;
import lombok.*;
import petshopdup.domain.*;
import petshopdup.infra.AbstractEvent;

@Data
@ToString
public class PetRegistered extends AbstractEvent {

    private Long id;
    private String name;
    private int appearance;
    private int energy;
    private String address;

    public PetRegistered(Pet aggregate) {
        super(aggregate);
    }

    public PetRegistered() {
        super();
    }
    // keep

}
