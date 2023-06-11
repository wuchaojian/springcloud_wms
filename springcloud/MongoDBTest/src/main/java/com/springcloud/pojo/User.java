package com.springcloud.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "user")
public class User {
    @Id
    private String id;
    @Field("id")
    private int userId;
    private String no;
    private String name;
    private String password;
    private int age;
    private int sex;
    private String phone;
    @Field("role_id")
    private int roleId;
    @Field("isValid")
    private String isValid;

    // Getter and Setter methods
}
