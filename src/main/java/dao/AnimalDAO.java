package dao;

import entity.Animal;

public interface AnimalDAO {

    //create
    void save(Animal animal);

    //read
    Animal getAnimal (int id);

    //update
    void updateAnimal (int age, int id);

    //delete
    void deleteAnimal (int id);
}
