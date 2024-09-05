package dannelysbeth.payment.app.simplepaymentapp.api;

import dannelysbeth.payment.app.simplepaymentapp.dto.StripeCharge;
import dannelysbeth.payment.app.simplepaymentapp.dto.StripeToken;
import dannelysbeth.payment.app.simplepaymentapp.service.StripeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stripe")
@AllArgsConstructor
public class StripeController {

    private final StripeService stripeService;

    @PostMapping("/card/token")
    @ResponseBody
    public StripeToken createCardToken(@RequestBody StripeToken model) {
        return stripeService.createCardToken(model);
    }

    @PostMapping("/charge")
    @ResponseBody
    public StripeCharge charge(@RequestBody StripeCharge model) {
        return stripeService.charge(model);
    }
}
