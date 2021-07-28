package kr.aaron.restdocsassistantexample.todo;

import kr.aaron.restdocs_assistant.annotation.RestDocsProperty;

import java.util.Collections;
import java.util.List;

public class TestSubResponse {
    @RestDocsProperty(description = "ds")
    private Long id;

    @RestDocsProperty()
    private String description;

    @RestDocsProperty()
    private List<TestSubSubResponse> subResponses;

    public TestSubResponse() {
    }

    public TestSubResponse(Long id, String description) {
        this.id = id;
        this.description = description;
        this.subResponses = Collections.emptyList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TestSubSubResponse> getSubResponses() {
        return subResponses;
    }

    public void setSubResponses(List<TestSubSubResponse> subResponses) {
        this.subResponses = subResponses;
    }
}
