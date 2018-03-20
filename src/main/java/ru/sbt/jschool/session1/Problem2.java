package ru.sbt.jschool.session1;

import java.util.Enumeration;
import java.util.Map;

/**
 * Created by Andreas on 20.03.2018.
 */
public class Problem2 {
    public static void main(String[] args) {
        Enumeration e =System.getProperties().propertyNames();
        Map<String,String> sv= System.getenv();
        System.out.println("Property variables: ");
        while( e.hasMoreElements() )
        {
            String prop = (String)e.nextElement();
            System.out.println(prop);
            //System.out.println(System.getProperty(prop)); output of values
        }
        System.out.println("System enviroment variables: ");
        for (Map.Entry<String, String> entry : sv.entrySet()) {
            System.out.println("Variable = " + entry.getKey() + "; value = " + entry.getValue());
        }
    }
}
