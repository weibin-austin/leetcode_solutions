package entity;

public class Student {
    public int id;
    public String name;
    public int product;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.product = id * name.charAt(0);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", product=" + product +
                '}';
    }
}
