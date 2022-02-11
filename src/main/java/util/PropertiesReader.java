package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private Properties properties;
    private final String PropertyFilePath= "src/test/resources/properties";

    public PropertiesReader(){
        BufferedReader reader;
        BufferedReader commonReader;
        try {
            //reader = new BufferedReader(new FileReader(getEnvironmentPropertiesFilePath()));
            commonReader = new BufferedReader(new FileReader(PropertyFilePath));
            properties = new Properties();
            try {
               // properties.load(reader);
                properties.load(commonReader);
               // reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
           // throw new RuntimeException("Properties file not found at " + getEnvironmentPropertiesFilePath());
        }
    }
    //environments
   /* private String getEnvironmentPropertiesFilePath(){
        String env = "QA";
        //String env = properties.getProperty("env");
        if (env.equalsIgnoreCase("QA")) {
            return "src/test/resources/qa/qa.configuration.properties";
        }
        else if(env.equalsIgnoreCase("UAT")){
            return "src/test/resources/uat/uat.configuration.properties";
        }
        else{
            return "src/test/resources/qa/qa.configuration.properties";		}
    }*/
    // urls
    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the system.properties file.");
    }
    // browsers
    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if(browser != null) return browser;
        else throw new RuntimeException("Browser definition not found");
    }
    // credentials
    public String getUserName() {
        String username = properties.getProperty("username");
        if(username != null) return username;
        else throw new RuntimeException("Username not specified in the properties file.");
    }
    public String getUserPassword() {
        String password = properties.getProperty("password");
        if(password != null) return password;
        else throw new RuntimeException("Password not specified in the properties file.");
    }

}


