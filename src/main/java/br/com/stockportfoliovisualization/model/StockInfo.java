package br.com.stockportfoliovisualization.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StockInfo {

    private String stock;

    @Field(name = "stock_purchase_value")
    private BigDecimal stockPurchaseValue;

    private BigDecimal stockTotalPurchaseValue;

    private Integer quantity;

    @Field(name = "current_stock_value")
    private BigDecimal currentStockValue;

    @Field(name = "current_total_stock_value")
    private BigDecimal currentTotalStockValue;

    @Field(name = "total_spent_value")
    private BigDecimal totalSpentValue;

    private BigDecimal fees;
}
