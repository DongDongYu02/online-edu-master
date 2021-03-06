package cn.yd.eduservice.controller;

import cn.yd.commonVo.Result;
import cn.yd.eduservice.entity.EduTeacher;
import cn.yd.eduservice.entity.vo.TeacherQueryVo;
import cn.yd.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Dong
 * @since 2022-04-12
 */
@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    /**
     * 获取讲师信息列表
     *
     * @return
     */
    @GetMapping("/list")
    private Result<?> teacherList() {
        return Result.OK(eduTeacherService.list());
    }

    /**
     * 分页获取讲师信息列表
     *
     * @return
     */
    @PostMapping("/pageList")
    public Result<?> teacherPageList(@RequestParam(value = "pageNum", required = true) Integer pageNum,
                                     @RequestParam(value = "pageSize", required = true) Integer pageSize,
                                     @RequestBody TeacherQueryVo teacherQueryVo) {
        Page<EduTeacher> page = new Page<>(pageNum, pageSize);
        return Result.OK(eduTeacherService.conditionPage(teacherQueryVo, page));
    }

    /**
     * 获取讲师信息
     * @param id 讲师id
     * @return
     */
    @GetMapping("{id}")
    public Result<?> getTeacher(@PathVariable String id){
        EduTeacher teacher = eduTeacherService.getById(id);
        return Result.OK(teacher);
    }
    /**
     * 删除讲师
     *
     * @param id 讲师id
     * @return
     */
    @DeleteMapping("{id}")
    public Result<?> deleteTeacher(@PathVariable String id) {
        eduTeacherService.removeById(id);
        return Result.OK("删除成功");
    }

    /**
     * 添加讲师
     * @param teacher
     * @return
     */
    @PostMapping("saveTeacher")
    public Result<?> saveTeacher(@RequestBody EduTeacher teacher){
        eduTeacherService.save(teacher);
        return Result.OK("添加成功");

    }

    /**
     * 修改讲师
     * @param eduTeacher
     * @return
     */
    @PutMapping("editTeacher")
    private Result<?> editTeacher(@RequestBody EduTeacher eduTeacher){
        return eduTeacherService.updateTeacher(eduTeacher);
    }
}

