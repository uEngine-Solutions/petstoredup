package petshopdup.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import petshopdup.PetApplication;
import petshopdup.domain.PetRegistered;

@Entity
@Table(name = "Pet_table")
@Data
@DiscriminatorValue("pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int appearance;


    


    @Embedded
    private Address address;

    @PostPersist
    public void onPostPersist() {
        PetRegistered petRegistered = new PetRegistered(this);
        petRegistered.publishAfterCommit();
        // Get request from Item
        //petshopdup.external.Item item =
        //    Application.applicationContext.getBean(petshopdup.external.ItemService.class)
        //    .getItem(/** mapping value needed */);

    }

    @PrePersist
    public void onPrePersist() {
        // Get request from Item
        //petshopdup.external.Item item =
        //    Application.applicationContext.getBean(petshopdup.external.ItemService.class)
        //    .getItem(/** mapping value needed */);

    }

    public static PetRepository repository() {
        PetRepository petRepository = PetApplication.applicationContext.getBean(
            PetRepository.class
        );
        return petRepository;
    }

    public void eat() {
        //
    }

    public void sleep() {
        //
    }


    public void speak() {
    }

    public void feed(FeedCommand feedCommand) {}
    
    public void groom(){}

}
