package tv.codely.checkout.api.Controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class ExampleGetController {

    @GetMapping("/")
    public ResponseEntity<String> response(@RequestParam String name, HttpServletResponse response) throws JSONException {
        response.addHeader("content-type", "application/json");

        return ResponseEntity.ok(new JSONObject().put("hello", name).toString());
    }
}
