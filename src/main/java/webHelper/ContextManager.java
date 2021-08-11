package webHelper;

import org.testng.ITestContext;
import org.testng.xml.XmlTest;

import java.util.HashMap;
import java.util.Map;

public class ContextManager {

    public static TestContext globalCOntext=  new TestContext();
    public static ThreadLocal<TestContext> thread = new ThreadLocal<>();
    public static Map<XmlTest, TestContext> context = new HashMap<>();

    public static void intiateGlobalContext(ITestContext context){
        globalCOntext.buildTestEnv(context);
    }



}
