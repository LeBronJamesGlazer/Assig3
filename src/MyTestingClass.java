// A sample class used for testing hash-based data structures (e.g., MyHashTable)
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

    // Generates a hash code based on Name, Age, and Id fields
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Name.hashCode();
        result = 31 * result + Age;
        result = 31 * result + Id;
        return result;
    }
    // Compares two MyTestingClass objects for equality based on Name, Age, and Id
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass()!= obj.getClass()) return false;
        MyTestingClass that = (MyTestingClass) obj;
        return Objects.equals(Name, that.Name) && Objects.equals(Age, that.Age) && Objects.equals(Id, that.Id);
    }
    // Returns a string representation of the object, showing Name and Id
    @Override
    public String toString() {
        return "MyTestingClass{name='" + Name + "', id=" + Id + "}";    }

}