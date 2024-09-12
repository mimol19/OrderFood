package pl.orderfood.infrastructure.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderFoodUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getAuthorities())
                .accountLocked(!user.isAccountNonLocked())
                .accountExpired(!user.isAccountNonExpired())
                .credentialsExpired(!user.isCredentialsNonExpired())
                .disabled(!user.isEnabled())
                .build();

    }

    @Transactional
    public UserEntity saveUser(UserEntity user, String roleName) {
        RoleEntity role = roleRepository.findByRole(roleName);  // Znajdź rolę po nazwie
        if (role == null) {
            throw new IllegalArgumentException("Invalid role: " + roleName);
        }

        user.setRoleEntity(role);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        return userRepository.save(user);
    }


//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        UserEntity user = userRepository.findByUserName(userName);
//        return buildUserForAuthentication(user, authorities);
//    }
//
//    private List<GrantedAuthority> getUserAuthority(Set<RoleEntity> userRoles) {
//        return userRoles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getRole()))
//                .distinct()
//                .collect(Collectors.toList());
//    }
//
//    private UserDetails buildUserForAuthentication(UserEntity user, List<GrantedAuthority> authorities) {
//        return new User(
//                user.getUserName(),
//                user.getPassword(),
//                user.getActive(),
//                true,
//                true,
//                true,
//                authorities
//        );
//    }
}

