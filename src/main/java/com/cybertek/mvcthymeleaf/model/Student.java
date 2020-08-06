package com.cybertek.mvcthymeleaf.model;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    Integer id;
    String name;
    Integer age;
    String address;
    String imgUrl;
}
