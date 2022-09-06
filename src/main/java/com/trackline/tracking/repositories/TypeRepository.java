package com.trackline.tracking.repositories;

import com.trackline.tracking.models.TypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<TypeModel, Long> {

    TypeModel findByTypeIgnoreCase(String type);
    Boolean existsByIdAndTypeIgnoreCase(Long id, String type);
    Optional<TypeModel> findByIdAndDeleted(Long id, Boolean deleted);
    List<TypeModel> findByDeletedOrderByIdAsc(Boolean deleted);

}
