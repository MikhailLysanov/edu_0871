public class Main {
    public static void main(String[] args) {
        Horse horse = new Horse(10, "Лошадь");
        Pegasus pegasus = new Pegasus(50, "Пегас");
        horse.run();
        pegasus.fly();
    }
}

abstract class Animal {
    int age;
    String name;

    Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

class Horse extends Animal {
    Horse(int age, String name) {
        super(age, name);
    }

    void run() {
        System.out.println("Игого, я поскакал(а)");
    }
}

class Pegasus extends Horse {
    Pegasus(int age, String name) {
        super(age, name);
    }

    void fly() {
        System.out.println("Игого, я полетел(а)");
    }
}
