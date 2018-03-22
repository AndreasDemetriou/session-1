package ru.sbt.jschool.session1;

import java.io.*;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Andreas on 20.03.2018.
 */
public class HelloWorld {
    public static void main(String[] args) throws IOException {
        if(args.length != 0) {
            if (args[0].contains("JSCHOOl1_COUNT=")){
                int n = Integer.parseInt(args[0].substring("JSCHOOl1_COUNT=".length()));
                for (int i = 0; i < n; i++)
                    System.out.println("Hello World!!!");
            }
        }
        else{
            if(System.getProperties().containsKey("JSCHOOl1_COUNT")){
                int n = Integer.parseInt(System.getProperties().get("JSCHOOl1_COUNT").toString());
                for (int i = 0; i < n; i++)
                    System.out.println("Hello World!!!");
            }
            else
            {
                Map<String,String> sv= System.getenv();
                if(sv.containsKey("JSCHOOl1_COUNT")){
                    int n = Integer.parseInt(sv.get("JSCHOOl1_COUNT"));
                    for (int i = 0; i <n; i++) {
                        System.out.println("Hello World!");
                    }
                }
                else{
                    if(sv.containsKey("JSCHOOL1_PROPERTIES_FILE")){
                        String s =sv.get("JSCHOOL1_PROPERTIES_FILE"); //это путь
                        try {
                            FileInputStream fileIn = new FileInputStream(s);
                            BufferedReader br = new BufferedReader(new InputStreamReader(fileIn));
                            String strLine = br.readLine();
                            if (strLine.contains("JSCHOOl1_COUNT=")){
                                int n = Integer.parseInt(strLine.substring("JSCHOOl1_COUNT=".length()));
                                for (int i = 0; i < n; i++)
                                    System.out.println("Hello World!!!");
                            }
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }
                    }
                    else{
                        System.out.println("Read manuals before using:");
                        System.out.println("Three ways to set args: by argument, by system settings or by system environment variable!");
                    }
                }
            }
        }
    }
}
