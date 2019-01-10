package com.example.xxxan.myapplication;

import java.util.HashMap;

class Contact extends HashMap<String, String> {
    String name;                          // key
    String TOTP;                            // value
    Contact(String name, String TOTP){
        this.name = name;
        this.TOTP = TOTP;
    }
}