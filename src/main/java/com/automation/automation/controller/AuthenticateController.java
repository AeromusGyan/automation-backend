package com.automation.automation.controller;

import com.automation.automation.config.JwtUtils;
import com.automation.automation.model.Educator;
import com.automation.automation.model.JwtRequest;
import com.automation.automation.model.JwtResponse;
import com.automation.automation.service.impl.EducatorDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private EducatorDetailsServiceImpl educatorDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

//    generateToken

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try
        {
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("User not found !!");
        }

        /////authenticate
        UserDetails userDetails = this.educatorDetailsService.loadUserByUsername(jwtRequest.getUsername());

        String token = this.jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try
        {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException e)
        {
            throw new Exception("USER DISABLED"+e.getMessage());
        }catch (BadCredentialsException e){
            throw new Exception("Invalid credentials"+e.getMessage());
        }
    }
    //  returns the currnet user details
    @GetMapping("/current-user")
    public Educator getCurrentMember(Principal principal)
    {
        System.out.println("called" + this.educatorDetailsService.loadUserByUsername(principal.getName()));
        return  ((Educator) this.educatorDetailsService.loadUserByUsername(principal.getName()));
    }
}
