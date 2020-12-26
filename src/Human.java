public class Human extends Person {
    private int age;

    public Human(int age) {
        this.age = age;
    }

    public Human(String name, Gender gender, Emotion emotion, Speed speed, Place place, int age, int x , int y, String describe)  {
        super(name, gender, emotion, speed, place, x, y, describe);
        this.age = age;
    }

    public void ridicule(Person person){
        System.out.println(this.getName() + " смеется над " + person.getName());
    }
}
