package com.mir.app.simplecloud.file.repository;

import com.mir.app.simplecloud.file.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
