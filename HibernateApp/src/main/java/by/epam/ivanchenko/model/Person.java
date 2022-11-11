package by.epam.ivanchenko.model;

import javax.persistence.*;

@Entity                        // в hibernate можно использоать только классы, помеченные, как сущности(@Entity)
@Table(name = "person")             // таблица в БД,если совпадает с классом, можно не указывать @Table...
public class Person {

    @Id                             //для  primary key
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // стратегия генерации автоматического id
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private int age;

    public Person() {              //пустой кон-р необходим для hibernate
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
