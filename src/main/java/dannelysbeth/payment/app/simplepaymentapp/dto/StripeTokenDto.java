package dannelysbeth.payment.app.simplepaymentapp.dto;

import lombok.Data;

@Data
public class StripeTokenDto {

    private String cardNumber;
    private String expirationMonth;

    private String cardName;
}
