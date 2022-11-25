package by.epam.ivanchenko.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name shouldn't not be empty!")
    @Size(min = 2, max = 30, message = "Name is too short or too long")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "Age should be more than 0")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "Email shouldn't not be empty!")
    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;



    @OneToMany(mappedBy = "owner")
    private List<Item> items;

    // Country, City, Code (6 numbers)
//    @Pattern(regexp = "[A-Z][a-z]+, [A-Z][a-z]+, \\d{6}", message = "Your address should be in this format: Country, City, Code (6 numbers)")
//    private String address;
    public Person() {
    }

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
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
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Person: " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '.';
    }
}
