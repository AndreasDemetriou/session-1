package ru.sbt.jschool.session1.Homework1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Andreas on 22.03.2018.
 */

public class Prop implements PropertyHelper{
    String[] args;
    String path;
    String result = null;
    Prop(String[] args, String path){
        this.args = args;
        this.path = path;
    }
    @Override
    public String stringValue(String name) {
        if(args.length != 0) {
            for (int i = 0; i <args.length; i++) {
                if (args[i].contains(name)) {
                    result = (args[i].substring(name.length()+1));
                }
            }
        }
        else{
            if(path!=null) {
                FileInputStream fileInputStream;
                Properties prop = new Properties();
                try {
                    fileInputStream = new FileInputStream(path);
                    prop.load(fileInputStream);
                    result = prop.getProperty(name);
                    if(result==null){
                        Map<String,String> sv= System.getenv();
                        if(sv.containsKey(name)){
                            result = sv.get(name);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
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