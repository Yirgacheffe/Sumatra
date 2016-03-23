package cn.com.nsv.ejb.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader extends Properties
{

    private static final long serialVersionUID = 1L;

    private PropertiesReader(String path)
    {
        String temp = "";
        
            if (!"/".equals(path.substring(0, 1)))
            {
                temp = "/META-INF/" + path;
            }else{
            	temp = "/META-INF" + path;
            }
        try
        {
            InputStream is = getClass().getClassLoader().getResourceAsStream(temp);
            load(is);
        }
        catch (IOException e)
        {
            throw new RuntimeException();
        }
    }

    public static PropertiesReader getReader(String path)
    {
        return new PropertiesReader(path);
    }
}