package arcaDeNoe.model;

import java.util.List;
import java.util.Objects;

public class Animal {
    private String type;
    private String animal;
    private String sex;
    private int age;
    private List<Movement> movements;
    private List<Habitat> habitats;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    public List<Habitat> getHabitats() {
        return habitats;
    }

    public void setHabitats(List<Habitat> habitats) {
        this.habitats = habitats;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, animal, habitats, movements, sex, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        return Objects.equals(age, other.age) && Objects.equals(animal, other.animal)
                && Objects.equals(habitats, other.habitats) && Objects.equals(movements, other.movements)
                && Objects.equals(sex, other.sex) && Objects.equals(type, other.type);
    }

    @Override
    public String toString() {
        return "Animal [type=" + type + ", animal=" + animal + ", sex=" + sex + ", age=" + age + ", movements="
                + movements + ", habitats=" + habitats + "]";
    }

    //Construtores

    public Animal() {
        super();
    }

    public Animal(String type, String animal, String sex, int age, List<Movement> movements,
                  List<Habitat> habitats) {
        super();
        this.type = type;
        this.animal = animal;
        this.sex = sex;
        this.age = age;
        this.movements = movements;
        this.habitats = habitats;
    }
}
