package org.youngmonkeys.example.ezyhttp.login.controller;

import com.tvd12.ezyfox.bean.annotation.EzyAutoBind;
import com.tvd12.ezyhttp.server.core.annotation.Controller;
import com.tvd12.ezyhttp.server.core.annotation.DoGet;
import com.tvd12.ezyhttp.server.core.annotation.RequestCookie;
import com.tvd12.ezyhttp.server.core.view.Redirect;
import com.tvd12.ezyhttp.server.core.view.View;
import org.youngmonkeys.example.ezyhttp.login.annotation.UserId;
import org.youngmonkeys.example.ezyhttp.login.entity.User;
import org.youngmonkeys.example.ezyhttp.login.entity.UserStatus;
import org.youngmonkeys.example.ezyhttp.login.service.impl.UserService;

import javax.servlet.http.Cookie;

@Controller
public class HomeController {

    @EzyAutoBind
    private UserService loginService;

    @DoGet("/")
    public Object index() {
        return Redirect.to("/home");
    }

    @DoGet("/home")
    public Object home( @RequestCookie("accessToken") String accessToken,
                        @RequestCookie("callBackUrl") String callBackUrl,
                        @UserId long userId) {
        User user = loginService.getUserById(userId);
        if (user == null) {
            return Redirect.to("/login");
        }
        return Redirect.builder()
                .uri(callBackUrl + "?ssoToken=" + accessToken)
                .build();
    }


}
