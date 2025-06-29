package Animal.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Zoo {
    private ArrayList<Animal> animals;

    public Zoo() {
        animals = new ArrayList<>();
    }
    
    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println("Đã thêm " + animal.getName());
    }

    public void showMoveAnimal() {
        for (Animal animal : animals)
            animal.move();
    }

    public void showSoundAnimal() {
        for (Animal animal : animals)
            animal.makeSound();
    }

    public void showAnimalList() {
        for (Animal animal : animals)
            System.out.println(animal);
    }

    public void countAnimalByType() {
        int dogCount = 0;
        int catCount = 0;
        int birdCount = 0;

        for (Animal animal : animals) {
            if (animal instanceof Dog)
                dogCount++;
            else if (animal instanceof Cat)
                catCount++;
            else if (animal instanceof Bird)
                birdCount++;
        }

        System.out.println("Số lượng từng loài");
        System.out.println("Dog: " + dogCount);
        System.out.println("Cat: " + catCount);
        System.out.println("Bird: " + birdCount);
    }



    public boolean isAnimalExist(String name, Class<?> type) {
        for (Animal a : animals) {
            if (a.getName().equalsIgnoreCase(name) && a.getClass().equals(type)) {
                return true;
            }
        }
        return false;
    }

    public void data() {
        addAnimal(new Dog("Corgi"));
        addAnimal(new Dog("Shiba"));
        addAnimal(new Dog("Labrador"));
        addAnimal(new Dog("Husky"));
        addAnimal(new Dog("Chihuahua"));

        addAnimal(new Cat("Sphynx"));
        addAnimal(new Cat("Bengal"));
        addAnimal(new Cat("Siberian"));
        addAnimal(new Cat("Maine Coon"));
        addAnimal(new Cat("Savannah"));

        addAnimal(new Bird("Pigeon"));
        addAnimal(new Bird("Eagle"));
        addAnimal(new Bird("Falcon"));
        addAnimal(new Bird("Sparrow"));
        addAnimal(new Bird("Parrot"));
    }

}
