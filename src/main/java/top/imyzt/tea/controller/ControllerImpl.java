package top.imyzt.tea.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.web.bind.annotation.*;
import top.imyzt.tea.bo.RestVO;
import top.imyzt.tea.bo.TeaPage;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Created by imyzt on 2018/11/21 15:04
 */
public abstract class ControllerImpl<PK extends Serializable, T> implements IController<PK, T> {

    @Override
    @PostMapping
    public RestVO<T> insert(T entity) {
        getServiceBean().insert(entity);
        return ok();
    }

    @Override
    @GetMapping("{id}")
    public RestVO<T> selectById(@PathVariable PK id) {
        return ok(getServiceBean().selectById(id));
    }

    @Override
    @DeleteMapping("{id}")
    public RestVO<T> deleteById(@PathVariable PK id) {
        if (getServiceBean().deleteById(id)) {
            return ok();
        }
        return fail();
    }

    @Override
    @PutMapping
    public RestVO<T> updateById(T entity) {
        if (getServiceBean().updateById(entity)) {
            return ok();
        }
        return fail();
    }

    @GetMapping("/{offset}/{limit}/{orderByField}/{isAsc}")
    final public TeaPage<T> teaPage(@PathVariable("offset") Integer offset, @PathVariable("limit") Integer limit,
                     @PathVariable(value = "orderByField", required = false) String orderByField,
                     @PathVariable(value = "isAsc", required = false) Boolean isAsc,
                     HttpServletRequest request) {
        Page<T> page = new Page<>(offset, limit, orderByField, isAsc);
        Page<T> pageResult = getServiceBean().selectPage(page, teaPageWrapper(request));
        TeaPage<T> teaPage = null;
        if (null != pageResult) {
            if (pageResult.getTotal() > 0) {
                teaPage = new TeaPage<>(pageResult.getTotal(), limit, pageResult.getRecords());
            }
        }
        return teaPage;
    }

    /**
     * 如需自定义查询条件, 请重写此方法
     */
    Wrapper<T> teaPageWrapper(HttpServletRequest request) {
        return new EntityWrapper<>();
    }
}
