package com.atguigu.guli.service.edu.service.impl;

import com.atguigu.guli.service.edu.entity.Teacher;
import com.atguigu.guli.service.edu.entity.from.SearchForm;
import com.atguigu.guli.service.edu.mapper.TeacherMapper;
import com.atguigu.guli.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2020-11-10
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {


    @Override
    public Page<Teacher> pageByCondition(SearchForm searchForm, Integer pageNum, Integer size) {
        Page<Teacher> page = new Page<>(pageNum, size);
        if (searchForm == null) {
            //查询所有数据的分页数据

            page = baseMapper.selectPage(page, null);
            return page;
        }
        String joinDateBegin = searchForm.getJoinDateBegin();
        String joinDateEnd = searchForm.getJoinDateEnd();
        Integer level = searchForm.getLevel();
        String name = searchForm.getName();
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.likeRight("name", name);
        }
        if (level != null) {
            queryWrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(joinDateBegin)) {
            queryWrapper.ge("join_date", joinDateBegin);
        }
        if (!StringUtils.isEmpty(joinDateEnd)) {
            queryWrapper.le("join_date", joinDateEnd);

        }

        page = baseMapper.selectPage(page, queryWrapper);
        return page;
    }
}
