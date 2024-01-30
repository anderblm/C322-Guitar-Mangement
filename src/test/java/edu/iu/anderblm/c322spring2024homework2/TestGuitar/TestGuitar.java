package edu.iu.anderblm.c322spring2024homework2.TestGuitar;


import edu.iu.anderblm.c322spring2024homework2.Model.Guitar;
import edu.iu.anderblm.c322spring2024homework2.Repository.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {

    private InventoryRepository inventoryRepository;

    @BeforeEach
    void setUp() {
        inventoryRepository = new InventoryRepository();
    }

    @Test
    void addGuitar_shouldAddGuitarToInventory() {
        // Arrange
        Guitar guitar = new Guitar("123", 1000.0, "Fender", "Stratocaster", "Electric", "Alder", "Maple");

        // Act
        inventoryRepository.addGuitar(guitar);

        // Assert
        List<Guitar> guitars = inventoryRepository.getGuitars();
        assertTrue(guitars.contains(guitar));
    }

    @Test
    void addGuitar_shouldWriteToFile() {
        // Arrange
        Guitar guitar = new Guitar("456", 1500.0, "Gibson", "Les Paul", "Electric", "Mahogany", "Maple");

        // Act
        inventoryRepository.addGuitar(guitar);

        // Assert
        // Add assertions to check if the guitar was written to the file
    }

    @Test
    void getGuitar_shouldReturnGuitarIfExists() {
        // Arrange
        Guitar existingGuitar = new Guitar("789", 1200.0, "PRS", "Custom 24", "Electric", "Mahogany", "Maple");
        inventoryRepository.addGuitar(existingGuitar);

        // Act
        Guitar retrievedGuitar = inventoryRepository.getGuitar("789");

        // Assert
        assertNotNull(retrievedGuitar);
        assertEquals(existingGuitar, retrievedGuitar);
    }

    @Test
    void getGuitar_shouldReturnNullIfNotExists() {
        // Arrange

        // Act
        Guitar retrievedGuitar = inventoryRepository.getGuitar("nonexistent");

        // Assert
        assertNull(retrievedGuitar);
    }

    @Test
    void search_shouldReturnMatchingGuitars() {
        // Arrange
        Guitar searchGuitar = new Guitar(null, 0.0, "Fender", null, "Electric", "Alder", null);
        Guitar matchingGuitar1 = new Guitar("101", 900.0, "Fender", "Stratocaster", "Electric", "Alder", "Maple");
        Guitar matchingGuitar2 = new Guitar("102", 950.0, "Fender", "Telecaster", "Electric", "Alder", "Rosewood");
        inventoryRepository.addGuitar(matchingGuitar1);
        inventoryRepository.addGuitar(matchingGuitar2);

        // Act
        List<Guitar> matchingGuitars = inventoryRepository.search(searchGuitar);

        // Assert
        assertEquals(2, matchingGuitars.size());
        assertTrue(matchingGuitars.contains(matchingGuitar1));
        assertTrue(matchingGuitars.contains(matchingGuitar2));
    }
}

