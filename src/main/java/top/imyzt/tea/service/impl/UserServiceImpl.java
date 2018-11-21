package top.imyzt.tea.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.imyzt.tea.dao.UserMapper;
import top.imyzt.tea.entity.User;
import top.imyzt.tea.service.UserService;

/**
 * Created by imyzt on 2018/11/21 15:05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
