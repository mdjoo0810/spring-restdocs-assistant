package kr.aaron.restdocsassistantexample.todo;

import kr.aaron.restdocs_assistant.annotation.RestDocsProperty;

public class TestSubSubResponse {

    @RestDocsProperty(description = "hello")
    private Long id;

    @RestDocsProperty(description = "hello", optional = true)
    private String subTitle;

    public TestSubSubResponse() {
    }

    public TestSubSubResponse(Long id, String subTitle) {
        this.id = id;
        this.subTitle = subTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
