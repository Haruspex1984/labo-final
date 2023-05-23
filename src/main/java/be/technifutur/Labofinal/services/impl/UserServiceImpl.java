package be.technifutur.Labofinal.services.impl;

import be.technifutur.Labofinal.models.DTO.UserDTO;
import be.technifutur.Labofinal.models.entities.User;
import be.technifutur.Labofinal.models.forms.UserForm;
import be.technifutur.Labofinal.repositories.UserRepository;
import be.technifutur.Labofinal.services.UserService;
import be.technifutur.Labofinal.utils.JWTProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTProvider jwtProvider;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JWTProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }


    @Override
    public UserDTO updateUser(String username, UserForm form, HttpServletRequest request) throws Exception {
        String token = jwtProvider.extractToken(request);
        String decodedUsername = jwtProvider.extractUsernameToken(token);
        if (decodedUsername.equals(username)) {
            User user = userRepository.findByUsername(username).orElseThrow();
            user.setPassword(passwordEncoder.encode(form.getPassword()));
            user.setPhoneNumber(form.getPhoneNumber());
            user.setEmailAddress(form.getEmail());
            user = userRepository.save(user);
            return UserDTO.fromEntity(user);
        } else {
            throw new Exception();
        }
    }
}
