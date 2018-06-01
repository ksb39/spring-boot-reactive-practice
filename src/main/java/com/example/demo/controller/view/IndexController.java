package com.example.demo.controller.view;

import com.example.demo.domain.Post;
import com.example.demo.domain.Task;
import com.example.demo.service.PostService;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;

@Controller
public class IndexController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        taskService.create(new Task("post", "read"));

        Flux<Post> postFlux = postService.findAll();
        Iterable<Task> taskIterable = taskService.read();
        model.addAttribute("postList", postFlux.collectList().block());
        model.addAttribute("taskList", taskIterable);
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@RequestParam (value="title") String title,
                       @RequestParam(value="content") String content,
                       @RequestParam (value="author") String author) {
        taskService.create(new Task("post", "create"));

        postService.create(new Post(title, content, author));
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestParam (value="id") String id,
                         @RequestParam (value="title") String title,
                         @RequestParam(value="content") String content,
                         @RequestParam (value="author") String author) {
        taskService.create(new Task("post", "update"));

        postService.update(new Post(title, content, author), id);
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String delete(@RequestParam (value="id") String id) {
        taskService.create(new Task("post", "delete"));

        postService.delete(id);
        return "redirect:/";
    }

}
