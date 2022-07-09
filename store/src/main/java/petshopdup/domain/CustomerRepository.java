package petshopdup.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import petshopdup.domain.*;

@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
public interface CustomerRepository
    extends PagingAndSortingRepository<Customer, Long> {}
