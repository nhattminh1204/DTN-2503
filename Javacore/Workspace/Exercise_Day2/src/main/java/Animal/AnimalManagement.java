package Animal;

import Animal.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalManagement {
    static Zoo zoo = new Zoo();
    static Scanner sc = new Scanner(System.in);
    static List<Animal> animals = new ArrayList<>();

    public static void showMenu() {
        while (true) {
            System.out.println("\n--------------- QUẢN LÝ SỞ THÚ ---------------");
            System.out.println("1. Danh sách động vật có trong sở thú");
            System.out.println("2. Thêm động vật");
            System.out.println("3. Xem tiếng kêu động vật");
            System.out.println("4. Xem cách di chuyển");
            System.out.println("5. Thống kê số lượng loài");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    zoo.showAnimalList();
                    break;
                case 2:
                    addAnimalMenu();
                    break;
                case 3:
                    zoo.showSoundAnimal();
                    break;
                case 4:
                    zoo.showMoveAnimal();
                    break;
                case 5:
                    zoo.countAnimalByType();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        }
    }

    public static void data() {
        zoo.data();
    }

    public static void addAnimalMenu() {
        Animal animal = null;
        boolean validChoice = false;

        while (!validChoice) {
            System.out.println("Danh sách các loài động vật: ");
            System.out.println("1. Dog");
            System.out.println("2. Cat");
            System.out.println("3. Bird");
            System.out.print("Chọn loài: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    animal = new Dog("");
                    validChoice = true;
                    break;
                case 2:
                    animal = new Cat("");
                    validChoice = true;
                    break;
                case 3:
                    animal = new Bird("");
                    validChoice = true;
                    break;
                default:
                    System.out.println("Loài không hợp lệ, vui lòng chọn lại.");
                    break;
            }
        }

        while (true) {
            System.out.print("Nhập tên động vật: ");
            String name = sc.nextLine();

            if (zoo.isAnimalExist(name, animal.getClass())) {
                System.out.println("Động vật này đã tồn tại! Vui lòng nhập tên khác.");
            } else {
                animal.setName(name);
                zoo.addAnimal(animal);
                break;
            }
        }
    }


}
