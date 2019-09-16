package barrenland.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DefaultController {

    @RequestMapping("/")
    public String firstPage() {
        return "Hello Barren Land successfully deployed and started...";
    }


}
