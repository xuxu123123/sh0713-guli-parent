package com.atguigu.guli.service.edu.controller.admin;


import com.atguigu.guli.service.base.result.R;
import com.atguigu.guli.service.edu.entity.Teacher;
import com.atguigu.guli.service.edu.entity.from.SearchForm;
import com.atguigu.guli.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2020-11-10
 */
@Slf4j
@Api(tags = "讲师管理模块")
@RestController
@RequestMapping("/admin/edu/teacher")
public class AdminTeacherController {
    @Autowired
    TeacherService teacherService;

    //查询所有讲师
    @ApiOperation("查询所有讲师")
    @GetMapping("list")
    public R list() {
        List<Teacher> list = teacherService.list();
        return R.ok().data("items", list);
    }

    @ApiOperation("删除指定讲师")
    //删除指定id讲师
    @DeleteMapping("remove/{id}")
    public R removeById(@ApiParam(required = true, value = "讲师id") @PathVariable("id") String id) {
        boolean b = teacherService.removeById(id);
        if (b) {
            return R.ok();
        } else {
            return R.error();
        }
    }
    //更新
    @ApiOperation("更新讲师")
    @PutMapping("update")
    public R update(@RequestBody Teacher teacher) {
        boolean b = teacherService.updateById(teacher);
        if (b) {
            return R.ok().message("更新成功");
        } else {
            return R.error().message("更新失败");
        }
    }
    //分页查询

    //待条件的分页查询
    @ApiOperation("带条件查询讲师分页数据")
    @GetMapping("list/{pageNum}/{size}")
    public R listPage(@ApiParam("查询条件对象") SearchForm searchForm,
                      @ApiParam("页码") @PathVariable("pageNum") Integer pageNum,
                      @ApiParam("每页记录条数") @PathVariable("size") Integer size) {
        Page<Teacher> page = teacherService.pageByCondition(searchForm, pageNum, size);
        return R.ok().data("pate", page);
    }

    //新增
    @ApiOperation("新增讲师")
    @PostMapping("save")
    public R save(@RequestBody Teacher teacher) {
        log.error("接收到的teacher对象：{}",teacher);
        boolean b = teacherService.save(teacher);

        if (b) {
            return R.ok().message("新增成功");
        } else {
            return R.error().message("新增失败");
        }
    }
}
