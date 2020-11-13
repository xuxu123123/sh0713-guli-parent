package com.atguigu.guli.service.edu.service;

import com.atguigu.guli.service.edu.entity.Teacher;
import com.atguigu.guli.service.edu.entity.from.SearchForm;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author atguigu
 * @since 2020-11-10
 */
public interface TeacherService extends IService<Teacher> {

    Page<Teacher> pageByCondition(SearchForm searchForm, Integer pageNum, Integer size);
}
