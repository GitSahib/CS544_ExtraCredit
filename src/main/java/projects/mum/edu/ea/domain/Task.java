package projects.mum.edu.ea.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task {
	@Id @GeneratedValue
	private int id;
	@ManyToOne
	private Project project;
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	private double hoursToComplete;
	private double percentCompleted;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getHoursToComplete() {
		return hoursToComplete;
	}
	public void setHoursToComplete(double hoursToComplete) {
		this.hoursToComplete = hoursToComplete;
	}
	public double getPercentCompleted() {
		return percentCompleted;
	}
	public void setPercentCompleted(double percentCompleted) {
		this.percentCompleted = percentCompleted;
	}
}
