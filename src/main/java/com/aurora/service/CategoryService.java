package com.aurora.service;

import com.aurora.entity.Category;
import com.aurora.model.dto.CategoryAdminDTO;
import com.aurora.model.dto.CategoryDTO;
import com.aurora.model.dto.CategoryOptionDTO;
import com.aurora.model.dto.PageResultDTO;
import com.aurora.model.vo.CategoryVO;
import com.aurora.model.vo.ConditionVO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> listCategories();

    PageResultDTO<CategoryAdminDTO> listCategoriesAdmin(ConditionVO conditionVO);

    List<CategoryOptionDTO> ListCategoriesBySearch(ConditionVO conditionVO);

    void deleteCategories(List<Integer> categoryIds);

    void saveOrUpdateCategory(CategoryVO categoryVO);
}
