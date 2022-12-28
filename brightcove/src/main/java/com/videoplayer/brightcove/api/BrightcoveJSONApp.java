package com.videoplayer.brightcove.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
//@RequestMapping("/book")
public class BrightcoveJSONApp {

	@RequestMapping("/")
    public String viewIndex() {
        return "index.html";
    }
}
