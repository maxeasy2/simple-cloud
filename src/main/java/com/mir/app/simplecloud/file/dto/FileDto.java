package com.mir.app.simplecloud.file.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class FileDto {
    private long fileNo;

    private CategoryDto category;

    private String title;

    private String content;

    private String fileType;

    private String fileUrl;

    private String filePath;

    private int fileSize;

    private char useYn;

    private LocalDateTime regDate;

    private LocalDateTime modDate;
}
