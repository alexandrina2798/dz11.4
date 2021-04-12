package generators;

public interface Generator<T> {


    T buildResponse(int code);
}
