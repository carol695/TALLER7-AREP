package org.example.services.impl;

import com.google.gson.JsonObject;
import org.example.services.ITransformer;

public class Transformer implements ITransformer {

    @Override
    public JsonObject toJson(int code, String message, String serverMessage) {
        JsonObject json = new JsonObject();
        json.addProperty("status", code);
        json.addProperty("result", message);
        json.addProperty("serverResponse", serverMessage);

        return json;
    }
}