package com.Microservices.StockService.Controller;

import com.Microservices.StockService.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    /*@GetMapping("/CreateNewStock/{productId}/{unitPrice}/{quantity}")
    public ResponseEntity<String> addNewProductStock(@PathVariable Long productId, @PathVariable double unitPrice, @PathVariable int quantity) {
        stockService.addNewProductStock(productId, unitPrice, quantity);
        return ResponseEntity.ok("New product stock created successfully");
    }*/

    @PutMapping("/add/{productId}/{quantity}")
    public ResponseEntity<String> addQuantityToStock(@PathVariable Long productId, @PathVariable int quantity) {
        stockService.addQuantityToStock(productId, quantity);
        return ResponseEntity.ok("Quantity added to stock successfully");
    }

    @PutMapping("/remove/{productId}/{quantity}")
    public ResponseEntity<String> removeQuantityFromStock(@PathVariable Long productId, @PathVariable int quantity) {
        try {
            stockService.removeQuantityFromStock(productId, quantity);
            return ResponseEntity.ok("Quantity removed from stock successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
