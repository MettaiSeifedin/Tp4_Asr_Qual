package Exo1;

import Exo1.User;

public interface UserRepository {
    User findUserById(long id);
}
