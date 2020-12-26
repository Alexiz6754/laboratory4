public class CorrectNameException extends Exception{
    private String exception;

    {
        this.exception = "Порядок";
    }

    public CorrectNameException(String message) {
        super(message);
        this.exception = message;
    }

    public String getDescribe() {
        return exception;
    }
}
