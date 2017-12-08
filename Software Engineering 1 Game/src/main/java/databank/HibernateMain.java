package databank;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;

public class HibernateMain {

	public void setNewGame(int gameID) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Game game = new Game();
		game.setGameID(gameID);
       	game.setRoundNumber(1);
        session.save(game);
        session.getTransaction().commit();
	}
	
	public void setRoundNumberGame(int gameID, int roundNumber) {	
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		Game game = new Game();
		game.setGameID(gameID);
		game.setRoundNumber(roundNumber);
		session.saveOrUpdate(game);
		session.getTransaction().commit();
		
	}
	
	public void setMapForGame(int gameID, String map) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		Game game = new Game();
		game.setGameID(gameID);
		game.setMap(map);
		session.saveOrUpdate(game);
		session.getTransaction().commit();
	}
	
	public void setPlayerStartingCoord(String matriculationNumber, String startingCoordinates) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		Player player = new Player();
		player.setMatriculationNumber(matriculationNumber);
		player.setStartingCoordinates(startingCoordinates);
		
		session.saveOrUpdate(player);
		session.getTransaction().commit();
	}
	
	public void setPlayerID(String matriculationNumber, int playerID) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		Player player = new Player();
		player.setMatriculationNumber(matriculationNumber);
		player.setPlayerID(playerID);	
		
		session.saveOrUpdate(player);
		session.getTransaction().commit();
	}
	
	public void setNewPlayer(String firstName, String surName, String matriculationNumber, int playerID) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		Player player = new Player();
		player.setFirstName(firstName);
		player.setSurName(surName);
		player.setMatriculationNumber(matriculationNumber);
		player.setPlayerID(playerID);
		//player.setStartingCoordinates(startingCoordinates);
		
		session.saveOrUpdate(player);
		session.getTransaction().commit();
		
	}
	
	public void setPlay(int gameID, int player1, int player2) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		Play play = new Play();
		play.game.setGameID(gameID);
		play.player1.setPlayerID(player1);
		//play.player2.setPlayerID(player2);
		
		session.saveOrUpdate(play);
		session.getTransaction().commit();
	}
	
	//public static void main(String[] args) {

    //System.out.println("Hibernate one to many (Annotation)");
    //HibernateMain h = new HibernateMain();
    
   /* h.setNewGame(1);
    h.setRoundNumberGame(1, 120);
	h.setMapForGame(1, "0C0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0M0C0G0G0G0G0G0G0M0G0G0W0G0G0G0G0M0G0W0G0G0W0G0G0M0G0W0G0W0G0G0M0M");*/
    
    //h.setPlay(1, 1, 2);
    
    /*Session session = HibernateUtil.getSessionFactory().openSession();

	session.beginTransaction();
	Game game = new Game();
		game.setGameID(1);
       	game.setRoundNumber(1);
        session.save(game);

        ActionList actionList = new ActionList();
        
        actionList.setActionID(1);
        actionList.setAction("UP");

        actionList.setGameID(game.getGameID());
        //game.getActionList().add(actionList);

        session.save(actionList);

        session.getTransaction().commit();*/
	//System.out.println("Done");
	//}
	
	
	
	/*private static SessionFactory sessionFactory = null;
	private static SessionFactory configureSessionFactory() throws HibernateException{
		sessionFactory = new Configuration()
				.configure()
				.buildSessionFactory();
		return sessionFactory;
	}
	
	
	public static void main(String[] args) {
		configureSessionFactory();
		Session session = null;
		Transaction tx = null;
		
		/*try { //TODO ADD THIS TO DOCUMENTATION AS EXCEPTION
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Game g1 = new Game(1, 1);
			session.save(g1);
			session.flush();
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		try {
			
			session = sessionFactory.openSession();
			
			/*Game game = session
					.createNamedQuery("get_game", Game.class)
					.setParameter("name", 2)
					.getSingleResult();
			
			tx = session.beginTransaction();
			Game game = new Game(3, 1);
			session.save(game);
			session.flush();
			tx.commit();
			
			tx = session.beginTransaction();
			game.getActionList().add(new ActionList(3, 1, "UP"));
			session.persist(game);
			session.flush();
			tx.commit();
			
			System.out.println("Game: " + game.getGameID());
			for(ActionList actionList : game.getActionList()) {
				System.out.println(game.getGameID() + actionList.getActionID() /*+ actionList.getAction());
			} 
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			if(session!=null) {
				session.close();
			}
		}

	}*/

}
