package com.automation.automation.service.impl;

import com.automation.automation.model.Educator;
import com.automation.automation.model.MemberRole;
import com.automation.automation.repo.EducatorRepository;
import com.automation.automation.repo.RoleRepository;
import com.automation.automation.service.EducatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EducatorServiceImpl implements EducatorService {
    @Autowired
    private EducatorRepository educatorRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Educator addEducator(Educator educator, Set<MemberRole> memberRoles) throws Exception {
        Educator uName = this.educatorRepository.findByUsername(educator.getUsername());
        Educator email = this.educatorRepository.findByEmail(educator.getEmail());
        System.out.println("Email = "+ email);
        if ((uName != null) && (email !=null))
        {
            System.out.println("Member ia already there !!");
            throw new Exception("Member is already present !!");
        }
        else
        {
//            System.out.println(member);
            for (MemberRole mr:memberRoles)
            {
                roleRepository.save(mr.getRole());
            }
            educator.getMemberRoles().addAll(memberRoles);
            uName = this.educatorRepository.save(educator);
        }
        return uName;
    }

    @Override
    public Educator getEducatorByUsername(String username) {
        return this.educatorRepository.findByUsername(username);
    }

    @Override
    public Educator getEducatorByEmail(String email) {
        return this.educatorRepository.findByEmail(email);
    }

    @Override
    public List<Educator> getAllActiveEducator() {
        return (List<Educator>) this.educatorRepository.findAll();
    }
}
