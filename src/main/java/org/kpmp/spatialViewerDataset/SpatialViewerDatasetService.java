package org.kpmp.spatialViewerDataset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SpatialViewerDatasetService  {

	private SpatialViewerExternalLinkRepository externalLinkRepo;
	private SpatialViewerFileDatasetRepository fileRepo;

	@Autowired
	public SpatialViewerDatasetService(SpatialViewerExternalLinkRepository externalLinkRepo, SpatialViewerFileDatasetRepository fileRepo) {
		this.externalLinkRepo = externalLinkRepo;
		this.fileRepo = fileRepo;
	}

	//public List<SpatialViewerFileDataset> getSpatialViewerDataset() throws Exception {
  public void getSpatialViewerDataset() throws Exception {
    List<SpatialViewerFileDataset> files = fileRepo.findAll();
    List<SpatialViewerExternalLinkDataset> externalLinks = externalLinkRepo.findAll();
    //return externalLinks;
	}

}
