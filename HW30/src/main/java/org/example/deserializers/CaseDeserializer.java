package org.example.deserializers;

import com.google.gson.*;
import org.example.Case;

import java.lang.reflect.Type;

public class CaseDeserializer implements JsonDeserializer<Case> {
    @Override
    public Case deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        Case result = new Case();
        String[] data = jsonElement.getAsString().split(":");
        String title = data[0];
        String description = data[1];
        result.setCaseTitle(title);
        result.setDescription(description);
        return result;
    }
}
