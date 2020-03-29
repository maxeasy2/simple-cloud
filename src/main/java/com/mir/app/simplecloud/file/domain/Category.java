package com.mir.app.simplecloud.file.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter @Getter
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cateNo;

    private String cateName;

    @Column(length = 4000)
    private String description;

    private String role;

    @Column(length = 1)
    private char useYn;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    @OneToMany(mappedBy = "category")
    private List<File> fileList = new ArrayList<>();
}
