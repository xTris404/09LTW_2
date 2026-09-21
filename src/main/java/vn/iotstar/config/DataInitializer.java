package vn.iotstar.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import vn.iotstar.entity.Role;
import vn.iotstar.entity.User;
import vn.iotstar.repository.RoleRepository;
import vn.iotstar.repository.UserRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(RoleRepository roleRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        return args -> {
            Role userRole = roleRepository.findByName("USER")
                    .orElseGet(() -> roleRepository.save(new Role("USER")));

            Role adminRole = roleRepository.findByName("ADMIN")
                    .orElseGet(() -> roleRepository.save(new Role("ADMIN")));

            if (userRepository.findByUsername("user01").isEmpty()) {
                User user = new User();
                user.setUsername("user01");
                user.setEmail("user01@gmail.com");
                user.setPassword(passwordEncoder.encode("123456"));
                user.setFullName("Phạm Huỳnh Thái Nhi");
                user.setImages("https://i.pravatar.cc/150?u=user01");
                user.setRole(userRole);
                user.setEnabled(true);
                userRepository.save(user);
            }

            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setEmail("admin@hcmute.edu.vn");
                admin.setPassword(passwordEncoder.encode("123456"));
                admin.setFullName("System Administrator");
                admin.setImages("https://i.pravatar.cc/150?u=admin");
                admin.setRole(adminRole);
                admin.setEnabled(true);
                userRepository.save(admin);
            }
        };
    }
}
