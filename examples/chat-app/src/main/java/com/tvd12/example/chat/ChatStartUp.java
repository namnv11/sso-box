package com.tvd12.example.chat;

import com.tvd12.ezyhttp.core.boot.EzyHttpApplicationBootstrap;

public class ChatStartUp {
    public static void main(String[] args) throws Exception {
        EzyHttpApplicationBootstrap.start(ChatStartUp.class);
    }
}
