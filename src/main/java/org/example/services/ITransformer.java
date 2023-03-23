package org.example.services;

import com.google.gson.JsonObject;

public interface ITransformer {
    JsonObject toJson(int code,  String message ,String serverMessage );
}
