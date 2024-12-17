package com.automation.automation.service.impl;

import com.automation.automation.model.Educator;
import com.automation.automation.repo.EducatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EducatorDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private EducatorRepository educatorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Educator educator =this.educatorRepository.findByUsername(username);
        if (educator==null)
        {
            System.out.println("Educator not found");
            throw new UsernameNotFoundException("No Educator found!");
        }
        return educator;
    }
}
