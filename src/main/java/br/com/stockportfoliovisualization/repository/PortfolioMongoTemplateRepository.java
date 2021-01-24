package br.com.stockportfoliovisualization.repository;

import br.com.stockportfoliovisualization.model.StockInfo;
import br.com.stockportfoliovisualization.model.UserPortfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PortfolioMongoTemplateRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @CacheEvict(value = "portfolio", key = "#_id")
    public UserPortfolio pushStockInfosBy_Id(String _id, List<StockInfo> stockInfos) {
        Criteria criteria = Criteria.where("_id").is(_id);
        stockInfos.forEach(stockInfo -> {
            Update update = new Update();
            update.push("stock_infos", stockInfo);
            mongoTemplate.updateFirst(Query.query(criteria), update, "portfolios");
        });

        return mongoTemplate.findOne(Query.query(criteria), UserPortfolio.class);
    }
}
