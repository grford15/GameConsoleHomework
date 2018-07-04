package db;

import models.Console;
import models.Games;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBConsole {

    private static Session session;
    private static Transaction transaction;

    public static void addGameToConsole(Games game, Console console){
        game.addConsoles(console);
        console.addGames(game);
        DBHelper.update(game);
    }

    public static List<Games> availableGames(Console console){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Games> result = null;
        try{
            Criteria cr = session.createCriteria(Games.class);
            cr.createAlias("consoles", "console");
            cr.add(Restrictions.eq("console.id", console.getId()));
            result = cr.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        } return result;
    }
}
