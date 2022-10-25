package coreJAVA.equalsANDhashcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String name;
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(age, employee.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

class Test{
    public static void main(String[] args) {
        Employee e1 = new Employee("austin", 23);
        Employee e2 = new Employee("austin", 23);

        System.out.println(e1.hashCode() == e2.hashCode());
    }
}
