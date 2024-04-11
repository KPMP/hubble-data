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
    private static final int EQUALITY_OPERATOR = 0;
	@Value("${enterprise-search.host}")
	private String enterpriseSearchHost;
	@Value("${enterprise-search.engine.name}")
	private String enterpriseSearchEngineName;
	private SpatialViewerExternalLinkRepository externalLinkRepo;
	private SpatialViewerFileDatasetRepository fileRepo;
    @Value ("${recently-released-date}")
    private String recentlyReleasedDate;

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
    List <SpatialViewerFileDataset> datasets = new ArrayList<>();
    List <SpatialViewerExternalLinkDataset> externalLinkList = new ArrayList<>();
    Map<String, SpatialViewerFileDataset> fileMap = new HashMap<>();
    Map<String, SpatialViewerExternalLinkDataset> linkMap = new HashMap<>();
    Double maxFileReleaseVersion = fileRepo.max();
    Double maxLinkReleaseVersion = externalLinkRepo.max();
    Double maxReleaseVersion = 0.00;
    if(maxFileReleaseVersion > maxLinkReleaseVersion){
        maxReleaseVersion = maxFileReleaseVersion;
    }else if(maxFileReleaseVersion == maxLinkReleaseVersion){
        maxReleaseVersion = maxFileReleaseVersion;
    }else{
        maxReleaseVersion = maxLinkReleaseVersion;
    }
    datasets.addAll(fileRepo.findAll());
    externalLinkList.addAll(externalLinkRepo.findAll());
    for (SpatialViewerFileDataset spatialViewerFileDataset : datasets){
        if(spatialViewerFileDataset.getReleaseVersion() != null){
            if (Double.compare(spatialViewerFileDataset.getReleaseVersion(), maxReleaseVersion) == EQUALITY_OPERATOR){
                spatialViewerFileDataset.setReleaseVersionDisplay("Recently Released - " + recentlyReleasedDate);
            }
        }else{
            spatialViewerFileDataset.setReleaseVersionDisplay(null);
        }
        fileMap.put(spatialViewerFileDataset.getDlFileId(), spatialViewerFileDataset);
    }

    for(SpatialViewerExternalLinkDataset externalLinkDataset : externalLinkList){
        if(externalLinkDataset.getReleaseVersion() != null){
            if(Double.compare(externalLinkDataset.getReleaseVersion(), maxReleaseVersion) == EQUALITY_OPERATOR){
                externalLinkDataset.setReleaseVersionDisplay("Recently Released - " + recentlyReleasedDate);
            }
        }else{
            externalLinkDataset.setReleaseVersionDisplay(null);
        }
        linkMap.put(externalLinkDataset.getExternalLink(), externalLinkDataset);
    }
         
    datasetsFinal.addAll(linkMap.values());
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
			List<SpatialViewerDataset> datasetSlice = datasets.subList(beginIndex, endIndex);
			HttpEntity<Object> entity = new HttpEntity<>(datasetSlice, headers);
			ESResponse[] response = restTemplate.postForObject(enterpriseSearchHost + "/api/as/v1/engines/" + enterpriseSearchEngineName + "/documents",
					entity, ESResponse[].class);
			Collections.addAll(responses, response);
		}
		return responses;
	}

}
