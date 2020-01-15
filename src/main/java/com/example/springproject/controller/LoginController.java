package com.example.springproject.controller;

import com.example.springproject.model.User;
import com.example.springproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
                        return "adminPage";
                    } else {
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
