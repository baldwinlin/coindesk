package com.example.coindesk.service;

import com.example.coindesk.coindeskdata.Currency;
import com.example.coindesk.coindeskdata.NewCurrency;
import com.example.coindesk.model.Coins;
import com.example.coindesk.repository.CoinsRepository;
import com.example.coindesk.utils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CoinsServiceImpl implements CoinsService {

    @Autowired
    private CoinsRepository coinsRepository;

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public Coins insert(Coins coins) {
        return coinsRepository.save(coins);
    }

    @Override
    public String update(Coins coins) {
        Coins c = coinsRepository.findByName(coins.getName());
        if(c != null) {
            coinsRepository.save(coins);
            return coins.getName() + " 己修改為" + coins.getChtname();
        }
        else {
            return coins.getName() + " 不存在";
        }
    }

    @Override
    public String deleteByName(String coinName) {
        Coins c = coinsRepository.findByName(coinName);
        if(c != null) {
            coinsRepository.delete(c);
            return coinName + " 已被刪除";
        }
        else {
            return coinName + " 不存在";
        }
    }

    @Override
    public String getByName(String coinName) {
        Coins coins = coinsRepository.findByName(coinName);
        if(coins != null) {
            return coinName + " 的中文名稱為: " + coins.getChtname();
        }
        else {
            return coinName + " 不存在";
        }
    }

    @Override
    public NewCurrency convertCoindesk(Currency c) {
        String updatetime = ConvertUtils.convertUtcToTaiwanTime(c.getTime().getUpdated());
        String chartName = c.getChartName();

        Coins coins = coinsRepository.findByName(chartName);
        String chtname = coins.getChtname();

        NewCurrency nc = new NewCurrency();
        nc.setChartName(chartName);
        nc.setUpdatetime(updatetime);
        nc.setChtname(chtname);
        nc.setBpi(c.getBpi());

        return nc;
    }
}
