package com.bilgeadam.rentacar.services;

import com.bilgeadam.rentacar.entities.Brand;
import com.bilgeadam.rentacar.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    private  final BrandRepository brandRepository;

    public BrandService (BrandRepository brandRepository){ this.brandRepository = brandRepository;}
    public List<Brand> getAllBrands(){
        return brandRepository.findAll();
    }

    public Brand saveBrand (Brand brand){return  brandRepository.save(brand);}

    public Brand updateBrand(Brand brand)
    {return brandRepository.save(brand);
    }
    public void deleteBrand(Integer id){brandRepository.deleteById(id);}
}
