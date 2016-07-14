package cloud.simple.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GatewayController {

    @Autowired
    private RestTemplate template;

    @ResponseBody
    @RequestMapping(value = "/{service}")
    String home(@PathVariable("service") String api) {
        return template.getForObject(String.format("http://%s", api), String.class);
    }

}
