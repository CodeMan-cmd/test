package service.impl;

import bean.User;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;
import util.Pager;

import java.util.List;

/**
 * @author Cmonesr
 * @date Wednesday 19 Jun 2019  14:32
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listAll() {
        return userDao.listAll();
    }

    @Override
    public List<User> listAll(Pager pager) {
        return userDao.listAllLimit(pager);
    }

    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
    }

    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public int remove(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public int modify(User user) {
        return userDao.update(user);
    }

    @Override
    public int count() {
        return userDao.count();
    }
}
