package controler.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.entities.Aluno;

public class ControllerAluno {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("aluno");
	EntityManager em = emf.createEntityManager();
	
	public void addAluno(Aluno aluno) {
		em.getTransaction().begin();
		em.merge(aluno);
		em.getTransaction().commit();
		emf.close();
	}
	
	
}
