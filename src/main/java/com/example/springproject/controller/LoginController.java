package com.example.springproject.controller;

import com.example.springproject.model.User;
import com.example.springproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String getLogin(Model model) {

        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            Optional<User> optionalUser = userRepository.findByEmail(email);
            if(optionalUser.isPresent()) {
                if (passwordEncoder.matches(password, optionalUser.get().getPassword())) {
                    if (optionalUser.get().getRole().equals("admin")) {

                        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(email, password);
                        authToken.setDetails(new WebAuthenticationDetails(request));
                        Authentication authentication = authenticationManager.authenticate(authToken);
                        SecurityContextHolder.getContext().setAuthentication(authentication);

                        model.addAttribute("currentUserId", optionalUser.get().getId());
                        model.addAttribute("currentUserName", optionalUser.get().getFirstName() + " " + optionalUser.get().getLastName());

                        return "adminPage";
                    } else {

                        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(email, password);
                        authToken.setDetails(new WebAuthenticationDetails(request));
                        Authentication authentication = authenticationManager.authenticate(authToken);
                        SecurityContextHolder.getContext().setAuthentication(authentication);

                        model.addAttribute("currentUserId", optionalUser.get().getId());
                        model.addAttribute("currentUserName", optionalUser.get().getFirstName() + " " + optionalUser.get().getLastName());

                        return "userPage";
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return "login";
    }



}
