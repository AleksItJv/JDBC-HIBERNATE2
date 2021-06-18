package service;

import connector.HibernateUtil;
import dao.AnimalDAO;
import entity.Animal;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;

public class AnimalService implements AnimalDAO {

    public void save(Animal animal) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(animal);
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public Animal getAnimal(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String sql = "SELECT * FROM animals WHERE id = :id";

        Query query = session.createNativeQuery(sql).addEntity(Animal.class);
        query.setParameter("id", id);
        Animal animal = null;
        try {
            animal = (Animal) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("*-*-*-*-*-*-*-*-*-*-*--*-*-*");
            System.out.println("GetAnimal: " + e);
        }

        session.getTransaction().commit();
        session.close();

        return animal;
    }

    @Override
    public void updateAnimal(int age, int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String sql = "SELECT * FROM animals WHERE id = :id";
        Query query = session.createNativeQuery(sql).addEntity(Animal.class);
        query.setParameter("id", id);
        Animal animal = null;
        try {
            animal = (Animal) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("*-*-*-*-*-*-*-*-*-*-*--*-*-*");
            System.out.println("Update: " + e);
        }
        if (animal != null) {
            animal.setAge(age);
            session.update(animal);
        }

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteAnimal(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String sql = "SELECT * FROM animals WHERE id = :id";
        Query query = session.createNativeQuery(sql).addEntity(Animal.class);
        query.setParameter("id", id);
        Animal animal = null;
        try {
            animal = (Animal) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("*-*-*-*-*-*-*-*-*-*-*--*-*-*");
            System.out.println("Delete: " + e);
        }
        if (animal != null) {
            session.delete(animal);
        }

        session.getTransaction().commit();
        session.close();
    }
}
