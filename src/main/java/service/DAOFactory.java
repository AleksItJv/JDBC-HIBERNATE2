package service;

import dao.IDAOFactory;

public class DAOFactory implements IDAOFactory {

    private static IDAOFactory factory;

    private DAOFactory() {

    }

    public static IDAOFactory getInstance() {
        if (factory == null) {
            return new DAOFactory();
        }
        return factory;
    }

    @Override
    public AnimalService getAnimalService() {
        return new AnimalService();
    }
}
