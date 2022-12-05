package com.aurora.service.impl;

import com.aurora.entity.Category;
import com.aurora.mapper.CategoryMapper;
import com.aurora.model.dto.CategoryAdminDTO;
import com.aurora.model.dto.CategoryDTO;
import com.aurora.model.dto.CategoryOptionDTO;
import com.aurora.model.dto.PageResultDTO;
import com.aurora.model.vo.CategoryVO;
import com.aurora.model.vo.ConditionVO;
import com.aurora.service.CategoryService;
import com.aurora.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements  CategoryService {

    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> listCategories() {
        return categoryMapper.listCategories();
    }

    @SneakyThrows
    @Override
    public PageResultDTO<CategoryAdminDTO> listCategoriesAdmin(ConditionVO conditionVO) {
        Long count = categoryMapper.selectCount(
                new LambdaQueryWrapper<Category>()
                        .like(StringUtils.isNotBlank(conditionVO.getKeywords()), Category::getCategoryName, conditionVO.getKeywords()));
        if(count == 0 ) {
            return new PageResultDTO<>();
        }

        List<CategoryAdminDTO> categoryList = categoryMapper.listCategoriesAdmin(PageUtil.getLimitCurrent(), PageUtil.getSize(), conditionVO);

        return new PageResultDTO<>(categoryList, count);
    }

    @Override
    public List<CategoryOptionDTO> ListCategoriesBySearch(ConditionVO conditionVO) {
        return null;
    }

    @Override
    public void deleteCategories(List<Integer> categoryIds) {

    }

    @Override
    public void saveOrUpdateCategory(CategoryVO categoryVO) {

    }
}
