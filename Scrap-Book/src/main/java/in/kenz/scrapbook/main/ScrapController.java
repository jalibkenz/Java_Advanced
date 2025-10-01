package in.kenz.scrapbook.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ScrapController {

    @Autowired
    private ScrapRepository repo;

    // Show index.html
    @GetMapping("/")
    public String index() {
        return "index"; // maps to src/main/resources/templates/index.html
    }

    // Handle form submission
    @PostMapping("/saveScrap")
    public String saveScrap(@ModelAttribute Scrap scrap, Model model) {
        repo.save(scrap);
        model.addAttribute("message", "Scrap written to Jalib's ScrapBook successfully!");
        return "index"; // reload index.html with message
    }
}