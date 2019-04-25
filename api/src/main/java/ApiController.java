import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by zhoulei17344 on 2019-4-25.
 */
@Controller
@EnableAutoConfiguration
public class ApiController {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        try {
            FundApiMethod.loginInterface();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return "Hello 周磊!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApiController.class, args);
    }
}
