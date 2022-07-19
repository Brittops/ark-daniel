package arcaDeNoe.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.util.List;

public class Ark {

    public static void main(String[] args) throws Exception {

        DistinctAnimals distinctAnimals = new DistinctAnimals();
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(new FileReader("resources/animalsList.json"));

        List<Animal> animals = gson.fromJson(jsonReader, new TypeToken<List<Animal>>() {
        }.getType());

        List<Animal> arkCouples =
                distinctAnimals.createCouples(
                        distinctAnimals.createFemalesList(distinctAnimals.filterSpecies(animals)),
                        distinctAnimals.createMalesList(distinctAnimals.filterSpecies(animals)));

        animals.forEach(StdOut::println);
        StdOut.println("\n\n\n\n");
        arkCouples.forEach(StdOut::println);
        StdOut.println("Animais na arca: " + arkCouples.size());

        /*
        *
        * Quantos animais, discriminados por type, animal e sexo, não sobreviverão ao dilúvio?
        *
        */


    }

}
