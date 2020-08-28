public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int leftOrRight = 0;

        if (age > anotherCat.age) leftOrRight -= 1;
        else if (age < anotherCat.age) leftOrRight += 1;

        if (weight > anotherCat.weight) leftOrRight -= 1;
        else if (weight < anotherCat.weight) leftOrRight += 1;

        if (strength > anotherCat.strength) leftOrRight -= 1;
        else if (strength < anotherCat.strength) leftOrRight += 1;
        
        return leftOrRight <= 0;
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.age = 6;
        cat1.strength = 8;
        cat1.weight = 5;
        Cat cat2 = new Cat();
        cat2.age = 7;
        cat2.strength = 9;
        cat2.weight = 4;

        System.out.println(cat1.fight(cat2));
    }
}
