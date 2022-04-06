package io.swagger.api;

import io.swagger.service.PurchaseService;
import org.json.simple.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
@EnableAutoConfiguration
public class InventorySummary {

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping("/purchasevolume")
    public JSONObject countPurchase() {
        Long purchaseVolume = purchaseService.countPurchase();
        JSONObject jsonpurchaseVolume = new JSONObject();
        jsonpurchaseVolume.put("count",purchaseVolume);
        return jsonpurchaseVolume;
    }

    @RequestMapping("/purchasevalue")
    public JSONObject sumPurchase() {
        BigDecimal purchasevalue = purchaseService.totalPurchase();
        JSONObject jsonPurchaseValue = new JSONObject();
        jsonPurchaseValue.put("total", purchasevalue);
        return jsonPurchaseValue;
    }
}
