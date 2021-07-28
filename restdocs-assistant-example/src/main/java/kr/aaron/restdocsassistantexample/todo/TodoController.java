package kr.aaron.restdocsassistantexample.todo;

import kr.aaron.restdocs_assistant.Assistant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController()
public class TodoController {

    @GetMapping()
    public TodoResponse findOne() {
        Todo todo = new Todo();

        todo.setId(1L);
        todo.setContent(Assistant.getVersion());
        todo.setDone(false);
        todo.setCreatedAt(LocalDateTime.now());

        return new TodoResponse(todo);
    }

}
