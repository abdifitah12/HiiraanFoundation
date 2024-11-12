package com.hiiraan.hiiraan.controller;

import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api/v1/donate")
public class paymentController {

    @PostMapping("/create-checkout-session")
    public String createCheckoutSession(@RequestBody Map<String, Object> data) throws Exception {
        Stripe.apiKey = "your-stripe-secret-key";

        String name = (String) data.get("name");
        String email = (String) data.get("email");
        int amount = (Integer) data.get("amount");

        SessionCreateParams params = SessionCreateParams.builder()
                .setCustomerEmail(email)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("https://yourwebsite.com/success")
                .setCancelUrl("https://yourwebsite.com/cancel")
                .addLineItem(
                        SessionCreateParams.LineItem.builder()
                                .setQuantity(1L)
                                .setPriceData(
                                        SessionCreateParams.LineItem.PriceData.builder()
                                                .setCurrency("usd")
                                                .setUnitAmount((long) amount) // amount in cents
                                                .setProductData(
                                                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                .setName("Donation from " + name)
                                                                .build())
                                                .build())
                                .build())
                .build();

        Session session = Session.create(params);

        return session.getUrl(); // Redirect the user to this URL
    }
}
