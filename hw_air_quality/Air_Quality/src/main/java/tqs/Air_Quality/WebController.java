package tqs.Air_Quality;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tqs.entities.Quality;
import tqs.controller.RestClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        String lat = "40.6442700";
        String lon = "-8.6455400";
        String[] args= {lat, lon};
        System.out.println("HHH");
        RestClient.main(args);
        System.out.println("HHI");
        return "homePage";
    }

    /*@GetMapping("/city/")
    public String cityData(@RequestParam(name = "lat") double lat, @RequestParam(name = "lon") double lon, Model model) {
        Quality quality = clientRepository.getByEmail(email);
        model.addAttribute("quality", quality);
        return "cityPage";
    }*/

}
