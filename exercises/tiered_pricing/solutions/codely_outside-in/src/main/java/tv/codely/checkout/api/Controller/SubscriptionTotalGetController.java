package tv.codely.checkout.api.Controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.checkout.CalculateSubscriptionsPrice;

import javax.servlet.http.HttpServletResponse;

@RestController
public class SubscriptionTotalGetController {

    @GetMapping("/subscription-total-price")
    public ResponseEntity<String> response(@RequestParam String subscriptions, HttpServletResponse response) throws JSONException {
        response.addHeader("content-type", "application/json");

        var calculateSubscriptionsPrice = new CalculateSubscriptionsPrice();

        int total = calculateSubscriptionsPrice.execute(subscriptions);

        return ResponseEntity.ok(new JSONObject().put("total", total).toString());
    }
}
