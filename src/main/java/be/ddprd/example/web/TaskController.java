package be.ddprd.example.web;

import java.util.List;
import java.util.stream.Collectors;

import org.flowable.engine.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping("/all")
	public List<String> getTasks() {
		return taskService.createTaskQuery().active().list()
				.stream()
				.map((t) -> t.getId())
				.collect(Collectors.toList());
	}

}
