package webHelper;

import commonUtils.PropertyReader;
import model.Browser;
import model.Environement;
import org.testng.ITestContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestContext {


    public static final String ENVIRONEMNT = "environement";
    public static final String BROWSER ="browser";
    public static final String TESTNG_CONTEXT ="testngContext";

   static  HashMap<String ,Object> context = new HashMap<>();

    public  Environement getEnvironment(){
        return Environement.valueOf(getProperty(ENVIRONEMNT).toString());
    }

    //getProperty
    public  Object getProperty(String key){
        return context.get(key);
    }

    public void  setValue(String key, Object value){
        context.put(key,value);
    }

    public void setAttribute(String key, Object value){
        context.put(key,value);
    }

    public void setAttribute(ITestContext context,String key, Object value){
        setAttribute(key,getValueContext(context,key)!=null ? getValueContext(context,key) : value);
    }

    public String  getValue(String key){
        Object val = getProperty(key);
        if(val!=null) return val.toString();
        return null;
    }

    public String getValueContext(ITestContext context,String key){
        return context.getSuite().getXmlSuite().getParameter(key);
    }

    public static void loadProperty(Properties properties){
        for (Map.Entry<Object,Object> entry: properties.entrySet()) {
            context.put(entry.getKey().toString(), entry.getValue());
        }
    }
    public  void buildTestEnv(ITestContext context){
        setValue(TESTNG_CONTEXT,context);
        setAttribute(context,ENVIRONEMNT,"sit");
        switch (Environement.valueOf(getValue(ENVIRONEMNT))){
            case QA:
                loadProperty(PropertyReader.readProperty(getValue(ENVIRONEMNT).toString()+".properties"));
                break;
        }

        setAttribute(context,BROWSER, Browser.CHROME);
    }

    @Override
    public String toString(){
        return context.toString();
    }
}
