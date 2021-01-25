package br.com.stockportfoliovisualization.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Document(collection = "portfolios")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPortfolio implements UserDetails {

    private String _id;

    private String email;

    private String password;

    private String name;

    @Field(name = "stock_infos")
    private List<StockInfo> stockInfos;

    private BigDecimal totalStocksPurchaseValue;

    private Integer totalStocksQuantity;

    private BigDecimal totalAllStocksPurchaseValue;

    private BigDecimal totalFees;

    private BigDecimal totalCurrentStockValue;

    private BigDecimal totalAllCurrentStockValue;

    private BigDecimal totalSpentValue;

    private BigDecimal currentProfit;

    @CreatedDate
    @Field(name = "creation_date")
    private LocalDateTime creationDate;

    @LastModifiedDate
    @Field(name = "update_date")
    private LocalDateTime updateDate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
