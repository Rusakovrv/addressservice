package service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AddressController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    RestTemplate restTemplate;

        @RequestMapping("/addressservice")
    public String GeoObject(@RequestParam(value="address") String address) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            headers.set("Authorization","Token 9fc0a7aa7a1edcbd966a9236aca43edbe9ad7338");
            headers.set("X-Secret","6be634d333df2a96df346267babb0bf3b1c53284");
            StringBuilder sb= new StringBuilder("[\"");
            sb.append(address).append("\"]");
            HttpEntity<String> request = new HttpEntity( sb.toString(), headers);
            ResponseEntity<GeoObject[]> quote = restTemplate.exchange("https://cleaner.dadata.ru/api/v1/clean/address", HttpMethod.POST, request ,GeoObject[].class);
            return  quote.getBody()[0].toString();
    }
}
