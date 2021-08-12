package ru.job4j.tracker.store;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.tracker.model.Item;

import java.util.List;

public class HbmTracker implements Store {


    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();
    private static final Logger LOG = LogManager.getLogger();

    @Override
    public void init() {

    }

    @Override
    public Item add(Item item) {
        Transaction transaction = null;
        try(Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOG.error(e.getMessage());
        }
        return item;
    }


    @Override
    public boolean replace(String id, Item item) {
        Transaction transaction = null;
        try(Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            Item updateItem = session.get(Item.class, Integer.valueOf(id));;
            if (updateItem != null) {
                updateItem.setName(item.getName());
                updateItem.setDescription(item.getDescription());
                updateItem.setCreated(item.getCreated());
            }
            session.update(updateItem);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOG.error(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        boolean rsl = false;
        Transaction transaction = null;
        try(Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            Item item = new Item("delete");
            item.setId(Integer.parseInt(id));
            session.delete(item);
            transaction.commit();
            rsl = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOG.error(e.getMessage());
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> itemsList = null;
        Transaction transaction = null;
        try(Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            itemsList = session.createQuery("from ru.job4j.tracker.model.Item", Item.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOG.error(e.getMessage());
        }
        return itemsList;
    }
    //!!
    @Override
    public List<Item> findByName(String key) {
        List<Item> list = null;
        Transaction transaction = null;
        try(Session session = sf.openSession())  {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from ru.job4j.tracker.model.Item where name = :paramName");
            query.setParameter("paramName", key).list();
            list = query.list();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOG.error(e.getMessage());
        }
        return list;
    }

    @Override
    public Item findById(String id) {
        Item item = null;
        Transaction transaction = null;
        try(Session session = sf.openSession())  {
            transaction = session.beginTransaction();
            item = session.get(Item.class, Integer.valueOf(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOG.error(e.getMessage());
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
