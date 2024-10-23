# SimplePaymentApp - Stripe Payment Integration

This is a Spring Boot application that integrates with the Stripe API for payment processing. The application allows users to create card tokens and charge payments using Stripe.

## Features

- **Card Tokenization**: Securely create card tokens using the Stripe API.
- **Payment Processing**: Process charges by creating Stripe payments with custom metadata.
- **Logging and Error Handling**: Logs errors and responses from Stripe to ensure traceability.

## Requirements

- Java 17+
- Spring Boot 3.x
- Stripe Java Library
- Maven or Gradle
- A Stripe account with API keys


5. The app will be available at `http://localhost:8080`.

## API Endpoints

1. **Create Card Token**:
    - **Endpoint**: `/api/v1/payment/token`
    - **Method**: `POST`
    - **Payload**:
        ```json
        {
          "cardNumber": "4242424242424242",
          "expMonth": "12",
          "expYear": "2024",
          "cvc": "123"
        }
        ```
    - **Response**:
        ```json
        {
          "success": true,
          "token": "tok_visa"
        }
        ```

2. **Process Payment**:
    - **Endpoint**: `/api/v1/payment/charge`
    - **Method**: `POST`
    - **Payload**:
        ```json
        {
          "amount": 5000,
          "stripeToken": "tok_visa",
          "additionalInfo": {
            "ID_TAG": "123456"
          }
        }
        ```
    - **Response**:
        ```json
        {
          "success": true,
          "chargeId": "ch_xxxxxxx"
        }
        ```

## Stripe Configuration

Ensure that your Stripe API key is set correctly in the environment or in the `application.properties` file. You can find your API keys in the Stripe Dashboard under Developers > API Keys.

## License

This project is licensed under the MIT License.