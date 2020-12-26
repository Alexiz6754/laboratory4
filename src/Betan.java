public class Betan extends Person{
    public Betan() { }

    public Betan(String name, Gender gender, Emotion emotion, Speed speed, Place place,int x,int y, String describe){
        super(name, gender, emotion, speed, place, x, y, describe);
    }

    public void toCatch(Human ... humans){
        boolean catching = false;
        System.out.println("Бетан начала охоту");
        for (Human human : humans) {
            if (this.getSpeed().ordinal() > human.getSpeed().ordinal()){
                System.out.println("Бетан поймала " + human.getName() + "а");
            } else {
                //System.out.println("Бетан не смогла поймать " + human.getName() + "а");
                human.ridicule(this);
            }
        }

        if (!catching && this.getEmotion() != Emotion.RAGE)
            this.changeEmotion(Emotion.RAGE);
        //System.out.println("Бетан закончила охоту");
    }

    public void banging(Thing.Door door){
        if (this.getEmotion() == Emotion.RAGE)
            System.out.println("Люто колошматит по " + door.toString());
        else
            System.out.println("Стучит по" + door.toString());
    }

}
