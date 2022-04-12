package cn.yd.eduservice.controller;
import cn.yd.commonVo.Result;
import cn.yd.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    @GetMapping("/list")
    public Result<?> teacherList() {
        return Result.OK(eduTeacherService.list(null));
    }

    @DeleteMapping("{id}")
    public Result<?> deleteTeacher(@PathVariable String id){
         eduTeacherService.removeById(id);
         return Result.OK("删除成功");
    }
}

