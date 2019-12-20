package service;

import bean.User;
import org.springframework.stereotype.Service;
import util.Pager;

import java.util.List;

/**
 * @author Cmonesr
 * @date Wednesday 19 Jun 2019  14:04
 */
@Service
public interface UserService {

    List<User> listAll();

    List<User> listAll(Pager pager);

    User getById(Integer id);

    int add(User user);

    int remove(Integer id);

    int modify(User user);

    int count();
}
