package bg.softuni.musicdb.service.impl;

import bg.softuni.musicdb.model.entity.UserEntity;
import bg.softuni.musicdb.model.entity.UserRoleEntity;
import bg.softuni.musicdb.model.entity.enums.UserRole;
import bg.softuni.musicdb.repository.UserRepository;
import bg.softuni.musicdb.repository.UserRoleRepository;
import bg.softuni.musicdb.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRoleRepository userRoleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public void seedUsers() {

        if(userRepository.count()==0) {

            UserRoleEntity adminRole = new UserRoleEntity().setRole(UserRole.ADMIN);
            UserRoleEntity userRole = new UserRoleEntity().setRole(UserRole.USER);


            userRoleRepository.saveAll(List.of(adminRole, userRole));

            UserEntity admin= new UserEntity().setName("admin").setPassword(passwordEncoder.encode("topsecret"));
            UserEntity user= new UserEntity().setName("user").setPassword(passwordEncoder.encode("topsecret"));

            admin.setRoles(List.of(adminRole,userRole));
            user.setRoles(List.of(userRole));
        }

    }
}
