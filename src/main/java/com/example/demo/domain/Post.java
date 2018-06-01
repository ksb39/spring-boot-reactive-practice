package com.example.demo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper=false)
@Document(collection = "post")
public class Post extends BaseEntity {

    @TextIndexed
    private String title;

    private String content;

    @Indexed
    private String author;

}
