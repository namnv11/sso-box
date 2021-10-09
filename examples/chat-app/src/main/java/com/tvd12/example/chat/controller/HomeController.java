package com.tvd12.example.chat.controller;

import com.tvd12.ezyhttp.server.core.annotation.Controller;
import com.tvd12.ezyhttp.server.core.annotation.DoGet;
import com.tvd12.ezyhttp.server.core.annotation.RequestCookie;
import com.tvd12.ezyhttp.server.core.annotation.RequestParam;
import com.tvd12.ezyhttp.server.core.view.Redirect;
import com.tvd12.ezyhttp.server.core.view.View;

@Controller
public class HomeController {

    @DoGet("/")
    public Object index() {
        return Redirect.to("/home");
    }

    @DoGet("/home")
    public View home(@RequestCookie("ssoToken") String ssoToken) {
        return View.builder()
            .addVariable("ssoToken", ssoToken)
            .template("home")
            .build();
    }
}
