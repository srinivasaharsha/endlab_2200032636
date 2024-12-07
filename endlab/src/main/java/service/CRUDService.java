package service;

import model.CRUD;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class CRUDService {

    public String add(CRUD crud) throws Exception {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();
        session.persist(crud);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

        return "Data has been saved successfully.";
    }

    public String update(CRUD crud) throws Exception {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();
        CRUD tmp = session.find(CRUD.class, crud.getId());
        if (tmp != null) {
            tmp.setName(crud.getName());
            tmp.setDepartment(crud.getDepartment());
        }
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

        return "Data has been updated successfully.";
    }

    public String delete(int id) throws Exception {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();
        CRUD tmp = session.find(CRUD.class, id);
        if (tmp != null) {
            session.remove(tmp);
        }
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

        return "Data has been deleted successfully.";
    }

    public List<CRUD> read() throws Exception {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();
        Query<CRUD> query = session.createQuery("FROM CRUD", CRUD.class);
        List<CRUD> crudList = query.getResultList();
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

        return crudList;
    }
}
