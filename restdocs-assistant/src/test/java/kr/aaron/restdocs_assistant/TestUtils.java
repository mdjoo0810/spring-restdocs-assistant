package kr.aaron.restdocs_assistant;

import java.lang.reflect.Method;

public class TestUtils {

    public static Method getPrivateMethod(Class<?> primaryClass, String methodName) throws NoSuchMethodException {
        Method method = primaryClass.getDeclaredMethod(methodName, Class.class);
        method.setAccessible(true);

        return method;
    }

}
