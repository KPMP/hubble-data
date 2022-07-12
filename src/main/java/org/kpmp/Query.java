package org.kpmp;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.kpmp.spatialViewerDataset.SpatialViewerDataset;
import org.kpmp.spatialViewerDataset.SpatialViewerDatasetRepository;
import org.kpmp.spatialViewerDataset.FileLink;
import org.kpmp.spatialViewerDataset.FileLinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

	private SpatialViewerDatasetRepository spatialViewerDatasetRepository;
	private FileLinkRepository fileLinkRepository;
	private Logger logger = LoggerFactory.getLogger(Query.class);

	@Autowired
	public Query(
		SpatialViewerDatasetRepository spatialViewerDatasetRepository,
		FileLinkRepository fileLinkRepository
	) {
		this.spatialViewerDatasetRepository = spatialViewerDatasetRepository;
		this.fileLinkRepository = fileLinkRepository;
	}

	public List<SpatialViewerDataset> getSpatialViewerDataset() throws IOException, Exception {
		return spatialViewerDatasetRepository.findAll();
	}

	public List<FileLink> getFileLink() throws IOException, Exception {
		return fileLinkRepository.findAll();
	}
}
