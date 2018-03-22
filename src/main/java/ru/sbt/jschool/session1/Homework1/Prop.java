package ru.sbt.jschool.session1.Homework1;

import java.io.*;
import java.util.Properties;

/**
 * Created by Andreas on 22.03.2018.
 */

public class Prop implements PropertyHelper{
    String[] args;
    String path;
    String result = null;
    Properties prop;
    Properties propFromArgs;
    Prop(String[] args, String path){
        this.args = args;
        this.path = path;
        FileInputStream fileInputStream;
        prop = new Properties();
        propFromArgs = new Properties();
        try {
            fileInputStream = new FileInputStream(path);
            prop.load(fileInputStream);
            for (int i = 0; i < args.length; i++) {
                InputStream input = new ByteArrayInputStream(args[i].getBytes("UTF8"));
                propFromArgs.load(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public String stringValue(String name) {
        if(propFromArgs.containsKey(name)) {
            result = propFromArgs.getProperty(name);
        }
        else{
            if(System.getProperties().containsKey(name)){
                result = System.getProperties().get(name).toString();
            }
            else {
                if (System.getenv().containsKey(name)) {
                    result = System.getenv().get(name);
                }
                else{
                    result = prop.getProperty(name);
                }
            }
        }
        return result;
    }

    @Override
    public Integer integerValue(String name) {
        if (this.stringValue(name)!=null)
        return Integer.parseInt(this.stringValue(name));
        else return null;
    }

    @Override
    public Double doubleValue(String name) {
        if (this.stringValue(name)!=null)
        return Double.parseDouble(this.stringValue(name));
        else return null;
    }

    public static void main(String[] args) {
        Prop px = new Prop(args,"C:\\Users\\Andreas\\Desktop\\1.txt");
        System.out.println(px.stringValue("type"));
        System.out.println(px.integerValue("count"));
        System.out.println(px.doubleValue("cost"));
    }
}