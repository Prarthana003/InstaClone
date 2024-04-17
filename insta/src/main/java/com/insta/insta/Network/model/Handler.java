package com.insta.insta.Network.model;

public interface Handler {
    void setNextHandler(Handler handler);

    void handleRequest(String user, String myUser);
}
