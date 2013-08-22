package fr.treeptik.locationvoiture.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.model.Voiture;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/dispatcher-servlet.xml")
public class VoitureDAOTest {
	
	@Autowired
	private VoitureDAO voitureDAO;
	
	@Test
	public void testSaveOk(){
		
		Voiture voiture = new Voiture(null, "Mercedes", "Benz");
		
		try {
			voitureDAO.save(voiture);
		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	@Transactional
	public void testRemoveOk(){
		
		Voiture voiture = new Voiture();
		voiture.setId(1);
		
		try {
			voitureDAO.remove(voiture);
		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}
		
	}
	
	@Test
	@Transactional
	public void testFindAll(){
		
		try {
			voitureDAO.findAll();
		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}
	}
	
	
}
