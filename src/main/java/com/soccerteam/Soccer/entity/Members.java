package com.soccerteam.Soccer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Members {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long memberid;
	
	private String membername;
	private String memberrole;

	@ManyToOne
	@JoinColumn(name = "teamid")
	private Teams team;
	
	public Members() {

	}

	public Members(Long memberid, String membername, String memberrole, Teams team) {
		super();
		this.memberid = memberid;
		this.membername = membername;
		this.memberrole = memberrole;
		this.team = team;
	}

	public Members(String membername, String memberrole, Teams team) {
		this.membername = membername;
		this.memberrole = memberrole;
		this.team = team;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getMemberrole() {
		return memberrole;
	}

	public void setMemberrole(String memberrole) {
		this.memberrole = memberrole;
	}

	public Teams getTeam() {
		return team;
	}

	public void setTeam(Teams team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return membername;
	}
	
	
}
