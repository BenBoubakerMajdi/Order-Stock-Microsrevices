package com.MicroServices.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public void addNewProductStock(Long productId, double unitPrice, int quantity) {
        stockRepository.save(new Stock(productId, unitPrice, quantity));
    }

    @Transactional
    public void addQuantityToStock(Long productId, int quantityToAdd) {
        Stock stock = stockRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Stock for product ID " + productId + " not found"));

        stock.setQuantity(stock.getQuantity() + quantityToAdd);
        stockRepository.save(stock);
    }

    @Transactional
    public void removeQuantityFromStock(Long productId, int quantityToRemove) {
        Stock stock = stockRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Stock for product ID " + productId + " not found"));

        if (stock.getQuantity() < quantityToRemove) {
            throw new IllegalArgumentException("Insufficient stock quantity for product ID " + productId);
        }

        stock.setQuantity(stock.getQuantity() - quantityToRemove);
        stockRepository.save(stock);
    }
}
