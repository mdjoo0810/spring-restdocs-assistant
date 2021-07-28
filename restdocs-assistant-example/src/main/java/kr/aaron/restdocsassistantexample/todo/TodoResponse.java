package kr.aaron.restdocsassistantexample.todo;

import kr.aaron.restdocs_assistant.annotation.RestDocsProperty;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TodoResponse {

    @RestDocsProperty(description = "Hello")
    private Long id;

    @RestDocsProperty(description = "Hello")
    private String content;

    @RestDocsProperty(description = "Hello")
    private String description;

    @RestDocsProperty(description = "Hello")
    private boolean done;

    @RestDocsProperty(description = "Hello")
    private LocalDateTime createdAt;

    @RestDocsProperty(description = "list")
    private List<TestResponse> testList;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.content = todo.getContent();
        this.description = todo.getDescription();
        this.done = todo.isDone();
        this.createdAt = todo.getCreatedAt();
        this.testList = Collections.singletonList(
                new TestResponse(1L, "test",
                        Collections.singletonList(
                                new TestSubResponse(1L, "asd"))));
    }

    public TodoResponse() {
    }

    public TodoResponse(Long id, String content, boolean done, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.done = done;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public boolean isDone() {
        return done;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

    public List<TestResponse> getTestList() {
        return testList;
    }
}
