package com.dgtech.kbeh.notifiertester.controller;

import com.dgtech.kbeh.notifier.NotifyKBEH;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/test")
public class NotifierTestController {

    @GetMapping
    @NotifyKBEH(type = "cenas")
    public String excpetionTest() throws Exception{
        throw new Exception("");
    }
}
