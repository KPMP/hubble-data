package org.kpmp;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.kpmp.spatialViewerDataset.SpatialViewerDataset;
import org.kpmp.spatialViewerDataset.SpatialViewerDatasetRepository;
import org.kpmp.spatialViewerDataset.SpatialViewerExternalLink;
import org.kpmp.spatialViewerDataset.SpatialViewerExternalLinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

	private SpatialViewerDatasetRepository spatialViewerDatasetRepository;
	private SpatialViewerExternalLinkRepository spatialViewerExternalLinkRepository;
	private Logger logger = LoggerFactory.getLogger(Query.class);

	@Autowired
	public Query(
		SpatialViewerDatasetRepository spatialViewerDatasetRepository,
		SpatialViewerExternalLinkRepository spatialViewerExternalLinkRepository
	) {
		this.spatialViewerDatasetRepository = spatialViewerDatasetRepository;
		this.spatialViewerExternalLinkRepository = spatialViewerExternalLinkRepository;
	}

	public List<SpatialViewerDataset> getSpatialViewerDataset() throws IOException, Exception {
		return spatialViewerDatasetRepository.findAll();
	}

	public List<SpatialViewerExternalLink> getSpatialViewerExternalLink() throws IOException, Exception {
		return spatialViewerExternalLinkRepository.findAll();
	}
}
