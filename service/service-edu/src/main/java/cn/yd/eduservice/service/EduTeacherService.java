package cn.yd.eduservice.service;

import cn.yd.commonVo.Result;
import cn.yd.eduservice.entity.EduTeacher;
import cn.yd.eduservice.entity.vo.TeacherQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author Dong
 * @since 2022-04-12
 */
public interface EduTeacherService extends IService<EduTeacher> {
    /**
     * 条件查询分页
     * @param teacherQueryVo
     * @param page
     * @return
     */
    public Page<EduTeacher> conditionPage(TeacherQueryVo teacherQueryVo, Page<EduTeacher> page);

    Result<?> updateTeacher(EduTeacher eduTeacher);
}
