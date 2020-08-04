package com.cybertek.mvcthymeleaf.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Student {
    Integer id;
    String name;
    Integer age;
    Character male;
}
