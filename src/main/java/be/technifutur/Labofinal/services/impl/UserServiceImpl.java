package be.technifutur.Labofinal.services.impl;

import be.technifutur.Labofinal.utils.exceptions.InvalidUsernameException;
import be.technifutur.Labofinal.models.DTO.UserDTO;
import be.technifutur.Labofinal.models.entities.User;
import be.technifutur.Labofinal.models.forms.UserForm;
import be.technifutur.Labofinal.repositories.UserRepository;
import be.technifutur.Labofinal.services.UserService;
import be.technifutur.Labofinal.utils.JWTProvider;
import org.springframework.security.core.Authentication;
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
    public UserDTO findOneByUsername(String username) {
        return UserDTO.fromEntity(userRepository.findByUsername(username));
    }

    @Override
    public UserDTO updateUser(String username, UserForm form, Authentication auth) {
        String decodedUsername = auth.getName();
        if (decodedUsername.equals(username)) {
            User user = userRepository.findByUsername(username);
            user.setPassword(passwordEncoder.encode(form.getPassword()));
            user.setPhoneNumber(form.getPhoneNumber());
            user.setEmailAddress(form.getEmail());
            user = userRepository.save(user);
            return UserDTO.fromEntity(user);
        } else {
            throw new InvalidUsernameException();
        }
    }
}
