package org.kpmp.spatialViewerDataset;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpatialViewerExternalLinkRepository
    extends CrudRepository<SpatialViewerExternalLinkDataset, Integer> {

    List<SpatialViewerExternalLinkDataset> findAll();
    
    @Query (value = "SELECT MAX(release_version) AS max FROM sv_link_v", nativeQuery = true)
    public Double max();
}
