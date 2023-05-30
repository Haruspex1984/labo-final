package be.technifutur.Labofinal.services.impl;

import be.technifutur.Labofinal.models.DTO.AuthDTO;
import be.technifutur.Labofinal.models.DTO.UserDTO;
import be.technifutur.Labofinal.models.entities.User;
import be.technifutur.Labofinal.models.forms.LoginForm;
import be.technifutur.Labofinal.models.forms.RegisterForm;
import be.technifutur.Labofinal.repositories.UserRepository;
import be.technifutur.Labofinal.services.AuthService;
import be.technifutur.Labofinal.utils.JWTProvider;
import be.technifutur.Labofinal.utils.exceptions.InvalidCredentialsException;
import be.technifutur.Labofinal.utils.exceptions.InvalidUsernameException;
import be.technifutur.Labofinal.utils.exceptions.UsernameAlreadyExistsException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;


    public AuthServiceImpl(AuthenticationManager authenticationManager, JWTProvider jwtProvider, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;

    }


    @Override
    public AuthDTO login(LoginForm form) throws InvalidCredentialsException {
        try {
            Authentication auth = new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword());
            auth = authenticationManager.authenticate(auth);
            return new AuthDTO(auth.getName(), jwtProvider.createToken(auth));
        } catch (Exception e) {
            throw new InvalidCredentialsException() {
            };
        }
    }


    @Override
    public UserDTO register(RegisterForm form) throws UsernameAlreadyExistsException {
        try {
            User user = new User();
            user.setUsername(form.getUsername());
            user.setPassword(passwordEncoder.encode(form.getPassword()));
            user.setFirstname(form.getFirstname());
            user.setLastname(form.getLastname());
            user.setPhoneNumber(form.getPhoneNumber());
            user.setEmailAddress(form.getEmail());
            Set<String> roles = new HashSet<>();
            roles.add("USER");
            user.setRoles(roles);
            user = userRepository.save(user);
            return UserDTO.fromEntity(user);
        } catch (Exception e) {
            throw new UsernameAlreadyExistsException();
        }

    }
}



