package propertyFileReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {

    protected Properties properties;
    protected InputStream input = ReadPropertyFile.class.getClassLoader().getResourceAsStream("data/config.properties");

    public ReadPropertyFile() throws IOException{
        properties = new Properties();
        properties.load(input);
    }

    public String getUsername(){
        return properties.getProperty("username");
    }

    public String getPassword(){
        return properties.getProperty("password");
    }

    public String getPropertiesKey(){
        return properties.getProperty("propertyKey");
    }

    public String getPropertiesValue(){
        return properties.getProperty("propertyValue");
    }

    public String getUrl(){
        return properties.getProperty("url");
    }

    public String getSearchInput(){
        return properties.getProperty("searchInput");
    }

    public String getBookSearchWord(){
        return properties.getProperty("bookSearch");
    }

    public String getBookTitle(){
        return properties.getProperty("bookTitle");
    }

    public String getBookSubtitle(){
        return properties.getProperty("bookSubtitle");
    }

    public String getBookChapter(){
        return properties.getProperty("bookChapter");
    }
}
