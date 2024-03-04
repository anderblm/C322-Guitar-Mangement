package edu.iu.anderblm.c322spring2024homework2.Repository;

import edu.iu.anderblm.c322spring2024homework2.Model.Guitar;
import org.springframework.stereotype.Repository;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InventoryRepository {

    private List<Guitar> guitars;

    public InventoryRepository() {
        this.guitars = new ArrayList<>();
    }

    public void addGuitar(Guitar guitar) {
        guitars.add(guitar);
        guitar.writeToFile();
    }

    public Guitar getGuitar(String serialNumber) {
        for (Guitar guitar : guitars) {
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

    public List<Guitar> getGuitars() {
        return new ArrayList<>(guitars);
    }

    public List<Guitar> search(Guitar searchGuitar) {
        List<Guitar> matchingGuitars = new ArrayList<>();
        for (Guitar guitar : guitars) {
            if ((searchGuitar.getBuilder() == null || searchGuitar.getBuilder().equals(guitar.getBuilder()))
                    && (searchGuitar.getModel() == null || searchGuitar.getModel().equals(guitar.getModel()))
                    && (searchGuitar.getType() == null || searchGuitar.getType().equals(guitar.getType()))
                    && (searchGuitar.getBackWood() == null || searchGuitar.getBackWood().equals(guitar.getBackWood()))
                    && (searchGuitar.getTopWood() == null || searchGuitar.getTopWood().equals(guitar.getTopWood()))) {
                matchingGuitars.add(guitar);
            }
        }
        return matchingGuitars;
    }
}

