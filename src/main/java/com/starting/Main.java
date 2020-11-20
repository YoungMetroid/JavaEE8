package com.starting;

import com.starting.simpleClasses.*;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;



public class Main {


    public static void main(String[] args)
    {
        System.out.println("Testing");
        JsonTesting();
    }
    public static void JsonTesting()
    {
        Ticket t = new Ticket();
        t.name = "Felipe";
        t.priority = 25;

        Jsonb jsonb = JsonbBuilder.create();
        String jsonString = jsonb.toJson(t);
    }
    public static void LambdasTesting()
    {
        List<Hero> heroes = Arrays.asList
                (
                        new Hero("Hulk", false),
                        new Hero("Superman", true),
                        new Hero("Batman", false)
                );

        heroes.stream().filter(hero -> hero.canFly).map(hero -> hero.name).forEach(s -> System.out.println(s));
        String foundName = heroes.stream().filter(hero -> hero.name.contains("Bat")).map(hero -> hero.name).findFirst().orElse("");
        List<String> result = getNamesMeetingCondition(heroes,h -> h.name.contains("man"));
        result.forEach(s-> System.out.println(s));
    }
    public static List<String> getNamesMeetingCondition(List<Hero> heroList,
                                          Predicate<Hero> condition)
    {
        List<String> foundName = new ArrayList<>();
        for(Hero hero: heroList)
        {
            if(condition.test(hero))
            {
                foundName.add(hero.name);
            }
        }
        return foundName;
    }

}
