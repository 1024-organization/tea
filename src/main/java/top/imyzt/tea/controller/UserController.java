package top.imyzt.tea.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.imyzt.tea.entity.User;
import top.imyzt.tea.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by imyzt on 2018/11/21 15:04
 */
@RestController
@RequestMapping("user")
public class UserController extends ControllerImpl<Integer, User, UserService> {

    @Override
    Wrapper<User> teaPageWrapper(HttpServletRequest request) {
        EntityWrapper<User> ew = new EntityWrapper<>();
        String name = request.getParameter("name");
        ew.gt("age", 10);
        return ew;
    }
}
