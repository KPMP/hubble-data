package org.kpmp.spatialViewerDataset;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpatialViewerDatasetRepository
        extends CrudRepository<SpatialViewerDataset, Integer> {

    List<SpatialViewerDataset> findAll();

}
