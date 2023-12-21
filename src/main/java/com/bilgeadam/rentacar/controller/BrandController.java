package com.bilgeadam.rentacar.controller;
import com.bilgeadam.rentacar.entities.Brand;
import com.bilgeadam.rentacar.services.BrandService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
public class BrandController {
    private final BrandService brandService;
    public BrandController (BrandService brandService){
        this.brandService = brandService;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Brand> getAllBrands (){
        return brandService.getAllBrands();
    }

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public Brand saveBrand (@RequestBody Brand brand){
        return brandService.saveBrand(brand);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Brand updateBrand (@RequestBody Brand brand) {
        return  brandService.updateBrand(brand);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteBrandId(@PathVariable("id")Integer id){
        brandService.deleteBrand(id);
        return "Silme işlemi başarılı";
    }
}
