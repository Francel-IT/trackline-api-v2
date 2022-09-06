package com.trackline.tracking.services;

import com.trackline.tracking.exceptions.ConflictException;
import com.trackline.tracking.exceptions.ResourceNotFoundException;
import com.trackline.tracking.exceptions.ResponseModel;
import com.trackline.tracking.models.LocationModel;
import com.trackline.tracking.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public List<LocationModel> getLocation(){
        return locationRepository.findAll();
    }

    public Optional<LocationModel> getLocationById(Long id){
        Optional location = locationRepository.findById(id);

        if (!location.isPresent()) {
            throw new ResourceNotFoundException("Data not found");
        } else {
            return location;
        }
    }


    public void DeleteLocation(Long id){
        locationRepository.deleteById(id);
    }

    public ResponseModel AddLocation (LocationModel location){
        LocationModel model=  locationRepository.findByLocationIgnoreCase(location.getLocation());
        ResponseModel responseModel = new ResponseModel();

        if(model==null){
            locationRepository.save(location);
            responseModel.setMessage("Location successfully saved");
            responseModel.setStatusCode(HttpStatus.OK.value());
            responseModel.setTimeStamp(OffsetDateTime.now());
        }else {
            throw new ConflictException("Location already exist - "+ location.getLocation());
        }
        return responseModel;
    }

    public ResponseModel UpdateLocation(LocationModel location){
        ResponseModel responseModel =  new ResponseModel();
        if(locationRepository.existsByIdAndLocationIgnoreCase(location.getId(),location.getLocation())) {
            throw new ConflictException("Location already exist - " + location.getLocation());
        }else{
            locationRepository.save(location);
            responseModel.setMessage("Location successfully updated");
            responseModel.setStatusCode(HttpStatus.OK.value());
            responseModel.setTimeStamp(OffsetDateTime.now());
            return responseModel;
        }
    }


}
