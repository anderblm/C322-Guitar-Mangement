package edu.iu.anderblm.c322spring2024homework2.Controllers;

import edu.iu.anderblm.c322spring2024homework2.Model.Builder;
import edu.iu.anderblm.c322spring2024homework2.Model.Guitar;
import edu.iu.anderblm.c322spring2024homework2.Model.Type;
import edu.iu.anderblm.c322spring2024homework2.Model.Wood;
import edu.iu.anderblm.c322spring2024homework2.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @GetMapping("/search")
    public List<Guitar> searchGuitars(
            @RequestParam Builder builder,
            @RequestParam Wood backWood,
            @RequestParam String model,
            @RequestParam Type type,
            @RequestParam Wood topWood,
            @RequestParam String serialNumber,
            @RequestParam double price
    ) {
        return inventoryRepository.search(new Guitar(serialNumber, price, builder, model, type, backWood, topWood));
    }

    @PostMapping("/add")
    public void addGuitar(@RequestBody Guitar guitar) {
        inventoryRepository.addGuitar(guitar);
    }

    @GetMapping("/find/{serialNumber}")
    public Guitar findGuitar(@PathVariable String serialNumber) {
        return inventoryRepository.getGuitar(serialNumber);
    }
}

