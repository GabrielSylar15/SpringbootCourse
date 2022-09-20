package com.springboot.first.app.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the certificate database table.
 * 
 */
@Entity
@Table(name="certificate")
@NamedQuery(name="Certificate.findAll", query="SELECT c FROM Certificate c")
public class Certificate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="certificate_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int certificateId;

	@Column(name="cetificate_name")
	private String cetificateName;

	//bi-directional many-to-many association to Employee
	@ManyToMany(mappedBy="certificates")
	private List<Employee> employees;

	public Certificate() {
	}

	public int getCertificateId() {
		return this.certificateId;
	}

	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}

	public String getCetificateName() {
		return this.cetificateName;
	}

	public void setCetificateName(String cetificateName) {
		this.cetificateName = cetificateName;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}