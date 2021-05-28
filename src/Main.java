import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.time.LocalDate;
import java.util.Map;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();

        Team t = new Team("Na'Vi");
        Player p = new Player("Senya", "Vasylev", "Ihorevich", LocalDate.of(2000, 12, 12), 2000.0, Player.Role.CARRY, t);
        Player p1 = new Player("Petya", "Popov", "Petrovich", LocalDate.of(1998, 11, 15), 2500.0, Player.Role.HARD_SUPPORT, t);

        Tournament tour = new Tournament("Kyiv Major", 1000000);
        TeamInTournament teamInTournament = new TeamInTournament(1, t, tour);
        session.beginTransaction();
        session.save(t);
        session.save(p);
        session.save(p1);
        session.save(tour);
        session.save(teamInTournament);
        session.getTransaction().commit();

        final Metamodel metamodel = session.getSessionFactory().getMetamodel();
        for (EntityType<?> entityType : metamodel.getEntities()) {
            final String entityName = entityType.getName();
            final Query query = session.createQuery("from " + entityName);
            System.out.println("executing: " + query.getQueryString());
            for (Object o : query.list()) {
                System.out.println("  " + o);
            }
        }

    }
}