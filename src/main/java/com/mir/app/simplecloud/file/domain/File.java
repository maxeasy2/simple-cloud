package com.mir.app.simplecloud.file.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter @Getter
public class File {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fileNo;

    @ManyToOne
    @JoinColumn(name = "cateNo")
    private Category category;

    @Column(length = 500)
    private String title;

    @Column(length = 4000)
    private String content;

    private String fileType;

    @Column(length = 500)
    private String fileUrl;

    @Column(length = 500)
    private String filePath;

    private int fileSize;

    @Column(length = 1)
    private char useYn;

    private LocalDateTime regDate;

    private LocalDateTime modDate;
}
