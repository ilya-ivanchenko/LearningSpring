package by.epam.ivanchenko.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
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

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)                                                    // Тип даты из объекта сконвертируется в тип даты в БД
    @DateTimeFormat(pattern = "dd/MM/yyyy")                                         // Парсинг строки  в дату - в объект Date
    private Date dateOfBirth;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

//    @Enumerated(EnumType.ORDINAL)                                                  // Для сохранения Enum в БД. ORDINAL - enum переводится в индексы 0,1,2...
                                                                                     // Но, тогда нельзя менять порядок перечислений в классе Enum
    @Enumerated(EnumType.STRING)                                                     // STRING - Enum сохр. под своим именем, порядок перечислений любой
    private Mood mood;

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (age != person.age) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (email != null ? !email.equals(person.email) : person.email != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(person.dateOfBirth) : person.dateOfBirth != null) return false;
        if (createdAt != null ? !createdAt.equals(person.createdAt) : person.createdAt != null) return false;
        return mood == person.mood;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (mood != null ? mood.hashCode() : 0);
        return result;
    }
}
