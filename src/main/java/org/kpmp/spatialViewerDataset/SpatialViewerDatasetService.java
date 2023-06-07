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
	@Value("${enterprise-search.engine.name}")
	private String enterpriseSearchEngineName;
	private SpatialViewerExternalLinkRepository externalLinkRepo;
	private SpatialViewerFileDatasetRepository fileRepo;

	private RestTemplate restTemplate;
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

	public List loadEnterpriseSearch() throws Exception {
		List<String> responses = new ArrayList<>();
		List<SpatialViewerDataset> datasets = getSpatialViewerDataset();
		String token = env.getProperty("ES_API_TOKEN");
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer "+ token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		int chunks = (int) Math.ceil(datasets.size() / 100);
		for (int i = 0; i < chunks; i++) {
			int endIndex;
			if (i == chunks - 1)
				endIndex = datasets.size();
			else
				endIndex = (i * 100) + 99;
			List datasetSlice = datasets.subList(i * 100, endIndex);
			HttpEntity<Object> entity = new HttpEntity<>(datasetSlice, headers);
			responses.add(restTemplate.postForObject(enterpriseSearchHost + "/api/as/v1/engines/" + enterpriseSearchEngineName  + "/documents",
					entity, String.class));
		}
		return responses;
	}

}
