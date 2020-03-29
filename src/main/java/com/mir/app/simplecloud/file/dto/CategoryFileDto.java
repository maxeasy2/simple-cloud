package com.mir.app.simplecloud.file.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
public class CategoryFileDto {
    private long cateNo;

    private String cateName;

    private String description;

    private String role;

    private char useYn;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private List<FileDto> fileList = new ArrayList<>();
}
