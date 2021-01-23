package br.com.stockportfoliovisualization.model.mapper;

import br.com.stockportfoliovisualization.model.UserDTO;
import br.com.stockportfoliovisualization.model.UserPortfolio;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class PortfolioMapper {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserPortfolio mapUserDTOToUserPortfolio(UserDTO userDTO) {
        return UserPortfolio.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(encoder.encode(userDTO.getPassword()))
                .stockInfos(Collections.emptyList())
                .build();
    }
}
