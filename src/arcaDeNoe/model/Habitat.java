package arcaDeNoe.model;

import java.util.Objects;

public class Habitat {
    private String habitats;

    public String getHabitat() {
        return this.habitats;
    }

    private void setHabitat(String habitats) {
        this.habitats = habitats;
    }

    @Override
    public String toString() {
        return "Habitat [habitats=" + habitats + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(habitats);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Habitat other = (Habitat) obj;
        return Objects.equals(habitats, other.habitats);
    }

    //Construtores

    public Habitat() {
        super();
    }

    public Habitat(String habitats) {
        super();
        this.habitats = habitats;
    }
}
