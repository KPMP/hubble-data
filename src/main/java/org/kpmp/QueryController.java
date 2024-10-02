package org.kpmp;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.kpmp.spatialViewerDataset.SpatialViewerDataset;
import org.kpmp.spatialViewerDataset.SpatialViewerDatasetService;
import org.kpmp.spatialViewerDataset.SpatialViewerExternalLinkDataset;
import org.kpmp.spatialViewerDataset.SpatialViewerFileDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class QueryController implements GraphQLQueryResolver {

	private SpatialViewerDatasetService spatialViewerDatasetService;

	@Autowired
	public QueryController(
		SpatialViewerDatasetService spatialViewerDatasetService
	) {
		this.spatialViewerDatasetService = spatialViewerDatasetService;
	}

	@QueryMapping
	public List<SpatialViewerDataset> getSpatialViewerDataset() throws IOException, Exception {
		return spatialViewerDatasetService.getSpatialViewerDataset();
	}

	public List<SpatialViewerFileDataset> getSpatialViewerFileDataset() throws IOException, Exception {
		return spatialViewerDatasetService.getSpatialViewerFileDataset();
	}

	@QueryMapping
	public List<SpatialViewerExternalLinkDataset> getSpatialViewerExternalLink() throws IOException, Exception {
		return spatialViewerDatasetService.getSpatialViewerExternalLink();
	}
}
