package arcaDeNoe.model;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

import edu.princeton.cs.introcs.StdOut;

public class DistinctAnimals {

    //Filtrando animais discriminando por classe, modo de locomoção e "habitat"
    public List<Animal> filterSpecies(List<Animal> animals) {
        List<Animal> filteredSpecies = new ArrayList<>();

        for (Animal animal : animals) {
            if (!canFly(animal) && !isAmphibian(animal) && isTerrestrial(animal)) {
                filteredSpecies.add(animal);
            }
        }
        return filteredSpecies;
    }
    //Filtrando animais discriminados pelo macho mais jovem de cada espécie
    public List<Animal> createMalesList(List<Animal> arkAnimals) {
        List<Animal> males = new ArrayList<>();

        for (int i = 0; i < arkAnimals.size(); i++) {
            if (isMale(arkAnimals.get(i))) {
                males.add(arkAnimals.get(i));
                for (int j = 0; j < arkAnimals.size(); j++) {
                    if (i != j) {
                        if (areSameSpecie(arkAnimals.get(i), arkAnimals.get(j))) {
                            if (isMale(arkAnimals.get(j))) {
                                if (arkAnimals.get(i).getAge() <= arkAnimals.get(j).getAge()) {
                                    if (males.indexOf(arkAnimals.get(j)) != males.size() - 1) {
                                        males.remove(arkAnimals.get(j));
                                    }
                                } else {
                                    males.remove(arkAnimals.get(i));
                                }
                            }
                        }
                    }
                }
            }
        }
        return males;
    }
    //Filtrando animais discriminados pela fêmea mais jovem de cada espécie
    public List<Animal> createFemalesList(List<Animal> arkAnimals) {
        List<Animal> females = new ArrayList<>();

        for (int i = 0; i < arkAnimals.size(); i++) {
            if (isFemale(arkAnimals.get(i))) {
                females.add(arkAnimals.get(i));
                for (int j = 0; j < arkAnimals.size(); j++) {
                    if (i != j) {
                        if (areSameSpecie(arkAnimals.get(i), arkAnimals.get(j))) {
                            if (isFemale(arkAnimals.get(j))) {
                                if (arkAnimals.get(i).getAge() <= arkAnimals.get(j).getAge()) {
                                    if (females.indexOf(arkAnimals.get(j)) != females.size() - 1) {
                                        females.remove(arkAnimals.get(j));
                                    }
                                } else {
                                    females.remove(arkAnimals.get(i));
                                }
                            }
                        }
                    }
                }
            }
        }
        return females;
    }
    //Juntando machos e fêmeas em casais para a lista final da arca
    public List<Animal> createCouples(List<Animal> females, List<Animal> males) {
        List<Animal> arkCouples = new ArrayList<>();

        for (Animal female : females) {
            for (Animal male : males) {
                if (female.getAnimal().equals(male.getAnimal())) {          //filtro de animais que formaram casais
                    arkCouples.add(female);
                    arkCouples.add(male);
                }
            }
        }
        return arkCouples;
    }

    //Criando um arquivo JSON
    public void createJSONFile (List<Animal> animals, String jsonFileName ) {
        Gson gson = new Gson();
        JSONArray listAnimal = new JSONArray();
        listAnimal.add(animals);
        String s = gson.toJson(animals);
        try (FileWriter file = new FileWriter(".\\resources\\"+jsonFileName+".json")) {

            file.write(s);
            file.flush();
            StdOut.println("Arquivo .json criado com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Verificando se o animal é anfíbio
    public boolean isAmphibian(Animal animal) {
        return animal.getType().equals("Amphibians");
    }

    //Verificando se o animal pode voar
    public boolean canFly(Animal animal) {
        for (Movement movement : animal.getMovements()) {
            return movement.getMovement().equalsIgnoreCase("fly");
        }
        return false;
    }

    //Verificando se o animal é terrestre
    public boolean isTerrestrial(Animal animal) {
        for (Habitat habitat : animal.getHabitats()) {
            return habitat.getHabitat().equalsIgnoreCase("terrestrial");
        }
        return false;
    }

    //Verificando se o animal é do sexo masculino
    public boolean isMale(Animal animal) {
        return animal.getSex().equalsIgnoreCase("male");
    }

    //Verificando se o animal é do sexo feminino
    public boolean isFemale(Animal animal) {
        return animal.getSex().equalsIgnoreCase("female");
    }

    //Verificando se dois animais são da mesma espécie
    public boolean areSameSpecie(Animal animalOne, Animal animalTwo) {
        return animalOne.getAnimal().equals(animalTwo.getAnimal());
    }
}
