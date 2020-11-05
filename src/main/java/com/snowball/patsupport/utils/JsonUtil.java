package com.snowball.patsupport.utils;

import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonUtil {

    public static final <T> T fromJson(String jsonData, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(jsonData, clazz);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static final <T> List<T> fromJsonArray(String jsonData, Class<T> clazz) {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonElement el = parser.parse(jsonData);
        JsonArray jsonArray = el.getAsJsonArray();
        Iterator it = jsonArray.iterator();
        List list = new ArrayList();
        while (it.hasNext()) {
            JsonElement je = (JsonElement) it.next();
            list.add(gson.fromJson(je, clazz));
        }

        return list;
    }

    public  static String toJson(Object object, boolean pretty) {
        GsonBuilder gb = new GsonBuilder();
        if (pretty) gb.setPrettyPrinting();
        gb.disableHtmlEscaping();
        Gson gson = gb.create();
        return gson.toJson(object);
    }
}
