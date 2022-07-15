package org.kpmp;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.kpmp.spatialViewerDataset.SpatialViewerFileDataset;
import org.kpmp.spatialViewerDataset.SpatialViewerFileDatasetRepository;
import org.kpmp.spatialViewerDataset.SpatialViewerExternalLinkDataset;
import org.kpmp.spatialViewerDataset.SpatialViewerExternalLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

	private SpatialViewerFileDatasetRepository spatialViewerDatasetRepository;
	private SpatialViewerExternalLinkRepository spatialViewerExternalLinkRepository;

	@Autowired
	public Query(
		SpatialViewerFileDatasetRepository spatialViewerDatasetRepository,
		SpatialViewerExternalLinkRepository spatialViewerExternalLinkRepository
	) {
		this.spatialViewerDatasetRepository = spatialViewerDatasetRepository;
		this.spatialViewerExternalLinkRepository = spatialViewerExternalLinkRepository;
	}

	public List<SpatialViewerFileDataset> getSpatialViewerDataset() throws IOException, Exception {
		return spatialViewerDatasetRepository.findAll();
	}

	public List<SpatialViewerExternalLinkDataset> getSpatialViewerExternalLink() throws IOException, Exception {
		return spatialViewerExternalLinkRepository.findAll();
	}
}
