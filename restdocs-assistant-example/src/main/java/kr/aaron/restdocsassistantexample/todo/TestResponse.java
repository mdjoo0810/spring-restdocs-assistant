package kr.aaron.restdocsassistantexample.todo;

import kr.aaron.restdocs_assistant.annotation.RestDocsProperty;

import java.util.List;

public class TestResponse {

    @RestDocsProperty(description = "list")
    private Long id;
    @RestDocsProperty(description = "list")
    private String content;

    @RestDocsProperty(description = "sub")
    private TestSubResponse sub;

    @RestDocsProperty(description = "list")
    private List<TestSubResponse> subList;

    public TestResponse() {
    }

    public TestResponse(Long id, String content, List<TestSubResponse> subList) {
        this.id = id;
        this.content = content;
        this.sub = new TestSubResponse(1L, "asd ");
        this.subList = subList;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public List<TestSubResponse> getSubList() {
        return subList;
    }

    public TestSubResponse getSub() {
        return sub;
    }
}
