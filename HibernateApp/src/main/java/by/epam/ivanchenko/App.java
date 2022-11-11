package by.epam.ivanchenko;

import by.epam.ivanchenko.model.Item;
import by.epam.ivanchenko.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
// Получение товаров человека
//            Person person = session.get(Person.class, 3);
//            List<Item> items = person.getItems();
//            System.out.println(items);
/* */
// Получение человека по товару
//            Item item = session.get(Item.class,5);
//            System.out.println(item);
//            Person person = item.getOwner();
//            System.out.println(person);
/* */
// Добавление нового товара человеку
//            Person person = session.get(Person.class, 2);
//            Item newItem = new Item("Item from Hibernate", person);
//            person.getItems().add(newItem);                                       // ! Чтобы значение в кэше Hibernata соответствовало значению в таблице БД.
//            session.save(newItem);
/* */
// Добавление нового человека и товара ему
//            Person person = new Person("Jim", 55);
//            Item newItem = new Item("Item from Hibernate 2", person);
//            person.setItems(new ArrayList<>(Collections.singletonList(newItem))); // Созд. список из одного эл.
//            session.save(person);                                                 // Сохр. каждую сущность
//            session.save(newItem);                                                // Сохр. каждую сущность
/* */
// Удаление товаров человека
//            Person person = session.get(Person.class, 3);
//            List<Item> items = person.getItems();
//            // SQL
//            for (Item item : items) {
//                session.remove(item);
//            }
//                                                                                  // ! Чтобы значение в кэше Hibernata соответствовало значению в таблице БД.
//            person.getItems().clear();
/* */
// Удаление человека и его item
//            Person person = session.get(Person.class, 2);
//            session.remove(person);
//            person.getItems().forEach(i -> i.setOwner(null));                      // ! Чтобы значение в кэше Hibernata соответствовало значению в таблице БД.
// Через лямбду проходимся по каждому item и назначем полю owner null, т.к. в таблице owner удален
/* */
// Изменение владельца товара
//            Person person = session.get(Person.class,4);
//            Item item = session.get(Item.class, 1);
//            // SQL
//            item.setOwner(person);
//            person.getItems().add(item);                                             // ! Чтобы значение в кэше Hibernata соответствовало значению в таблице БД: добавление товара новому человеку
//            item.getOwner().getItems().remove(item);                                 // ! Чтобы значение в кэше Hibernata соответствовало значению в таблице БД: удаление товара у старого человека

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
