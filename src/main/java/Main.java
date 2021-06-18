import connector.HibernateUtil;
import dao.IDAOFactory;
import entity.Animal;
import service.AnimalService;
import service.DAOFactory;

public class Main {
    public static void main(String[] args) {

        IDAOFactory factory = DAOFactory.getInstance();
        AnimalService as = factory.getAnimalService();
        Animal animal = new Animal();
        animal.setAge(5);
        animal.setName("Kit");
        animal.setTail(true);
        as.save(animal);

        System.out.println(as.getAnimal(2));
        as.updateAnimal(30, 1);
        as.deleteAnimal(3);

        HibernateUtil.shutdown();
    }


}
