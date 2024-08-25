package dannelysbeth.payment.app.simplepaymentapp.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Token;
import dannelysbeth.payment.app.simplepaymentapp.dto.StripeTokenDto;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class StripeService {

    @Value("$api.stripe.key")
    private String stripeApiKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = stripeApiKey;
    }

    public StripeTokenDto createCardToken(StripeTokenDto model) {
        try {
            Map<String, Object> card = new HashMap<>();
            card.put("number", model.getCardNumber());
            card.put("exp_month", Integer.parseInt(model.getExpMonth()));
            card.put("exp_year", Integer.parseInt(model.getExpYear()));
            card.put("cvc", model.getCvc());
            Map<String, Object> params = new HashMap<>();
            params.put("card", card);
            Token token = Token.create(params);
            if (token != null && token.getId() != null) {
                model.setSuccess(true);
                model.setToken(token.getId());
            }
            return model;
        } catch (StripeException e) {
            log.error("StripeService (createCardToken)", e);
            throw new RuntimeException(e.getMessage());
        }

    }
}
