package com.example.coindesk.service;

import com.example.coindesk.coindeskdata.Currency;
import com.example.coindesk.coindeskdata.NewCurrency;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CoinsServiceImplTest {

    @Autowired
    private CoinsService coinsService;

    @Test
    public void convert() throws JsonProcessingException {
        String json = "{\n" +
                "  \"time\": {\n" +
                "    \"updated\": \"Sep 2, 2024 07:07:20 UTC\",\n" +
                "    \"updatedISO\": \"2024-09-02T07:07:20+00:00\",\n" +
                "    \"updateduk\": \"Sep 2, 2024 at 08:07 BST\"\n" +
                "  },\n" +
                "  \"disclaimer\": \"just for test\",\n" +
                "  \"chartName\": \"Bitcoin\",\n" +
                "  \"bpi\": {\n" +
                "    \"USD\": {\n" +
                "      \"code\": \"USD\",\n" +
                "      \"symbol\": \"&#36;\",\n" +
                "      \"rate\": \"57,756.298\",\n" +
                "      \"description\": \"United States Dollar\",\n" +
                "      \"rate_float\": 57756.2984\n" +
                "    },\n" +
                "    \"GBP\": {\n" +
                "      \"code\": \"GBP\",\n" +
                "      \"symbol\": \"&pound;\",\n" +
                "      \"rate\": \"43,984.02\",\n" +
                "      \"description\": \"British Pound Sterling\",\n" +
                "      \"rate_float\": 43984.0203\n" +
                "    },\n" +
                "    \"EUR\": {\n" +
                "      \"code\": \"EUR\",\n" +
                "      \"symbol\": \"&euro;\",\n" +
                "      \"rate\": \"52,243.287\",\n" +
                "      \"description\": \"Euro\",\n" +
                "      \"rate_float\": 52243.2865\n" +
                "    }\n" +
                "  }\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        Currency c = mapper.readValue(json, Currency.class);

        NewCurrency newCurrency =  coinsService.convertCoindesk(c);

        assertEquals(newCurrency.getChtname(), "比特幣");
        assertEquals(newCurrency.getUpdatetime(), "2024/09/02 15:07:20");

    }
}