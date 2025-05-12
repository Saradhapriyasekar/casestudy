package com.hexaware.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBPropertyUtil {
    public static String getPropertyString(String fileName) {
        Properties props = new Properties();
        StringBuilder sb = new StringBuilder();

        try (InputStream input = DBPropertyUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find db.properties");
                return null;
            }

            props.load(input);

            sb.append("jdbc:mysql://")
              .append(props.getProperty("host"))
              .append(":")
              .append(props.getProperty("port"))
              .append("/")
              .append(props.getProperty("dbname"))
              .append("?user=")
              .append(props.getProperty("username"))
              .append("&password=")
              .append(props.getProperty("password"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
