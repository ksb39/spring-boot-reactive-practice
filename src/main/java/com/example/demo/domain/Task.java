package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task implements Serializable {

    private static final long serialVersionUID = 9199848247320081613L;

    public Task(String head, String body) {
        this.head = head;
        this.body = body;
    }

    @Id
    private String id;
    private String head;
    private String body;

}
