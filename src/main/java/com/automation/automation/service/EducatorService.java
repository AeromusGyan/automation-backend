package com.automation.automation.service;

import com.automation.automation.model.Educator;
import com.automation.automation.model.MemberRole;

import java.util.List;
import java.util.Set;

public interface EducatorService {

    public Educator addEducator(Educator educator, Set<MemberRole>memberRoles) throws Exception;

    public Educator getEducatorByUsername(String username);

    public Educator getEducatorByEmail(String email);

    public List<Educator> getAllActiveEducator();
}
