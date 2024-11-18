package com.formation.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.formation.spring.entities.Promotion;
import com.formation.spring.services.PromotionService;
import org.springframework.http.HttpStatus;


import java.util.List;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {
    @Autowired
    private PromotionService promotionService;

    @GetMapping
    public List<Promotion> findAll() {
        return promotionService.findAll();
    }

    @GetMapping("/{id}")
    public Promotion findById(@PathVariable Long id) {
        return promotionService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Promotion create(@RequestBody Promotion promotion) {
        return promotionService.save(promotion);
    }

    @PutMapping("/{id}")
    public Promotion update(@PathVariable Long id, @RequestBody Promotion promotion) {
        promotion.setId(id);
        return promotionService.save(promotion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        promotionService.deleteById(id);
    }

    @GetMapping("/product/{productId}")
    public List<Promotion> findByProductId(@PathVariable Long productId) {
        return promotionService.findByProductId(productId);
    }
}
