package peaksoft.springsecurityexamwork.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.springsecurityexamwork.entity.Role;
import peaksoft.springsecurityexamwork.entity.User;
import peaksoft.springsecurityexamwork.repository.RoleRepository;
import peaksoft.springsecurityexamwork.repository.UserRepository;
import peaksoft.springsecurityexamwork.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService , UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public User findUserByFirstName(String username) {
        return userRepository.findUserByFirstName(username);
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user{} to the database",user.getFirstName());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role{} to the database",role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        log.info("Adding role {}to user {}",username,rolename);
        User user=userRepository.findUserByFirstName(username);
    Role role=roleRepository.findByName(rolename);
    user.getRoles().add(role);


    }

    @Override
    public User getUser(String username) {
        log.info("Fetting  user{}",username);
        return userRepository.findUserByFirstName(username);
    }

    @Override
    public List<User> findAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        log.info("Select user by id{}",id);
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Delete  user{} by id",id);
    userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userRepository.findUserByFirstName(username);
        if (user==null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }else {
            log.info("User found in the database:{}",username);
        }
        List<SimpleGrantedAuthority>authorities=new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getFirstName(),user.getPassword(),authorities);
    }
}
