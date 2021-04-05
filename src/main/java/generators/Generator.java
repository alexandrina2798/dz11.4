package generators;

public interface Generator<T> {

    //void generateParams(int code);

    T buildResponse(int code);
}
