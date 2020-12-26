public abstract class Place implements Standartable{
    private boolean state;//описывает открытость/закрытость локации
    private String name;

    public Place(){
        this.name = "Где-то";
        this.state = true;
    }

    public Place (String name,boolean state){
        try{
            if (name.equals("")){
                throw new CorrectNameException("Имя не может быть пустым");
            }
        } catch (CorrectNameException e){
            e.printStackTrace();
            name = "Забытое место";
        } finally {
            this.name = name;
        }

        this.state = state;
    }

    public void describe(){
        System.out.println("Где-то");
    }

    public boolean canChange(){
        if (this.state){
            return true;
        } else {
            return false;
        }
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        if (name == null){
            throw new ExistException("Имя");
        }

        try{
            if (name.equals("")){
                throw new CorrectNameException("Имя не может быть пустым");
            }
        } catch (CorrectNameException e){
            e.printStackTrace();
            name = "Забытое место";
        } finally {
            this.name = name;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode() + name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return name + (state ? " открытое для входа" : " закрытое для входа");
    }
}
