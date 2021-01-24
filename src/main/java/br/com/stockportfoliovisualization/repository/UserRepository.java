package br.com.stockportfoliovisualization.repository;

import br.com.stockportfoliovisualization.model.UserPortfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements UserDetailsService {

    @Autowired
    PortfolioMongoRepository portfolioMongoRepository;


    @Override
    public UserPortfolio loadUserByUsername(String email) throws UsernameNotFoundException {
        return portfolioMongoRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User " +email +" not found."));
    }
}
