package kr.aaron.restdocs_assistant;

import kr.aaron.restdocs_assistant.annotation.RestDocsProperty;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.ResponseFieldsSnippet;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

public class ResponseAssistant {

    private String pkgName;

    public ResponseAssistant(String pkgName) {
        this.pkgName = pkgName;
    }

    public ResponseFieldsSnippet getResponseFieldsByClass(Class<?> primarySource) {
        Field[] fieldsByClass = getFieldsByClass(primarySource);

        List<FieldDescriptor> collect = getDescriptorList(fieldsByClass, null);
        System.out.println("========================");
        for(FieldDescriptor col: collect) {
            System.out.println(col.getPath());
        }
        return responseFields(collect);
    }

    private List<FieldDescriptor> getDescriptorList(Field[] fieldsByClass, String subFieldName) {
        List<FieldDescriptor> descriptorList = new ArrayList<>();

        Arrays.stream(fieldsByClass)
                .forEach(field -> {
                    boolean isArr = checkTypeArrayOrCollection(field.getType());

                    System.out.println(field.getType().getName());

                    if (field.getType().getName().contains(pkgName)) {
                        Field[] subFields = getFieldsByClass(field.getType());

                        FieldDescriptor fieldDescriptor = getFieldDescriptor(field, subFieldName);
                        descriptorList.add(fieldDescriptor);

                        List<FieldDescriptor> subList = getDescriptorList(subFields, fieldDescriptor.getPath());
                        descriptorList.addAll(subList);

                        return;
                    }

                    if (isArr) {
                        ParameterizedType genericType = (ParameterizedType) field.getGenericType();
                        Class<?> actualTypeArgument = (Class<?>) genericType.getActualTypeArguments()[0];
//                        System.out.println("===== is Array ====" + actualTypeArgument);
                        Field[] subFields = getFieldsByClass(actualTypeArgument);
//                        System.out.println("===== is subFieldName ====" + subFieldName);
                        FieldDescriptor fieldDescriptor = getFieldDescriptor(field, subFieldName);
                        descriptorList.add(fieldDescriptor);

                        List<FieldDescriptor> subList = getDescriptorList(subFields, fieldDescriptor.getPath());
                        descriptorList.addAll(subList);

                        return;
                    }

                    FieldDescriptor fieldDescriptor = getFieldDescriptor(field, subFieldName);
                    descriptorList.add(fieldDescriptor); });

        return descriptorList;
    }

    private Field[] getFieldsByClass(Class<?> primarySource) {
        return primarySource.getDeclaredFields();
    }

    private FieldDescriptor getFieldDescriptor(Field field, String subFieldName) {
        boolean isArr = checkTypeArrayOrCollection(field.getType());

        String path;

        if (isArr) {
            path = subFieldName != null ? subFieldName + "." + field.getName() + "[]": field.getName() + "[]";
        } else {
            path = subFieldName != null ? subFieldName + "." + field.getName() : field.getName();
        }

        FieldDescriptor fieldDescriptor = fieldWithPath(path);

        RestDocsProperty annotation = getRestDocsPropertyByField(field);
        fieldDescriptor.type(getTypeByClass(field.getType())); // TODO: JsonFieldType 으로 형변환하면 좋을꺼같아요.
        fieldDescriptor.description(annotation.description());

        if (annotation.optional() || subFieldName != null) {
            fieldDescriptor.optional();
        }

        return fieldDescriptor;
    }

    private boolean checkTypeArrayOrCollection(Class<?> type) {
        return type.isArray() || Collection.class.isAssignableFrom(type);
    }

    private RestDocsProperty getRestDocsPropertyByField(Field field) {
        RestDocsProperty annotation = field.getAnnotation(RestDocsProperty.class);

        if (annotation == null) throw new IllegalArgumentException("The class has no annotations. [" + field.getType().getName() + "]");

        return annotation;
    }

    private String getTypeByClass(Class<?> type) {
        return type.getSimpleName();
    }

}
