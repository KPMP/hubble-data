package org.kpmp.spatialViewerDataset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

@Service
public class SpatialViewerDatasetService  {

	@Value("${enterprise-search.host}")
	private String enterpriseSearchHost;

	private RestTemplate restTemplate;
	private SpatialViewerExternalLinkRepository externalLinkRepo;
	private SpatialViewerFileDatasetRepository fileRepo;

	private Environment env;

	@Autowired
	public SpatialViewerDatasetService(
		 SpatialViewerExternalLinkRepository externalLinkRepo,
		 SpatialViewerFileDatasetRepository fileRepo, RestTemplate restTemplate, Environment env) {
		this.externalLinkRepo = externalLinkRepo;
		this.fileRepo = fileRepo;
		this.restTemplate = restTemplate;
		this.env = env;
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

	public String loadEnterpriseSearch() throws Exception {
		List<SpatialViewerDataset> datasets = getSpatialViewerDataset();
		String token = env.getProperty("ES_");
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer "+ token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> entity = new HttpEntity<>(datasets, headers);
		return restTemplate.postForObject(enterpriseSearchHost + "/api/as/v1/engines/spatial-viewer-test-api/documents",
				entity, String.class);
	}

}
