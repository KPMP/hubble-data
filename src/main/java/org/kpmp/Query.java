package org.kpmp;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.kpmp.spatialViewerDataset.SpatialViewerDataset;
import org.kpmp.spatialViewerDataset.SpatialViewerDatasetService;
import org.kpmp.spatialViewerDataset.SpatialViewerExternalLinkDataset;
import org.kpmp.spatialViewerDataset.SpatialViewerFileDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

	private SpatialViewerDatasetService spatialViewerDatasetService;

	@Autowired
	public Query(
		SpatialViewerDatasetService spatialViewerDatasetService
	) {
		this.spatialViewerDatasetService = spatialViewerDatasetService;
	}

	public List<SpatialViewerDataset> getSpatialViewerDataset() throws IOException, Exception {
		return spatialViewerDatasetService.getSpatialViewerDataset();
	}

	public List<SpatialViewerFileDataset> getSpatialViewerFileDataset() throws IOException, Exception {
		return spatialViewerDatasetService.getSpatialViewerFileDataset();
	}

	public List<SpatialViewerExternalLinkDataset> getSpatialViewerExternalLink() throws IOException, Exception {
		return spatialViewerDatasetService.getSpatialViewerExternalLink();
	}
}
