package com.tvd12.example.mail.controller;

import com.tvd12.ezyhttp.server.core.annotation.Controller;
import com.tvd12.ezyhttp.server.core.annotation.DoGet;
import com.tvd12.ezyhttp.server.core.annotation.DoPost;
import com.tvd12.ezyhttp.server.core.annotation.RequestParam;
import com.tvd12.ezyhttp.server.core.view.Redirect;
import com.tvd12.ezyhttp.server.core.view.View;

@Controller
public class LoginController {

    @DoGet("/login")
    public View index() {
        return View.builder()
                .template("login")
                .build();
    }

    @DoGet("/sso-login-callback")
    public Object ssoLoginCallback(@RequestParam("ssoToken") String ssoToken) {
        return Redirect.builder()
                .addCookie("ssoToken", ssoToken)
                .uri("/home")
                .build();
    }

    @DoPost("/logout")
    public Object logout() {
        return Redirect.builder()
            .uri("/login")
            .addCookie("ssoToken", "")
            .build();
    }
}
