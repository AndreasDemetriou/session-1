package ru.sbt.jschool.session1;

import java.util.Map;

/**
 * Created by Andreas on 21.03.2018.
 */

public class Problem3 {
    public static void main(String[] args) {
        Map<String,String> sv= System.getenv();
        System.out.println("System enviroment variables: ");
        for (Map.Entry<String, String> entry : sv.entrySet()) {
            System.out.println("Variable = " + entry.getKey() + "; value = " + entry.getValue());
        }
        System.out.println(sv.get("name"));
    }
}
