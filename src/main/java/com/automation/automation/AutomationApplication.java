package com.automation.automation;

import com.automation.automation.helper.UserFoundException;
import com.automation.automation.model.Educator;
import com.automation.automation.model.MemberRole;
import com.automation.automation.model.Role;
import com.automation.automation.service.EducatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AutomationApplication implements CommandLineRunner {

	@Autowired
	private EducatorService educatorService;

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(AutomationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Automation is Started on port 2023...");

//		try
//		{
//			Educator member = new Educator();
//			member.setUsername("scheduloteam");
//			member.setEducator_name("Schedulo Infosys Team");
//			member.setEmail("schedulo@infosys.com");
//			member.setPassword("scheduloteam");
//			member.setStatus(true);
//
//			Role role1 = new Role();
//			role1.setRoleId(43L);
//			role1.setRoleName("SCHEDULO");
//			Educator member = new Educator();
//			member.setUsername("ibpoadmin");
//			member.setEducator_name("IBPO Infosys Admin");
//			member.setEmail("ibpo@infosys.com");
//			member.setPassword("ibpoadmin");
//			member.setStatus(true);
//
//			Role role1 = new Role();
//			role1.setRoleId(44L);
//			role1.setRoleName("IBPO");
//			Set<MemberRole> memberRoleSet = new HashSet<>();
//			MemberRole memberRole = new MemberRole();
//			memberRole.setRole(role1);
//			memberRole.setEducator(member);
//			memberRoleSet.add(memberRole);
//			Educator educator = this.educatorService.addEducator(member, memberRoleSet);
//
//			System.out.println(educator);
//		}catch (UserFoundException e){
//			e.printStackTrace();
//		}

	}

}
