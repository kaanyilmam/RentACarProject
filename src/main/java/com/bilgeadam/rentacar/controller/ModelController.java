package com.bilgeadam.rentacar.controller;

import com.bilgeadam.rentacar.entities.Model;
import com.bilgeadam.rentacar.services.ModelService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/model")
public class ModelController {
    public final ModelService modelService;
    public ModelController (ModelService modelService){
        this.modelService = modelService;
    }

    @GetMapping(path = "all" , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Model> getAllModels(){
        return  modelService.getAllModels();
    }

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public Model saveModel (@RequestBody Model model){
        return modelService.saveModel(model);
    }

    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Model updateModel(@RequestBody Model model)
    {return  modelService.updateModel(model);}

    @DeleteMapping(path = "/{id}")
    public String deleteModelId(@PathVariable("id")Integer id){
        modelService.deleteModel(id);
        return "Silme işlemi başarılı";
    }
    
}
