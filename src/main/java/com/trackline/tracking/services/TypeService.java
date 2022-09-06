package com.trackline.tracking.services;

import com.trackline.tracking.exceptions.ConflictException;
import com.trackline.tracking.exceptions.ResourceNotFoundException;
import com.trackline.tracking.exceptions.ResponseModel;
import com.trackline.tracking.models.TypeModel;
import com.trackline.tracking.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    TypeRepository typeRepository;

    public List<TypeModel> getAll() {
        return typeRepository.findByDeletedOrderByIdAsc(false);
    }

    public Optional<TypeModel> getById(Long id) {
        Optional type = typeRepository.findByIdAndDeleted(id, false);

        if (!type.isPresent()) {
            throw new ResourceNotFoundException("Data not found");
        } else {
            return type;
        }
    }


    public ResponseModel Delete(Long id) {
        Optional type = typeRepository.findById(id);
        ResponseModel responseModel = new ResponseModel();
        if (!type.isPresent()) {
            throw new ResourceNotFoundException("Data not found");
        } else {
            TypeModel updateType= typeRepository.getById(id);
            updateType.setDeleted(true);
            typeRepository.save(updateType);
            responseModel.setMessage("Type successfully deleted");
            responseModel.setStatusCode(HttpStatus.OK.value());
            responseModel.setTimeStamp(OffsetDateTime.now());
        }
        return responseModel;

    }

    public ResponseModel Add(TypeModel type) {
        TypeModel model = typeRepository.findByTypeIgnoreCase(type.getType());
        ResponseModel responseModel = new ResponseModel();

        if (model == null) {
            typeRepository.save(type);
            responseModel.setMessage("Type successfully saved");
            responseModel.setStatusCode(HttpStatus.OK.value());
            responseModel.setTimeStamp(OffsetDateTime.now());
        } else {
            throw new ConflictException("Type already exist - " + type.getType());
        }
        return responseModel;
    }

    public ResponseModel Update(TypeModel type) {
        ResponseModel responseModel = new ResponseModel();
        Optional searchType = typeRepository.findById(type.getId());
        if (!searchType.isPresent()) {
            throw new ResourceNotFoundException("Data not found");
        } else {
            TypeModel updateType = typeRepository.getById(type.getId());
            updateType.setType(type.getType());
            updateType.setDescription(type.getDescription());
            updateType.setActive(type.getActive());
            updateType.setUpdatedby(type.getUpdatedby());
            updateType.setDateupdated(type.getDateupdated());

            typeRepository.save(updateType);
            responseModel.setMessage("Type successfully updated");
            responseModel.setStatusCode(HttpStatus.OK.value());
            responseModel.setTimeStamp(OffsetDateTime.now());
        }
        return responseModel;

    }
}


