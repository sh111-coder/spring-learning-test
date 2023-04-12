package nextstep.helloworld.mvc.exceptions.exception;

public class HelloException extends RuntimeException {

    @Override
    public String getMessage() {
        return "HelloException";
    }
}
