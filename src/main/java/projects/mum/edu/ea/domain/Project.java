package projects.mum.edu.ea.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Project {
	@Id @GeneratedValue
	private int id;	
	private String name;
	private String description;
	@ManyToOne
	private Administrator user;	
	
	@OneToMany(mappedBy="project")
	private List<Task> tasks = new ArrayList<Task>();
	
	@OneToMany
	@JoinTable(name = "project_resources",
	            joinColumns = @JoinColumn(name = "project_id"),
	            inverseJoinColumns = @JoinColumn(name = "resource_id"))
	private List<Resource> resources = new ArrayList<Resource>();
	
	@OneToMany
	@JoinTable(name = "project_beneficiaries",
	            joinColumns = @JoinColumn(name = "project_id"),
	            inverseJoinColumns = @JoinColumn(name = "beneficiary_id"))
	private List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();
	
	@Enumerated(EnumType.STRING)
	private ProjectStatus status;
	
	public Administrator getUser() {
		return user;
	}
	public void setUser(Administrator user) {
		this.user = user;
	}
	
	public List<Beneficiary> getBeneficiaries() {
		return beneficiaries;
	}
	public void setBeneficiaries(List<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public List<Resource> getResources() {
		return resources;
	}
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProjectStatus getStatus() {
		return status;
	}
	public void setStatus(ProjectStatus status) {
		this.status = status;
	}
}
