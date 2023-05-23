package be.technifutur.Labofinal.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class JWTProvider {

    private final UserDetailsService userDetailsService;

    public JWTProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String createToken(Authentication auth){
        return JWT.create()
                .withSubject(auth.getName())
                .withExpiresAt(Instant.now().plusMillis(86_400_000))
                .withClaim("mood",":)")
                .sign(Algorithm.HMAC512("M)r2;3Y6TI'wQlb'k&a5jBaNrrm7TY"));
    }

    public String extractToken(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        if(authHeader == null){
            return null;
        }
        return authHeader.replace("Bearer ","");
    }

    public boolean validateToken(String token){
        try{
            DecodedJWT jwt = JWT.require(Algorithm.HMAC512("M)r2;3Y6TI'wQlb'k&a5jBaNrrm7TY"))
                    .acceptExpiresAt(86400000)
                    .withClaim("mood",":)")
                    .build()
                    .verify(token);

            return true;
        }catch (JWTVerificationException e){
            return false;
        }
    }

    public Authentication createAuth(String token){
        String username = extractUsernameToken(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(),null,userDetails.getAuthorities());
    }

    public String extractUsernameToken(String token){
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getSubject();
    }
}
