package com.example.backend.ServicesProduction;

import com.example.backend.Entity.ERole;
import com.example.backend.Entity.Role;
import com.example.backend.Entity.Socket;
import com.example.backend.Entity.User;
import com.example.backend.repositoryProduction.RoleRepository;
import com.example.backend.repositoryProduction.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceUsers {
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;

    public List<User> getAll() { return userRepository.findAll() ; } ;
    public User save (User user ) {
       String p= encoder.encode(user.getPassword());
        user.setPassword(p);
        return userRepository.save(user) ; }
    public User update (User user ) {return userRepository.save(user) ; }
    public User findByid(Long id)
    {
        return userRepository.findById(id).get();
    }

    public void Delete(Long id)
    {
        User user = findByid(id);
        userRepository.delete(user);
    }

    public Optional<User> getOne(Long id)
    {
        return userRepository.findById(id);
    }

    public User updateUser(Long userId , User userRequest){
        User existingUser = userRepository.findById(userId).get();

        existingUser.setMatricule(userRequest.getMatricule());
        existingUser.setUsername(userRequest.getUsername());
        existingUser.setEmail(userRequest.getEmail());
        existingUser.setPassword(userRequest.getPassword());
        return userRepository.save(existingUser);


    }
    public void addRoleToUser(String username, String roleName) {
      //  log.info("Adding role {} to user {}", roleName, username);
        User user = userRepository.findByUsername(username).get();
        Role role = roleRepository.findByName(roleName).get();
        user.getRoles().add(role);
        Collections.reverse((List<?>) user.getRoles());
    }

}
