package uz.tigersteam.http;

/**
 * @author Nodirbek Abdukarimov Fri. 9:59 AM. 12/24/2021
 */
public class Data<T> {
    private T data;
    private Integer total;

    public Data(T data) {
        this(data, null);
    }

    public Data(T data, Integer total) {
        this.data = data;
        this.total = total;
    }
}
