public class ExistException extends NullPointerException{
    private String exception;

    {
        this.exception = "Порядок";
    }

    ExistException(String message){
        super(message + " не инициализировано");
        this.exception = "Поле" + message + " не инициализировано";
    }

    public String getDescribe() {
        return exception;
    }
}
