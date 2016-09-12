package projects.mum.edu.ea.app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import projects.mum.edu.ea.domain.Administrator;
import projects.mum.edu.ea.domain.Beneficiary;
import projects.mum.edu.ea.domain.Offer;
import projects.mum.edu.ea.domain.Project;
import projects.mum.edu.ea.domain.ProjectStatus;
import projects.mum.edu.ea.domain.Resource;
import projects.mum.edu.ea.domain.ResourceType;
import projects.mum.edu.ea.domain.Task;
import projects.mum.edu.ea.domain.User;
import projects.mum.edu.ea.domain.Volunteer;

@SpringBootApplication
public class ExtraCreditEaApplication {
	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("ea544extra");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static void main(String[] args) {
		//SpringApplication.run(ExtraCreditEaApplication.class, args);
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			//volunteer
			User volunteer = new Volunteer();
			volunteer.setEmail("sahib.zer@gmail.com");
			volunteer.setFirstName("Sahib Zar");
			volunteer.setLastName("Khan");
			em.persist(volunteer);
		
			//admin
			User admin = new Administrator();
			admin.setEmail("meetsahib88@gmail.com");
			admin.setFirstName("Sahib Zar");
			admin.setLastName("Khan");
			em.persist(admin);
			
		
			//project
			Project project = new Project();
			Task task = new Task();
			System.out.println("Persisting Project");
			try
			{
				
				project.setDescription("A test project");
				project.setName("Test BOOT Project");
				project.setUser((Administrator) admin);
				project.setStatus(ProjectStatus.NOT_STARTED);
				System.out.println("Persisting resource");
				Resource resource = new Resource();
				resource.setDescription("Developer who know backend and frontend both. A full stack developer");
				resource.setResourceType(ResourceType.SKILL);
				resource.setName("Skill Required");
				em.persist(resource);
				task.setHoursToComplete(19);
				task.setPercentCompleted(0);
				task.setProject(project);
				em.persist(task);
				Beneficiary beneficiary = new Beneficiary();
				beneficiary.setDescription("Facebook Incroporation is a largest social network");
				beneficiary.setName("FB");
				em.persist(beneficiary);
				project.getBeneficiaries().add(beneficiary);
				project.getResources().add(resource);
				project.getTasks().add(task);
				//persist resource
				
				em.persist(project);
			}
			catch(Exception ex)
			{
				System.out.println("Saving project "+ex.getMessage());
			}
			
			//offer by voluteer
			System.out.println("Persisting offer");
			Offer offer = new Offer();
			
			offer.setUser(volunteer);
			
			offer.getTasks().add(task);
			em.persist(offer);
			
			tx.commit();		
		} 
		catch (Throwable e) 
		{
			System.out.println(e.getMessage());
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} 
		finally 
		{
			if ((em != null) && (em.isOpen())) em.close();
		}
	}
}
