package controler.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
	
	public void removeAluno(Aluno aluno) {
		em.getTransaction().begin();
		Query querryDelete = 
				em.createNativeQuery("DELETE ALUNO "
								  + "FROM ALUNO "
								  + "WHERE MATRICULA =" + aluno.getMatricula());
		querryDelete.executeUpdate();
		em.getTransaction().commit();
		emf.close();
	}
	
}
