package com.example.coindesk;

import com.example.coindesk.coindeskdata.Currency;
import com.example.coindesk.coindeskdata.NewCurrency;
import com.example.coindesk.model.Coins;
import com.example.coindesk.service.CoinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class CoinsController {

    @Autowired
    private CoinsService coinsService;

    //新增幣別對應
    @PostMapping("/coins")
    public Coins addCoins(@RequestBody Coins coins) {

        return coinsService.insert(coins);

    }

    //修改幣別對應
    @PutMapping("/coins/{coinName}")
    public String updateCoins(@PathVariable String coinName, @RequestBody Coins coins) {

        coins.setName(coinName);
        return coinsService.update(coins);

    }

    //刪除幣別對應
    @DeleteMapping("/coins/{coinName}")
    public String deleteCoins(@PathVariable String coinName) {

        return coinsService.deleteByName(coinName);

    }

    //查詢幣別對應
    @GetMapping("/coins/{coinName}")
    public String getByName(@PathVariable String coinName) {

        return coinsService.getByName(coinName);

    }

    //呼叫 coindesk 的 API
    @GetMapping("/getCoindeskSrc")
    public Currency getCoindeskSrc() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(
                "https://kengp3.github.io/blog/coindesk.json",
                Currency.class);
    }

    //呼叫新的API
    @GetMapping("/getCoindeskNew")
    public NewCurrency getCoindeskNew() {
        RestTemplate restTemplate = new RestTemplate();
        Currency c = restTemplate.getForObject(
                "https://kengp3.github.io/blog/coindesk.json",
                Currency.class);

        return coinsService.convertCoindesk(c);
    }

}
