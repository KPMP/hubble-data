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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	public static class ESResponse {
		String id;
		List errors;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public List getErrors() {
			return errors;
		}

		public void setErrors(List errors) {
			this.errors = errors;
		}
	}

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
    List <SpatialViewerDataset> datasetsFinal = new ArrayList<>();
    List <SpatialViewerFileDataset> datasets = fileRepo.findAll();
    Map<String, SpatialViewerFileDataset> fileMap = new HashMap<>();
    Double maxReleaseVersion = fileRepo.max();
    for (SpatialViewerFileDataset spatialViewerFileDataset : datasets){
         if (Double.compare(spatialViewerFileDataset.getReleaseVersion(), maxReleaseVersion) == 0){
            spatialViewerFileDataset.setReleaseVersionDisplay("Recently Released");
         }else{
            spatialViewerFileDataset.setReleaseVersionDisplay(null);
         }
         fileMap.put(spatialViewerFileDataset.getDlFileId(), spatialViewerFileDataset);
    }
    datasetsFinal.addAll(externalLinkRepo.findAll());
    datasetsFinal.addAll(fileMap.values());
    return datasetsFinal;
}

	public List<SpatialViewerFileDataset> getSpatialViewerFileDataset() throws IOException, Exception {
		return fileRepo.findAll();
	}

	public List<SpatialViewerExternalLinkDataset> getSpatialViewerExternalLink() throws IOException, Exception {
		return externalLinkRepo.findAll();
	}

	public List<ESResponse> loadEnterpriseSearch() throws Exception {
		List<ESResponse> responses = new ArrayList<>();
		List<SpatialViewerDataset> datasets = getSpatialViewerDataset();
		String token = env.getProperty("ES_API_TOKEN");
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer "+ token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		int chunks = (int) Math.ceil((double) datasets.size() / 100.00);
		for (int i = 0; i < chunks; i++) {
			int beginIndex = i * 100;
			int endIndex;
			if (i == chunks - 1)
				endIndex = datasets.size();
			else
				endIndex = (i * 100) + 100;
			List datasetSlice = datasets.subList(beginIndex, endIndex);
			HttpEntity<Object> entity = new HttpEntity<>(datasetSlice, headers);
			ESResponse[] response = restTemplate.postForObject(enterpriseSearchHost + "/api/as/v1/engines/" + enterpriseSearchEngineName + "/documents",
					entity, ESResponse[].class);
			Collections.addAll(responses, response);
		}
		return responses;
	}

}
