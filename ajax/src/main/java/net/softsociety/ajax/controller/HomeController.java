package net.softsociety.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.ajax.controller.HomeController;


@Slf4j
@Controller
public class HomeController {

	@GetMapping({"", "/"})
	public String home() {
		return "home";
	}
}
