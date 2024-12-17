package com.automation.automation.controller;

import com.automation.automation.model.Educator;
import com.automation.automation.model.MemberRole;
import com.automation.automation.model.Role;
import com.automation.automation.service.EducatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/educator")
@CrossOrigin("*")
public class EducatorController {

    @Autowired
    private EducatorService educatorService;

    @GetMapping("/test")
    public String test(){
        return "Welcome to backend api to Automation";
    }

    @PostMapping("/add")
    public Educator createMember(@RequestBody Educator educator) throws Exception {
//      encoding password by bcrypt
//        educator.setPassword(this.bCryptPasswordEncoder.encode(educator.getPassword()));
        Set<MemberRole> roles= new HashSet<>();
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("EDUCATOR");
        MemberRole memberRole = new MemberRole();
        memberRole.setEducator(educator);
        memberRole.setRole(role);
        roles.add(memberRole);
        return this.educatorService.addEducator(educator, roles);
    }
    @GetMapping("/{username}")
    public Educator getEducatorByUsername(@PathVariable("username") String username)
    {
        return this.educatorService.getEducatorByUsername(username);
    }
    @GetMapping("/email/{email}")
    public Educator getEducatorByEmail(@PathVariable("email") String email)
    {
        return this.educatorService.getEducatorByEmail(email);
    }

    @GetMapping("/active")
    public List<Educator> getAllActiveEducator(){
        return this.educatorService.getAllActiveEducator();
    }
}
