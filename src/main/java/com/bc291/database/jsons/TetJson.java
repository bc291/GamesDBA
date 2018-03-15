package com.bc291.database.jsons;

import com.google.gson.Gson;

public class TetJson {

private Gson g;

    public TetJson() {
        this.g = new Gson();
    }

    public jsonFromGol parseJson(String jsonAsString)
{
    jsonFromGol obj = g.fromJson(jsonAsString, jsonFromGol.class);
    return obj;
}
}