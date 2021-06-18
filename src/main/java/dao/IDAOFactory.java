package dao;

import entity.Animal;
import service.AnimalService;

public interface IDAOFactory {
    AnimalService getAnimalService();
}
