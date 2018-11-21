package top.imyzt.tea.controller;

import com.baomidou.mybatisplus.service.IService;
import org.springframework.http.HttpStatus;
import top.imyzt.tea.bo.RestVO;
import top.imyzt.tea.bo.TeaPage;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Created by imyzt on 2018/11/21 14:54
 * <PK> 主键泛型
 * <T> 实体泛型
 * <S> Service Bean 泛型
 */
public interface IController<PK extends Serializable, T, S extends IService<T>> {

    default RestVO<T> ok() {
        return new RestVO<T>().setCode(HttpStatus.OK.value()).setMsg("操作成功");
    }

    default RestVO<T> ok(String msg) {
        return new RestVO<T>().setCode(HttpStatus.OK.value()).setMsg(msg);
    }

    default RestVO<T> ok(T data) {
        return new RestVO<T>().setCode(HttpStatus.OK.value()).setData(data);
    }

    default RestVO<T> fail() {
        return new RestVO<T>().setCode(2).setMsg("操作失败");
    }

    RestVO<T> insert(T entity);

    RestVO<T> selectById(PK id);

    RestVO<T> deleteById(PK id);

    RestVO<T> updateById(T entity);

    /**
     * 自带分页查询
     * @param offset 偏移量
     * @param limit 每页显示的条数
     * @param orderByField 排序字段
     * @param isAsc 顺序
     */
    TeaPage<T> teaPage(Integer offset, Integer limit, String orderByField, Boolean isAsc, HttpServletRequest request);
}
