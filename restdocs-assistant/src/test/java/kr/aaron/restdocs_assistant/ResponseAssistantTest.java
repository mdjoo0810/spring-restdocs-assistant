package kr.aaron.restdocs_assistant;

import org.junit.jupiter.api.Test;
import org.springframework.restdocs.payload.JsonFieldType;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ResponseAssistantTest {
    static class TestClass {
        private Long id;
        private String content;
    }

    void getResponseFieldsByClass() {

    }

    @Test
    void getFieldsByClass() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field[] declaredFields = TestClass.class.getDeclaredFields();

        Method method = TestUtils.getPrivateMethod(ResponseAssistant.class, "getFieldsByClass");

        Field[] fieldsByClass = (Field[]) method.invoke(ResponseAssistant.class, TestClass.class);

        assertEquals(declaredFields.length, fieldsByClass.length);

    }

    void getRestDocsPropertyByField() {

    }

    @Test
    void collectionClassCheck() {
        int[] arr = {};
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        assertTrue(arr.getClass().isArray());
        assertTrue(Collection.class.isAssignableFrom(list.getClass()));
        assertTrue(Collection.class.isAssignableFrom(set.getClass()));
    }

//    @Test
//    void getTypeByClass() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Field[] declaredFields = TestClass.class.getDeclaredFields();
//
//        if (declaredFields.length <= 0) {
//            throw new IllegalArgumentException("class not declared");
//        }
//
//        Method method = TestUtils.getPrivateMethod(ResponseAssistant.class, "getTypeByClass");
//
//        JsonFieldType invoke = (JsonFieldType) method.invoke(ResponseAssistant.class, declaredFields[0].getType());
//
//        assertEquals(invoke, JsonFieldType.NUMBER);
//    }

}