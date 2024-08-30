package dannelysbeth.payment.app.simplepaymentapp.api;

import dannelysbeth.payment.app.simplepaymentapp.dto.StripeChargeDto;
import dannelysbeth.payment.app.simplepaymentapp.dto.StripeTokenDto;
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
    public StripeTokenDto createCardToken(@RequestBody StripeTokenDto model) {
        return stripeService.createCardToken(model);
    }

    @PostMapping("/charge")
    @ResponseBody
    public StripeChargeDto charge(@RequestBody StripeChargeDto model) {
        return stripeService.charge(model);
    }
}
