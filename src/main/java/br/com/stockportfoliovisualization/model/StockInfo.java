package br.com.stockportfoliovisualization.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StockInfo {

    private String stock;

    private BigDecimal stockValues;

    private Integer quantity;

    private BigDecimal fees;
}
