package ru.job4j.tracker.store;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    private static Session session;
    private static final Logger LOG = LogManager.getLogger();

    @Override
    public void init() {

    }

    @Override
    public Item add(Item item) {
       try {
           session = sf.openSession();
           session.beginTransaction();
           session.save(item);
           session.getTransaction().commit();
       } catch (Exception e) {
           if (session.getTransaction() != null) {
               session.getTransaction().rollback();
           }
            LOG.error(e.getMessage());
       } finally {
           if (session != null) {
               session.close();
           }
       }

       return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean rsl = false;
        try {
            Item updateItem = findById(id);
            updateItem.setName(item.getName());
            updateItem.setDescription(item.getDescription());
            updateItem.setCreated(item.getCreated());
            session = sf.openSession();
            session.beginTransaction();
            session.update(updateItem);
            session.getTransaction().commit();
            rsl = true;
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            LOG.error(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
            return rsl;
        }
    }

    @Override
    public boolean delete(String id) {
        boolean rsl = false;
        try {
            session = sf.openSession();
            session.beginTransaction();
            Item item = new Item("delete");
            item.setId(Integer.parseInt(id));
            session.delete(item);
            session.getTransaction().commit();
            rsl = true;
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            LOG.error(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
            return rsl;
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> itemsList = null;
        try {
            session = sf.openSession();
            session.beginTransaction();
            itemsList = session.createQuery("from ru.job4j.tracker.model.Item", Item.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            LOG.error(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return itemsList;
    }
    //!!
    @Override
    public List<Item> findByName(String key) {
        List<Item> list = null;
        try {
            session = sf.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from ru.job4j.tracker.model.Item where name = :paramName");
            query.setParameter("paramName", key).list();
            list = query.list();
            session.getTransaction().commit();

        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            LOG.error(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    @Override
    public Item findById(String id) {
        Item item = null;
        try {
            session = sf.openSession();
            session.beginTransaction();
            item = session.get(Item.class, Integer.valueOf(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            LOG.error(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
