package by.epam.ivanchenko.model;

import javax.persistence.*;
import javax.validation.constraints.*;
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

//    @NotEmpty(message = "Email shouldn't not be empty!")
//    @Email(message = "Email should be valid")
//    private String email;

    // Country, City, Code (6 numbers)
//    @Pattern(regexp = "[A-Z][a-z]+, [A-Z][a-z]+, \\d{6}", message = "Your address should be in this format: Country, City, Code (6 numbers)")
//    private String address;
    public Person() {
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
