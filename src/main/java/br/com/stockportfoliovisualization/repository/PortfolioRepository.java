package br.com.stockportfoliovisualization.repository;

import br.com.stockportfoliovisualization.model.UserPortfolio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PortfolioRepository extends MongoRepository<UserPortfolio, String> {
}
