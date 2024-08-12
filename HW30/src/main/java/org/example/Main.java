package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.deserializers.CaseDeserializer;
import org.example.deserializers.EmployeeDeserializer;
import org.example.serializers.CaseSerializer;
import org.example.serializers.EmployeeSerializer;
import lombok.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Case caseOne = new Case("Годовой отчет",
                "Составить годовой отчет за 23 год",
                "отчет должен быть на 30 страниц");
        Case caseTwo = new Case("Магазин", "Зайти в магазин за продуктами", "Нужно взять молока и селедку");


        Employee hr = new Employee("Марина", 10000, "HR", List.of(caseOne));
        Employee manager = new Employee("Вася", 50000, "Manager", List.of(caseTwo));

        Company company = new Company(List.of(hr, manager));

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Case.class, new CaseSerializer())
                .registerTypeAdapter(Employee.class, new EmployeeSerializer())
                .registerTypeAdapter(Case.class, new CaseDeserializer())
                .registerTypeAdapter(Employee.class, new EmployeeDeserializer())
                .setPrettyPrinting()
                .create();

        String serialized = gson.toJson(company);
        Company deserialized = gson.fromJson(serialized, Company.class);
        System.out.println(">>>Сериализованный объект<<<");
        System.out.println(serialized);
        System.out.println(">>>Десериализованный объект<<<");
        System.out.println(deserialized);

        //todo сериализовывать тут в соответствии со структурой приложенной в файле занятия

        //todo десериализовывать тут обратно.
    }
}
