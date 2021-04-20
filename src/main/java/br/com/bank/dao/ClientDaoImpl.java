/**
 * 
 */
package br.com.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.bank.model.Client;
import br.com.bank.util.JPAUtil;

/**
 * @author cbgomes
 *
 */
public class ClientDaoImpl implements ClientDao {

	@Override
	public Client getClient(String name) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			
			Client client = entityManager.createNamedQuery("Client.getByName",Client.class)
					.setParameter("name", name)
					.getSingleResult();
			
			return client;
			
		}catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}
		
		return null;
	}

	@Override
	public List<Client> getAll() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			
			 List<Client> clients = entityManager.createNamedQuery("Client.getAll", Client.class)
					.getResultList();
			
			return clients;
			
		}catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}
		
		return null;
	}

	@Override
	public void save(Client client) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
			
			entityManager.persist(client);
			entityManager.getTransaction().commit();
			entityManager.close();
		
	}

	@Override
	public void deleteById(Long idClient) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			
		Client client =  entityManager.createNamedQuery("Client.getById",Client.class)
					.setParameter("id", idClient)
					.getSingleResult();
		
		entityManager.remove(client);
		entityManager.getTransaction().commit();
		
			
		}catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		}
		
		
	}

}
