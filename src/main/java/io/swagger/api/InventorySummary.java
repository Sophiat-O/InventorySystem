package io.swagger.api;

import io.swagger.service.PurchaseService;
import io.swagger.service.SaleService;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Map;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
@EnableAutoConfiguration
public class InventorySummary {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private SaleService saleService;

    @RequestMapping(value = "/purchasevolume", method = RequestMethod.GET)
    public JSONObject getCountPurchase() {
        Long purchaseVolume = purchaseService.countPurchase();
        JSONObject jsonpurchaseVolume = new JSONObject();
        jsonpurchaseVolume.put("count",purchaseVolume);
        return jsonpurchaseVolume;
    }

    @RequestMapping(value = "/purchasevalue", method = RequestMethod.GET)
    public JSONObject getSumPurchase() {
        BigDecimal purchaseValue = purchaseService.totalPurchase();
        JSONObject jsonPurchaseValue = new JSONObject();
        jsonPurchaseValue.put("total", purchaseValue);
        return jsonPurchaseValue;
    }

    @RequestMapping(value = "/salevolume", method = RequestMethod.GET)
    public JSONObject getCountSale() {
        Long saleVolume = saleService.countSale();
        JSONObject jsonSaleVolume = new JSONObject();
        jsonSaleVolume.put("count",saleVolume);
        return jsonSaleVolume;
    }

    @RequestMapping(value = "/salevalue", method = RequestMethod.GET)
    public JSONObject getSumSale() {
        BigDecimal saleValue = saleService.totalSale();
        JSONObject jsonSaleValue = new JSONObject();
        jsonSaleValue.put("total", saleValue);
        return jsonSaleValue;
    }

    @RequestMapping(value = "/monthlysale", method = RequestMethod.GET)
    public JSONArray getMonthlySale() {
        Map<String, BigDecimal> monthlySale = saleService.monthlySale();
        JSONArray saleByMonth = new JSONArray();
        saleByMonth.add(monthlySale);
        return saleByMonth;
    }

}
