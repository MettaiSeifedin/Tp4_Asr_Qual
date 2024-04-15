package Exo1;

import Exo1.User;
import Exo1.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    // Constructeur prenant le UserRepository en paramètre
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Méthode pour récupérer un utilisateur par son ID
    public User getUserById(long id) {
        return userRepository.findUserById(id);
    }
}
