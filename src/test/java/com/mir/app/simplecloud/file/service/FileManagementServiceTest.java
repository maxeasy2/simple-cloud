package com.mir.app.simplecloud.file.service;

import com.mir.app.simplecloud.file.dto.CategoryDto;
import com.mir.app.simplecloud.file.dto.CategoryFileDto;
import com.mir.app.simplecloud.file.dto.FileDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("production")
@Slf4j
@SpringBootTest
class FileManagementServiceTest {

    @Autowired
    private FileManagementService fileManagementService;
    private static long cateNo;
    private static LocalDateTime localDateTime;

    @BeforeAll
    static void setup() {
        cateNo = 1L;
        localDateTime = LocalDateTime.now();
    }

    @Test
    void getCategoryFileList() throws Exception{
        Optional<CategoryFileDto> optionalCategoryFileDto = fileManagementService.getCategoryFileList(cateNo);

        assertFalse(optionalCategoryFileDto.isEmpty());

        CategoryFileDto categoryFileDto = optionalCategoryFileDto.get();
        long rtCateNo = categoryFileDto.getCateNo();

        assertThat(rtCateNo, is(cateNo));
        log.info(categoryFileDto.toString());
    }

    @Test
    void saveCategory() throws Exception {
        CategoryDto categoryDto = getCategoryDto();
        assertTrue(fileManagementService.saveCategory(categoryDto));
    }

    private CategoryDto getCategoryDto() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCateName("test category_"+ localDateTime);
        categoryDto.setDescription("test");
        categoryDto.setModDate(localDateTime);
        categoryDto.setRegDate(localDateTime);
        categoryDto.setRole("none");
        categoryDto.setUseYn('Y');
        return categoryDto;
    }


    @Test
    void saveFile() throws Exception {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCateNo(1L);

        FileDto fileDto = new FileDto();
        fileDto.setCategory(categoryDto);
        fileDto.setFilePath("/test/path");
        fileDto.setTitle("test File "+localDateTime);
        fileDto.setContent("test");
        fileDto.setUseYn('Y');
        fileDto.setModDate(localDateTime);
        fileDto.setRegDate(localDateTime);

        boolean result = fileManagementService.saveFile(fileDto);

        assertTrue(result);
    }

    @Test
    void getCategoryList() {
        List<CategoryDto> categoryList = fileManagementService.getCategoryList();
        assertNotNull(categoryList);

        for (CategoryDto categoryDto : categoryList) {
            log.info(categoryDto.toString());
        }
    }
}