package com.example.demo.controller.view;

import com.example.demo.document.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private static final ParameterizedTypeReference<List<User>> postsListType =
            new ParameterizedTypeReference<List<User>>() {};

    @GetMapping
    public String getList(Model model) {
        Mono<List<User>> posts = WebClient.create("https://jsonplaceholder.typicode.com")
                .get()
                .uri("/users")
                .retrieve()
                .bodyToMono(postsListType)
                .onErrorReturn(Collections.emptyList());

        model.addAttribute("user", posts);
        return "/users/list";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        Mono<User> post = WebClient.create("https://jsonplaceholder.typicode.com")
                .get()
                .uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(User.class)
                .onErrorReturn(User.EMPTY);

        model.addAttribute("user", post);
        return "/users/detail";
    }

}
