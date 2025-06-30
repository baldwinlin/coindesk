package com.example.coindesk.service;

import com.example.coindesk.coindeskdata.Currency;
import com.example.coindesk.coindeskdata.NewCurrency;
import com.example.coindesk.model.Coins;

public interface CoinsService {

    //新增幣別對應
    Coins insert(Coins coins);
    //修改幣別對應
    String update(Coins coins);
    //刪除幣別對應
    String deleteByName(String coinName);
    //查詢幣別對應
    String getByName(String coinName);
    //資料轉換
    NewCurrency convertCoindesk(Currency c);

}