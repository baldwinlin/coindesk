package com.example.coindesk.repository;

import com.example.coindesk.model.Coins;
import org.springframework.data.repository.CrudRepository;

public interface CoinsRepository extends CrudRepository<Coins, String> {
    Coins findByName(String name);
}
