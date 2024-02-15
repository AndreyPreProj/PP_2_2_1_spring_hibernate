package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getUserByCar(int series, String model) {
        Car car = null;
        try {
            String hql = "from Car where series = :value1 and model=:value2";
            Query query = sessionFactory.getCurrentSession().createQuery(hql);
            query.setParameter("value1", series);
            query.setParameter("value2", model);
            car = (Car) ((org.hibernate.query.Query<?>) query).uniqueResult();
        } catch (NullPointerException e) {
            System.out.println("User с такой машиной не существует");
        }

        return car.getUser();
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

}
