package com.trackline.tracking.controllers;
import com.trackline.tracking.exceptions.ResponseModel;
import com.trackline.tracking.models.TypeModel;
import com.trackline.tracking.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api/type/")

public class TypeController {

    @Autowired
    TypeService typeService;


    @GetMapping("getall")
    public List<TypeModel> getAll(){
        return typeService.getAll();
    }

    @GetMapping("getbyid/{id}")
    public Optional<TypeModel> getById(@PathVariable Long id) {

        return typeService.getById(id);


    }


    @PostMapping("add")
    public ResponseModel add(@RequestBody TypeModel type)  {

            return typeService.Add(type);

    }

    @DeleteMapping("delete/{id}")
    public ResponseModel delete(@PathVariable  Long id){
        return typeService.Delete(id);
    }

    @PutMapping("update")
    public ResponseModel  update(@RequestBody TypeModel type){
        return typeService.Update(type);
    }


}
