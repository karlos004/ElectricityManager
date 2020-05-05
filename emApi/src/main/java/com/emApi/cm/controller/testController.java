package com.emApi.cm.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class testController {

    @GetMapping("")
    @PreAuthorize("hasPermission('essa', 'READ')")
    public String findAll() {
        return "Działa essa ヽ༼ ຈل͜ຈ༼ ▀̿̿Ĺ̯̿̿▀̿ ̿༽Ɵ͆ل͜Ɵ͆ ༽ﾉ";
    }

    @GetMapping("/test1")
    @PreAuthorize("hasPermission('essa', 'DELETE')")
    public String test() {
        return "Działa essa fchuj (˵ ͡° ͜ʖ ͡°˵)";
    }

    @GetMapping("/test2")
    @PreAuthorize("hasPermission('essa', 'KUPA')")
    public String test2() {
        return "nie powinno sie pokazac ⤜(ⱺ ʖ̯ⱺ)⤏";
    }
}
