public class Thing {

    public static class Key extends Thing{
        private int id;
        public Key() {
            this.id = -1;
        }

        public Key(int id){
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return super.hashCode() + id;
        }

        @Override
        public String toString() {
            return "Ключ с id:" + id;
        }
    }

    public static class Door extends Thing implements Openable{
        private boolean open;
        private boolean lock;
        private int id;

        public Door() {
            this.open = true;
            this.lock = false;
            this.id = -1;
        }

        public Door(boolean open,boolean lock,int id){
            this.open = open;
            this.lock = lock;
            this.id = id;
        }

        public boolean isOpen() {
            return open;
        }

        public boolean isLock() {
            return lock;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public void changeOpen(Person person){
            String result;
            if (!this.lock) {
                this.open = !this.open;
            }

            if (this.open){
                result = " открыта " + person.getName();
            } else {
                result = " закрыта " + person.getName();
            }

            System.out.println(toString() + result);
        }

        @Override
        public void changeLock(Key key){
            String result;
            if (!this.open){
                if (key.getId() == this.id) {
                    this.lock = !this.lock;
                }
            }

            if (this.lock){
                result = " закрыта на " + key.toString();
            } else {
                result = " открыта " + key.toString();
            }

            if (key.getId() != this.id){
                result = " не подходит " + key.toString();
            }

            System.out.println(toString() + result);
        }

        @Override
        public int hashCode() {
            return super.hashCode() + id;
        }

        @Override
        public String toString() {
            return "Дверь с id:" + id;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        return this.hashCode() == obj.hashCode();
    }
}
