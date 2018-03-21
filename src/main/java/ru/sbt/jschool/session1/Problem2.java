package ru.sbt.jschool.session1;

import java.util.Enumeration;
/**
 * Created by Andreas on 20.03.2018.
 */

public class Problem2 {
    public static void main(String[] args) {
        Enumeration e =System.getProperties().propertyNames();
        while( e.hasMoreElements() )
        {
            String prop = (String)e.nextElement();
            System.out.println(prop);
            //System.out.println(System.getProperty(prop)); output of values
        }
    }
}
