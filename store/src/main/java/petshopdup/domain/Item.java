package petshopdup.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import petshopdup.StoreApplication;
import petshopdup.domain.ItemRegistered;

@Entity
@Table(name = "Item_table")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String type;

    @Embedded
    private Money price;

    @Embedded
    private PetId petId;

    @PostPersist
    public void onPostPersist() {
        ItemRegistered itemRegistered = new ItemRegistered(this);
        itemRegistered.publishAfterCommit();
    }

    public static ItemRepository repository() {
        ItemRepository itemRepository = StoreApplication.applicationContext.getBean(
            ItemRepository.class
        );
        return itemRepository;
    }

    public static void displayToTheShop(PetRegistered petRegistered) {
        /** Example 1:  new item 
        Item item = new Item();
        repository().save(item);

        ItemRegistered itemRegistered = new ItemRegistered(item);
        itemRegistered.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(petRegistered.get???()).ifPresent(item->{
            
            item // do something
            repository().save(item);

            ItemRegistered itemRegistered = new ItemRegistered(item);
            itemRegistered.publishAfterCommit();

         });
        */

    }
}
