package petshopdup.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "store", url = "${api.path.store}")
public interface ItemService {
    @RequestMapping(method = RequestMethod.GET, path = "/items/{id}")
    public Item getItem(@PathVariable("id") Long id);
    // keep

}
