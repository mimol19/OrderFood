package pl.orderfood.api.dto;

public class What {
    private String mark;
    private String model;

    public What(String mark, String model) {
        this.mark = mark;
        this.model = model;
    }

    public What() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

//    @Override
//    public String toString() {
//        return "What{" +
//                "mark='" + mark + '\'' +
//                ", model='" + model + '\'' +
//                '}';
//    }
}