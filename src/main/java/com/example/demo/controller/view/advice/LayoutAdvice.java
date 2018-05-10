package com.example.demo.controller.view.advice;

import com.samskivert.mustache.Mustache;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class LayoutAdvice {

    @ModelAttribute("doubled")
    public Mustache.Lambda doubled() {
        return (frag, out) -> {
            String bodyString = frag.execute();
            out.append(bodyString)
                    .append(bodyString);
        };
    }

}
