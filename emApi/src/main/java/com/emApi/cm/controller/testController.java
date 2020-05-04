package com.emApi.cm.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class testController {

    @GetMapping("")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String findAll() {
        return "Działa essa :)";
    }
}
