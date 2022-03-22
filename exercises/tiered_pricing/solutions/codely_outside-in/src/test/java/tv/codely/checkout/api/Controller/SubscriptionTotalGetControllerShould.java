package tv.codely.checkout.api.Controller;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import tv.codely.checkout.api.ApiTestCase;

public class SubscriptionTotalGetControllerShould extends ApiTestCase {

    @Test
    public void calculate_total_subscription_price() throws Exception {
        whenGetRequestSentTo("/subscription-total-price?subscriptions=5");

        JSONObject jsonResponse = new JSONObject().put("total", 199);
        assertSuccessJsonResponse(jsonResponse);
    }
}
