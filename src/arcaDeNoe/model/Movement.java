package arcaDeNoe.model;

import java.util.Objects;

public class Movement {
    private String movement;

    public String getMovement() {
        return this.movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    @Override
    public String toString() {
        return "Movement [movement=" + movement + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(movement);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movement other = (Movement) obj;
        return Objects.equals(movement, other.movement);
    }

    //Construtores

    public Movement() {
        super();
    }

    public Movement(String movement) {
        super();
        this.movement = movement;
    }
}
