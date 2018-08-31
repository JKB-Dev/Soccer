package com.soccerteam.Soccer;


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
	public String showMemberAdd() {
		return "member-add"; // calls member-add.jsp
		}
	
	// create new member from user input, returns user to members page
	@PostMapping("member/create")
	public ModelAndView addMemberForm(@RequestParam("membername") String name, 
	@RequestParam("memberrole") String role, @RequestParam("teamid") Teams team) { // member properties to be described
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
	
	// item edit page, loads current values
	@RequestMapping("/member/{id}/edit")
	public ModelAndView showEditForm(@PathVariable("id") Long id) { // path variable is the product selected by user input
		ModelAndView mv = new ModelAndView("member-edit"); // calls .jsp view
		mv.addObject("title", "Edit Member");
		mv.addObject("item", memberRepo.findById(id).orElse(null)); 
		return mv;
		}	
	
	@PostMapping("/member/{id}/edit")
	public ModelAndView editMember(Members member, @PathVariable("id") Long id, 
			@PathVariable("membername") String name, @PathVariable("memberrole") String role) {
		member.setMemberid(id);
		member.setMembername(name);
		member.setMemberrole(role);
		memberRepo.save(member);
		return new ModelAndView("redirect:/membertable");
	}
	
	// view teams
	@RequestMapping("/teams")
	public ModelAndView teampage() {
		ModelAndView teamMv = new ModelAndView("teamtable", "teams", teamRepo.findAll());
		return teamMv;
		}
	
	// add-team page
	@RequestMapping("team/create") // from href
	public String showTeamAdd() {
		return "team-add"; // calls item-add.jsp
		}	
	
	// create new team from user input, returns user to teams page
	@PostMapping("team/create")
	public ModelAndView addTeamForm(@RequestParam("teamname") String name) {
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
	public ModelAndView showTeamEdit(@PathVariable("id") Long id) { // path variable is the product selected by user input
		ModelAndView mv = new ModelAndView("team-edit"); // calls .jsp view
		mv.addObject("title", "Edit Team");
		mv.addObject("item", teamRepo.findById(id).orElse(null)); 
		return mv;
		}
	
	// save new values from edit page, returns user to home
	@PostMapping("/team/{id}/edit")
	public ModelAndView editTeam(Teams team, @RequestParam("id") Long id, @RequestParam("name") String name) { // path variable is the product selected by user input
		//team.setTeamid(id);	// entity method chooses existing product to modify
		team.setTeamname(name);
		teamRepo.save(team);	// calling respository method to save or update
		return new ModelAndView("redirect:/teamtable"); // return to teams after save
		}
	
	// view team
	@RequestMapping("/team/{id}/view")
	public ModelAndView viewTeam(@PathVariable("id") Long id) {
		Teams team = teamRepo.getOne(id);
		String name = team.getTeamname();
		ModelAndView teamViewMv = new ModelAndView("team-view", "teamname", name);
		teamViewMv.addObject("teamMembers", teamRepo.getMembersInTeam(id));
		return teamViewMv;
		}
	
}
