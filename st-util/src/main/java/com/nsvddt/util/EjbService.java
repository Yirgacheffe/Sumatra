package cn.com.nsv.ejb.util;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;

public class EjbService
{
   
    
    @SuppressWarnings("unchecked")
    public <T> T getStub(String providerUrl, String earName, String ejbLocation, Class<T> ejbInterface){
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        props.setProperty(Context.PROVIDER_URL, providerUrl);
        T ei = null;
        try {
            InitialContext ctx = new InitialContext(props);
            String jndiStr = earName + "/" + ejbInterface.getSimpleName() + "Bean/" + ejbLocation;
            ei = ((T) ctx.lookup(jndiStr));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ei;
    }
    
    @SuppressWarnings("unchecked")
    public <T> T getStub(String providerUrl, String earName, String ejbLocation, Class<T> ejbInterface,String className){
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        props.setProperty(Context.PROVIDER_URL, providerUrl);
        T ei = null;
        try {
            InitialContext ctx = new InitialContext(props);
            String jndiStr = earName + "/" + className + "/" + ejbLocation;
            ei = ((T) ctx.lookup(jndiStr));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ei;
    }
    
}
