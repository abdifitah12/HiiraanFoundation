package com.hiiraan.hiiraan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/donate")
public class HiiraanController {

    @GetMapping("/home")
    public String getHome(Model model) {
        return "index";
    }

    @GetMapping("/home/donation")
    public String getWater(Model model) {
        return "index";
    }

    @GetMapping("/about")
    public String getAbout(Model model) {
        return "aboutUs"; // Make sure "aboutUs" matches the filename in the templates folder.
    }

    @GetMapping("/causes")
    public String getCauses(Model model) {
        return "causes"; // Assuming you have causes.html as a view template.
    }

    @GetMapping("/projects")
    public String getProject(Model model) {
        return "projects"; // Assuming you have projects.html as a view template.
    }

    // New endpoint for the "Read More" button
    @GetMapping("/read-more")
    public String getReadMore(Model model) {
        return "readMore"; // Create a readMore.html template for this page.
    }

    // New endpoint for the "Donate Now" button
    @GetMapping("/donate")
    public String getDonatePage(Model model) {
        return "donate"; // Create a donate.html template for this page.
    }
}
