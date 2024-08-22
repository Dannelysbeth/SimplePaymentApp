package dannelysbeth.payment.app.simplepaymentapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"dannelysbeth.payment.app.simplepaymentapp.*", "org.springdoc"})
public class SimplePaymentAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimplePaymentAppApplication.class, args);
    }

}
