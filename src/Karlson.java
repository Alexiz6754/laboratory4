public class Karlson extends Human{
    Thing.Key key;

    public Karlson(int age) {
        super(age);
        this.key = new Thing.Key();
    }

    public Karlson(String name, Gender gender, Emotion emotion, Speed speed, Place place, int age, int x, int y, Thing.Key key, String describe) {
        super(name, gender, emotion, speed, place, age, x, y, describe);
        this.key = key;
    }

    public Thing.Key getKey() {
        return key;
    }

    public void setKey(Thing.Key key) {
        this.key = key;
    }

    public void toBet(Person ... persons){
        for (Person person: persons) {
            System.out.println(this.getName() + " проиграл спор " + person.getName());
        }
    }
}
