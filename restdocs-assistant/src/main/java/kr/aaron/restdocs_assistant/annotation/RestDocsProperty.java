package kr.aaron.restdocs_assistant.annotation;

import org.springframework.restdocs.payload.JsonFieldType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Rest Docs에 사용할 Class에 Field에 적용함.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RestDocsProperty {

    /**
     *  문서에 optional 여부
     */
    boolean optional() default false;

    /**
     *  문서에 설명
     */
    String description() default "";

}
