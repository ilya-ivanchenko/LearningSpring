package by.epam.ivanchenko.repository;


import by.epam.ivanchenko.model.Item;
import by.epam.ivanchenko.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

     List<Item> findByItemName(String itemName);

     List<Item> findByOwner(Person owner);

}
