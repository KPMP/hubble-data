package org.kpmp.spatialViewerDataset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

@Service
public class SpatialViewerDatasetService  {

	private SpatialViewerExternalLinkRepository externalLinkRepo;
	private SpatialViewerFileDatasetRepository fileRepo;

	@Autowired
	public SpatialViewerDatasetService(SpatialViewerExternalLinkRepository externalLinkRepo,
		 SpatialViewerFileDatasetRepository fileRepo) {
		this.externalLinkRepo = externalLinkRepo;
		this.fileRepo = fileRepo;
	}

  public List<SpatialViewerDataset> getSpatialViewerDataset() throws Exception {
    List <SpatialViewerDataset> datasets = new ArrayList<>();
    datasets.addAll(externalLinkRepo.findAll());
    datasets.addAll(fileRepo.findAll());
    return datasets;
}

	public List<SpatialViewerFileDataset> getSpatialViewerFileDataset() throws IOException, Exception {
		return fileRepo.findAll();
	}

	public List<SpatialViewerExternalLinkDataset> getSpatialViewerExternalLink() throws IOException, Exception {
		return externalLinkRepo.findAll();
	}

}
