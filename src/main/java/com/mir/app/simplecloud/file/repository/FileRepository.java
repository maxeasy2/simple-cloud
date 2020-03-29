package com.mir.app.simplecloud.file.repository;


import com.mir.app.simplecloud.file.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,Long> {
}
