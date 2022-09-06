package com.trackline.tracking.controllers;
import com.trackline.tracking.exceptions.ResponseModel;
import com.trackline.tracking.models.LocationModel;
import com.trackline.tracking.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/location/")

public class LocationController {

    @Autowired
    LocationService locationService;


    @GetMapping("getall")
    public List<LocationModel> getLocation(){
        return locationService.getLocation();
    }

    @GetMapping("getlocationbyid/{id}")
    public Optional<LocationModel> getLocationById(@PathVariable Long id) {

        return locationService.getLocationById(id);


    }


    @PostMapping("addlocation")
    public ResponseModel addLocation(@RequestBody LocationModel location)  {

        return locationService.AddLocation(location);

    }

    @DeleteMapping("delete/{id}")
    public void deleteLocation(@PathVariable  Long id){
        locationService.DeleteLocation(id);
    }

    @PutMapping("updatelocation")
    public ResponseModel  updateLocation(@RequestBody LocationModel location){
        return locationService.UpdateLocation(location);
    }


}
