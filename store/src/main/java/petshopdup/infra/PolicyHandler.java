package petshopdup.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import petshopdup.config.kafka.KafkaProcessor;
import petshopdup.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    CustomerRepository customerRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @Autowired
    petshopdup.external.PetService petService;

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PetRegistered'"
    )
    public void wheneverPetRegistered_DisplayToTheShop(
        @Payload PetRegistered petRegistered
    ) {
        PetRegistered event = petRegistered;
        System.out.println(
            "\n\n##### listener DisplayToTheShop : " + petRegistered + "\n\n"
        );

        // REST Request Sample

        // petService.getPet(/** mapping value needed */);

        // Sample Logic //
        Item.displayToTheShop(event);
    }
    // keep

}
