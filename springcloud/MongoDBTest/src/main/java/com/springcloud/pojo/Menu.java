package com.springcloud.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
@Document(collection = "menu")
public class Menu {
    @Id
    private String id;
    @Field("id")
    private int menuId;
    @Field("menuCode")
    private String menucode;
    @Field("menuName")
    private String menuname;
    @Field("menuLevel")
    private int menulevel;
    @Field("menuParentCode")
    private String menuparentcode;
    @Field("menuClick")
    private String menuclick;
    @Field("menuRight")
    private String menuright;
    @Field("menuComponent")
    private String menucomponent;
    @Field("menuIcon")
    private String menuicon;

    // Getter and Setter methods
}
