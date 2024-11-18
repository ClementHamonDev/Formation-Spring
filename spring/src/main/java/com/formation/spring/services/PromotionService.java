package com.formation.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.formation.spring.entities.Promotion;
import com.formation.spring.repositories.PromotionRepository;

import java.util.List;

@Service
public class PromotionService {
    @Autowired
    private PromotionRepository promotionRepository;

    public List<Promotion> findAll() {
        return promotionRepository.findAll();
    }

    public Promotion findById(Long id) {
        return promotionRepository.findById(id).orElse(null);
    }

    public Promotion save(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    public void deleteById(Long id) {
        promotionRepository.deleteById(id);
    }

    public List<Promotion> findByProductId(Long productId) {
        return promotionRepository.findByProductId(productId);
    }
}
