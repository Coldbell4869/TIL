package my.examples.springjdbc.service;

import my.examples.springjdbc.dto.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public List<User> getUsers(int page);
    public User getUserByEmail(String email);
}
