package br.com.stockportfoliovisualization.client;

import br.com.stockportfoliovisualization.model.HGStockInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "HGFinanceClient", url = "${hg-finance.url}")
public interface HGFinanceClient {

    @GetMapping("/finance/stock_price")
    Map<String, HGStockInfo> getStockPrice(@RequestParam String key,
                                           @RequestParam String symbol,
                                           @RequestParam String fields);
}
