package com.soccerteam.Soccer.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Teams {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long teamid;
	private String teamname;
	
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Members> Members = new ArrayList<>();
	
	public Teams() {

	}

	public Teams(Long teamid, String teamname, List<com.soccerteam.Soccer.entity.Members> Members) {
		super();
		this.teamid = teamid;
		this.teamname = teamname;
		this.Members = Members;
	}

	public Teams(String teamname, List<com.soccerteam.Soccer.entity.Members> Members) {
		this.teamname = teamname;
		this.Members = Members;
	}

	public Long getTeamid() {
		return teamid;
	}

	public void setTeamid(Long teamid) {
		this.teamid = teamid;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public List<Members> getMembers() {
		return Members;
	}

	public void setMembers(List<Members> Members) {
		this.Members = Members;
	}

	@Override
	public String toString() {
		return teamname;
	}
	
	
}
