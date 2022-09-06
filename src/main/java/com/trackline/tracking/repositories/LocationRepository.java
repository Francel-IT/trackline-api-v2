package com.trackline.tracking.repositories;
import com.trackline.tracking.models.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationModel, Long> {
    LocationModel findByLocationIgnoreCase(String location);
    Boolean existsByIdAndLocationIgnoreCase(Long id, String location);
}
