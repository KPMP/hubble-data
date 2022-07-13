package org.kpmp.spatialViewerDataset;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpatialViewerExternalLinkRepository
    extends CrudRepository<SpatialViewerExternalLink, Integer> {

    List<SpatialViewerExternalLink> findAll();

}
