import java.util.Objects;

public class MyTestingClass {
    private String Name;
    private int Age;
    private int Id;

    public MyTestingClass(String name, int age) {
        Name = name;
        Age = age;
        Id = Id;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Name.hashCode();
        result = 31 * result + Age;
        result = 31 * result + Id;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass()!= obj.getClass()) return false;
        MyTestingClass that = (MyTestingClass) obj;
        return Objects.equals(Name, that.Name) && Objects.equals(Age, that.Age) && Objects.equals(Id, that.Id);
    }
    @Override
    public String toString() {
        return "MyTestingClass{name='" + Name + "', id=" + Id + "}";    }

}