package by.epam.ivanchenko.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    //@OneToMany(mappedBy ="owner", cascade = CascadeType.PERSIST)    // каскадирование будет при сохранении сущности (PERSIST), т.е. надо использовать метод  persist() в App.
                                                                    // сохранение дочерней сущности будет каскадировано
    @OneToMany(mappedBy ="owner")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})  // будет каскадирование при вызове метода save()
    private List<Item> items;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public Person( String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person() {
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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

    public void addItem(Item item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }

        this.items.add(item);
        item.setOwner(this);
    }

    @Override
    public String toString() {
        return "Person :" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '.';
    }
}
