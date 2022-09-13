package com.example.chatapplication.model;

import android.net.Uri;

public class MessageModel {
    String message,id="abc";
    Uri image;
    ChatType chatType;

    public String getId() {
        return id;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    public ChatType getChatType() {
        return chatType;
    }

    public void setChatType(ChatType chatType) {
        this.chatType = chatType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MessageModel(String id,String message, Uri image,ChatType chatType) {
        this.id = id;
        this.message = message;
        this.image = image;
        this.chatType = chatType;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

   /* public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }*/
}
