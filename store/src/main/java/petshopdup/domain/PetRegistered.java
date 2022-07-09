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
    private Object appearance;
    private Object energy;
    private String address;
    // keep

}
