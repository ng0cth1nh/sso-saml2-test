package com.spring.boot.security.saml.controllers;

import com.spring.boot.security.saml.stereotypes.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Controller
public class LandingController {

    // Logger
    private static final Logger LOG = LoggerFactory.getLogger(LandingController.class);

    @GetMapping("/landing")
    public void landing(HttpServletRequest request, HttpServletResponse response) throws URISyntaxException, ServletException, IOException {
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth == null)
//            LOG.debug("Current authentication instance from security context is null");
//        else
//            LOG.debug("Current authentication instance from security context: {}", this.getClass().getSimpleName());
//        model.addAttribute("username", user.getUsername());
//
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        URI location = new URI("http://localhost:3000");
        HttpHeaders httpHeaders = new HttpHeaders();
     //   httpHeaders.add("Authorization", response.getHeader("Authorization"));
        httpHeaders.setLocation(location);
        request.getRequestDispatcher("http://localhost:3000").forward(request, response);

        //return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }


}
