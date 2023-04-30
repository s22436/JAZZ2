package pl.pjatk.domhin.Example.model;

public class Car {

    private String model;
    private String mark;
    private String vim;

    public Car(String model, String mark, String vim) {
        this.model = model;
        this.mark = mark;
        this.vim = vim;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", mark='" + mark + '\'' +
                ", vim='" + vim + '\'' +
                '}';
    }
}
