public class Main {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Cat tom = new Cat("Tom", 50, 30);
        Cat barsik = new Cat("Barsik", 44, 35);
        Dog sharik =  new Dog("Sharik", 83, 29);
    }
}

class Mouse extends Animal {
    Mouse(String name, int height, int tail) {
        super(name, height, tail);
    }
}

class Cat extends Animal {
    Cat(String name, int height, int tail) {
        super(name, height, tail);
    }
}

class Dog extends Animal {
    Dog(String name, int height, int tail) {
        super(name, height, tail);
    }
}

abstract class Animal {
    String name;
    int height;
    int tail;

    Animal(String name, int height, int tail) {
        this.name = name;
        this.height = height;
        this.tail = tail;
    }
}

