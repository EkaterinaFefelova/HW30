package org.example.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.example.Case;
import org.example.Employee;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeSerializer implements JsonSerializer<Employee> {
    @Override
    public JsonElement serialize(Employee employee, Type type, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.addProperty ("name", employee.getEmployeeName());
        result.addProperty ("position", employee.getPosition());
        result.add("cases", context.serialize(employee.getCases()));

        return result;
    }
}
