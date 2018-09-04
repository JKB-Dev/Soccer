package com.soccerteam.Soccer;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soccerteam.Soccer.dao.SoccerMemberRepo;
import com.soccerteam.Soccer.dao.SoccerTeamRepo;
import com.soccerteam.Soccer.entity.Members;
import com.soccerteam.Soccer.entity.Teams;

@Controller
public class SoccerController {

	@Autowired
	SoccerTeamRepo teamRepo;
	
	@Autowired
	SoccerMemberRepo memberRepo;
	
	// home page
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
		}
	
	//	view members
	@RequestMapping("/members")
	public ModelAndView memberpage(){
		ModelAndView memberMv = new ModelAndView("membertable", "members", memberRepo.findAll());
		return memberMv;
		}
	
	// add-member page
	@RequestMapping("member/create") // from href
	public ModelAndView showMemberAdd() {
		ModelAndView mv = new ModelAndView("member-edit"); // calls .jsp
		mv.addObject("teams", teamRepo.findAll());
		return mv;
	}
	
	// create new member from user input, returns user to members page
	@PostMapping("member/create")
	public ModelAndView addMemberForm(@RequestParam("name") String name, 
	@RequestParam("role") String role, @RequestParam("team") Teams team) { // member properties to be described
		Members member = new Members(name, role, team); // calling ID-less constructor
		ModelAndView mv = new ModelAndView("redirect:/members"); // return to members page when member is created
		memberRepo.save(member); // calling respository method to save or update
		return mv;
		}
	
	// delete member, refreshes members page
	@RequestMapping("/member/{id}/delete")
	public ModelAndView deleteMember(@PathVariable("id") Long id) {
		memberRepo.deleteById(id);
		return new ModelAndView("redirect:/members");
		}
	
	// member edit page FIXME: load current values as placeholders
	@RequestMapping("/member/{id}/edit")
	public ModelAndView showEditForm(@PathVariable("id") Long id) { // path variable is the member selected by user input
		ModelAndView mv = new ModelAndView("member-edit"); // calls .jsp view
		mv.addObject("title", "Edit Member");
		mv.addObject("item", memberRepo.findById(id).orElse(null)); 
		mv.addObject("teams", teamRepo.findAll());
		return mv;
		}	
	
//	// FIXME: member edit action page: sometimes updates, but whitepages: "save transient instance before flushing"
//	@PostMapping("/member/{id}/edit")
//	public ModelAndView editMember(Members member, Teams team, @PathVariable("id") Long memberId, 
//			@RequestParam("name") String membername, @RequestParam("role") String memberrole) {
//		member.setMemberid(memberId);
//		member.setMembername(membername);
//		member.setMemberrole(memberrole);
//		member.setTeam(team);//teamRepo.save(team);
//		memberRepo.save(member);
//		teamRepo.save(team);
//		return new ModelAndView("redirect:/members");
//	}
	
	// based on Ben's solution, "parameter teamid not present"
	@PostMapping("/member/{id}/edit")
	public ModelAndView editMember(@RequestParam("teamid") Long teamid, @PathVariable("id") Long memberId, 
			@RequestParam("name") String membername, @RequestParam("role") String memberrole) {
		Optional<Teams> oTeam = teamRepo.findById(teamid);
		Teams team = oTeam.get();
		Members member = new Members(memberId, membername, memberrole, team);
		memberRepo.save(member);
		return new ModelAndView("redirect:/members");
	}
	
	// view teams
	@RequestMapping("/teams")
	public ModelAndView teampage() {
		ModelAndView teamMv = new ModelAndView("teamtable", "teams", teamRepo.findAll());
		return teamMv;
		}
	
	// add team
	@RequestMapping("team/create")
	public ModelAndView teamCreate() {
		ModelAndView create = new ModelAndView("team-edit");
		create.addObject("item", "Enter new team name:");
		return create;
	}
	
	// create new team from user input, returns user to teams page
	@PostMapping("team/create")
	public ModelAndView addTeamForm(@RequestParam("name") String name) {
		Teams team = new Teams(name, null);
		ModelAndView mv = new ModelAndView("redirect:/teams");
		teamRepo.save(team);
		return mv;
		}
	
	// delete team, refreshes teams page
	@RequestMapping("/team/{id}/delete")
	public ModelAndView deleteTeam(@PathVariable("id") Long id) {
		teamRepo.deleteById(id); 
		return new ModelAndView("redirect:/teams");
		}
	
	// item edit page, loads current values
	@RequestMapping("/team/{id}/edit")
	public ModelAndView showTeamEdit(@PathVariable("id") Long id) { // path variable is the team selected by user input
		ModelAndView mv = new ModelAndView("team-edit", "teamid", id); // calls .jsp view
		mv.addObject("title", "Edit Team");
		mv.addObject("item", teamRepo.findById(id).orElse(null)); 
		return mv;
		}
	
	// save new values from edit page, returns user to home
	@PostMapping("/team/{id}/edit")
	public ModelAndView editTeam(Teams team, @RequestParam("id") Long id, @RequestParam("name") String name) { // path variable is the product selected by user input
		team.setTeamid(id);	// entity method chooses existing team to modify
		team.setTeamname(name);
		teamRepo.save(team);	// calling respository method to save or update
		return new ModelAndView("redirect:/teams"); // return to teams after save
		}
	
	// view members of any team
	@RequestMapping("/team/{id}/view")
	public ModelAndView viewTeam(@PathVariable("id") Long id, Optional<Teams> teamlist) {
		teamlist = teamRepo.findById(id);
		ModelAndView tv = new ModelAndView("team-view");
		Teams team = teamlist.get();
		tv.addObject("teamMembers", team.getMembers());
		return tv;
		
	}
	
}
