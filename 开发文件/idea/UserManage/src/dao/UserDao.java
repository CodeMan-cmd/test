package dao;

import bean.User;
import util.Pager;

import java.util.List;

/**
 * @author Cmonesr
 * @date Wednesday 19 Jun 2019  14:03
 */
public interface UserDao {
    List<User> listAll();

    User getById(Integer id);

    int add(User user);

    int delete(Integer id);

    int update(User user);

    int count();

    List<User> listAllLimit(Pager pager);
}
