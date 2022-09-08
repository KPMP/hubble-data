package org.kpmp.spatialViewerDataset;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpatialViewerFileDatasetRepository
        extends CrudRepository<SpatialViewerFileDataset, Integer> {

    List<SpatialViewerFileDataset> findAll();

}
