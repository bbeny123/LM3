package pl.beny.lm3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import pl.beny.lm3.dto.TuringDTO;

import javax.servlet.http.HttpSession;

@SessionAttributes("dto")
@Controller
public class HomeController {


    @GetMapping(value = "/")
    public ModelAndView index(Model model) {
        model.addAttribute("dto", new TuringDTO());
        return new ModelAndView("index", "message", model);
    }

    @PostMapping(value = "/run")
    public ModelAndView run(HttpSession session, Model model, @ModelAttribute("dto") TuringDTO dto) {
        if (dto.isStart()) {
            session.setAttribute("dto", dto);
            dto.setStart(false);
            dto.setResult(dto.getInput());
        } else {
            dto.run();
            session.setAttribute("dto", dto);
        }
        if (dto.isFinish()) {
            model.addAttribute("finish", true);
        }
        return new ModelAndView("run", "message", model);
    }

}
