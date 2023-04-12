package nextstep.helloworld.mvc.exceptions.exception;

public class CustomException extends RuntimeException {

    @Override
    public String getMessage() {
        return "CustomException";
    }
}
