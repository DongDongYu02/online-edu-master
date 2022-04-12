package cn.yd.eduservice.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.yd.commonVo.Result;
import cn.yd.eduservice.entity.EduTeacher;
import cn.yd.eduservice.entity.vo.TeacherQueryVo;
import cn.yd.eduservice.mapper.EduTeacherMapper;
import cn.yd.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author Dong
 * @since 2022-04-12
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {
    public Page<EduTeacher> conditionPage(TeacherQueryVo teacherQueryVo, Page<EduTeacher> page) {
        QueryWrapper<EduTeacher> eduTeacherQueryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(teacherQueryVo.getName())) {
            eduTeacherQueryWrapper.like("name", teacherQueryVo.getName());
        }
        if (!StrUtil.isEmptyIfStr(teacherQueryVo.getLevel())) {
            eduTeacherQueryWrapper.eq("level", teacherQueryVo.getLevel());
        }
        if (!StrUtil.isBlankIfStr(teacherQueryVo.getBeginCreateTime())) {
            eduTeacherQueryWrapper.ge("gmt_create", teacherQueryVo.getBeginCreateTime());
        }
        if (!StrUtil.isBlankIfStr(teacherQueryVo.getEndCreateTime())) {
            eduTeacherQueryWrapper.le("gmt_create", teacherQueryVo.getEndCreateTime());
        }
        return this.page(page, eduTeacherQueryWrapper);
    }

    @Override
    public Result<?> updateTeacher(EduTeacher eduTeacher) {
        EduTeacher teacher = this.getById(eduTeacher.getId());

        if (ObjectUtil.isEmpty(teacher)) {
            return Result.error("修改失败：讲师不存在");
        }
        return Result.OK("修改成功",this.updateById(eduTeacher));
    }
}
