package petshopdup.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import petshopdup.domain.*;

@RepositoryRestResource(collectionResourceRel = "pets", path = "pets")
public interface PetRepository extends PagingAndSortingRepository<Pet, Long> {}
