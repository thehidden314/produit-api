package com.produit.produitservice.controller;

import com.produit.produitservice.model.Produit;
import com.produit.produitservice.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/produits")
@RequiredArgsConstructor
public class ProduitController {
    private final ProduitService produitService;
    @GetMapping("{id}")
    public Produit getProduitById(@PathVariable long id){
        return produitService.getProduitById(id);
    }
    @GetMapping("/allproduit")
    public List<Produit> getAllProduits()
    {
        return produitService.getAllProduits();
    }
    @PostMapping
    public Produit createProduit(@RequestBody Produit produit){
        return produitService.createProduit(produit);
    }
    @PutMapping("{id}")
    public Produit updateProduitById(@PathVariable long id, @RequestBody Produit produit){
        return produitService.updateProduitById(id, produit);
    }
    @DeleteMapping("{id}")
    public String deleteProduitById(@PathVariable long id){
        return produitService.deleteProduitById(id);
    }

}
