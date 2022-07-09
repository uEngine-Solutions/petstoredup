package petshopdup.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import petshopdup.StoreApplication;

@Entity
@Table(name = "Customer_table")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    @Embedded
    private Address address;

    public static CustomerRepository repository() {
        CustomerRepository customerRepository = StoreApplication.applicationContext.getBean(
            CustomerRepository.class
        );
        return customerRepository;
    }
}
