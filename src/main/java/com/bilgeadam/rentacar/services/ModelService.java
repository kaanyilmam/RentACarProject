package com.bilgeadam.rentacar.services;

import com.bilgeadam.rentacar.entities.Model;
import com.bilgeadam.rentacar.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {
    private  final ModelRepository modelRepository;

    public ModelService (ModelRepository modelRepository){
        this.modelRepository = modelRepository;
    }
    public List<Model> getAllModels(){
      return  modelRepository.findAll();
    }

    public Model saveModel (Model model){
        return modelRepository.save(model);
    }
    public Model updateModel(Model model){
        return modelRepository.save(model);
    }
    public void deleteModel(Integer id){
         modelRepository.deleteById(id);
    }
}
