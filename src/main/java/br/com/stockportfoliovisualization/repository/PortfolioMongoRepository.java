package br.com.stockportfoliovisualization.repository;

import br.com.stockportfoliovisualization.model.UserPortfolio;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PortfolioMongoRepository extends MongoRepository<UserPortfolio, String> {

    Optional<UserPortfolio> findByEmail(String email);

    boolean existsByEmail(String email);
}
