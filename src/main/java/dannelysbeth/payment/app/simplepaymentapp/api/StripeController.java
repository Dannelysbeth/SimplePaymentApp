package dannelysbeth.payment.app.simplepaymentapp.api;

import dannelysbeth.payment.app.simplepaymentapp.service.StripeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stripe")
@AllArgsConstructor
public class StripeController {

    private final StripeService stripeService;
}
