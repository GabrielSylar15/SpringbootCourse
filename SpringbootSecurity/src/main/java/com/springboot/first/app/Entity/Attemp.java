package com.springboot.first.app.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Attemps database table.
 * 
 */
@Entity
@Table(name="Attemps")
@NamedQuery(name="Attemp.findAll", query="SELECT a FROM Attemp a")
public class Attemp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int attempid;

	private int count;

	private int userid;

	public Attemp() {
	}

	public int getAttempid() {
		return this.attempid;
	}

	public void setAttempid(int attempid) {
		this.attempid = attempid;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}