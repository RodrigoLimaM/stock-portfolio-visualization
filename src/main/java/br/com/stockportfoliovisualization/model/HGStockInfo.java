package br.com.stockportfoliovisualization.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HGStockInfo {

    private BigDecimal price;
}
