package tv.codely.checkout.api.Controller;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import tv.codely.checkout.api.ApiTestCase;

public class ExampleGetControllerShould extends ApiTestCase {

    @Test
    public void spring_boot_e2e_test_example() throws Exception {
        whenGetRequestSentTo("/?name=world");

        JSONObject jsonResponse = new JSONObject().put("hello", "world");
        assertSuccessJsonResponse(jsonResponse);
    }
}
