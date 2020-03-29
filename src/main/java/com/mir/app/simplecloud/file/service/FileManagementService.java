package com.mir.app.simplecloud.file.service;

import com.mir.app.simplecloud.file.domain.Category;
import com.mir.app.simplecloud.file.domain.File;
import com.mir.app.simplecloud.file.dto.CategoryDto;
import com.mir.app.simplecloud.file.dto.CategoryFileDto;
import com.mir.app.simplecloud.file.dto.FileDto;
import com.mir.app.simplecloud.file.repository.CategoryRepository;
import com.mir.app.simplecloud.file.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FileManagementService {

    private final FileRepository fileRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public Optional<CategoryFileDto> getCategoryFileList(long cateNo) {
        return categoryRepository.findById(cateNo)
                .map(category -> modelMapper.map(category, CategoryFileDto.class));
    }

    @Transactional
    public boolean saveCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        Category result = categoryRepository.save(category);
        return Objects.nonNull(result);
    }

    @Transactional
    public boolean saveFile(FileDto fileDto) {
        File file = modelMapper.map(fileDto, File.class);
        File result = fileRepository.save(file);
        return Objects.nonNull(result);
    }

    @Transactional
    public List<CategoryDto> getCategoryList() {
        return categoryRepository
                .findAll()
                .stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }
}
