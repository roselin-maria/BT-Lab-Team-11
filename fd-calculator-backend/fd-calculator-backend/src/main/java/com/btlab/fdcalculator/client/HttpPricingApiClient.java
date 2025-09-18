package com.btlab.fdcalculator.client;

import com.btlab.fdcalculator.model.dto.CategoryDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@Component
@Profile("prod")
public class HttpPricingApiClient implements PricingApiClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "http://product-pricing-service"; // configure via properties

    @Override
    public BigDecimal getBaseRate(String productCode) {
        return restTemplate.getForObject(BASE_URL + "/rates/" + productCode, BigDecimal.class);
    }

    @Override
    public List<CategoryDTO> getCategories() {
        ResponseEntity<List<CategoryDTO>> resp = restTemplate.exchange(
            BASE_URL + "/categories",
            HttpMethod.GET, null,
            new ParameterizedTypeReference<List<CategoryDTO>>() {}
        );
        return resp.getBody();
    }
}
