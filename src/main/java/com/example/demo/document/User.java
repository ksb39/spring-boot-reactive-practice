package com.example.demo.document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    public static final User EMPTY = new User();

    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String website;

}
