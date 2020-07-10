package com.lambda.websprint.controllers;

import com.lambda.websprint.models.Coin;
import com.lambda.websprint.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {

    @Autowired
    CoinRepository coinrepos;
    private List<Coin> findCoin (List<Coin> myList, CheckCoin tester)
    {
        List<Coin> tempList = new ArrayList<>();

        for (Coin e : myList)
        {
            if(tester.test(e))
            {
                tempList.add(e);
            }
        }

        return tempList;
    }

    //    http://localhost:2019/total
    @GetMapping(value = "/total",
    produces = {"application/json"})
    public ResponseEntity<?> totalCoins()
    {
        List<Coin> myList = new ArrayList<>();
        coinrepos.findAll().iterator().forEachRemaining(myList::add);
        double total = 0;
        String coinList = "";
        for (Coin e : myList) {
            total = total + (e.getValue() * e.getQuantity());
            coinList = coinList + e.getQuantity() + " " + e.getName() + " ";

        }
        System.out.println( coinList + "The piggy bank holds " + total);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
