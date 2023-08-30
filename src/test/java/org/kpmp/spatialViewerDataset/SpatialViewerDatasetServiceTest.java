package org.kpmp.spatialViewerDataset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

public class SpatialViewerDatasetServiceTest {

	@Mock
	private SpatialViewerFileDatasetRepository fileRepo;
	@Mock
	private SpatialViewerExternalLinkRepository externalLinkRepo;

	@Mock
	private RestTemplate restTemplate;

	@Mock
	Environment env;

  
	private SpatialViewerDatasetService service;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		service = new SpatialViewerDatasetService(externalLinkRepo, fileRepo, restTemplate, env);
		ReflectionTestUtils.setField(service, "enterpriseSearchHost", "host");
		ReflectionTestUtils.setField(service, "enterpriseSearchEngineName", "search-engine");
	}

  @After
	public void tearDown() throws Exception {
		MockitoAnnotations.openMocks(this).close();
		service = null;
	}

	@Test
	public void testGetSpatialViewerDataset() throws JSONException, Exception {
    List<SpatialViewerDataset> expectedResult = new ArrayList<>();
		assertEquals(expectedResult, service.getSpatialViewerDataset());
	}

	@Test
	public void testGetSpatialViewerExternalLink() throws JSONException, Exception {
    List<SpatialViewerDataset> expectedResult = new ArrayList<>();
		assertEquals(expectedResult, service.getSpatialViewerExternalLink());
	}

	@Test
	public void testGetSpatialViewerFileDataset() throws JSONException, Exception {
    List<SpatialViewerDataset> expectedResult = new ArrayList<>();
		assertEquals(expectedResult, service.getSpatialViewerFileDataset());
	}

	@Test
	public void testLoadEnterpriseSearch() throws JSONException, Exception {
		when(env.getProperty("ES_API_TOKEN")).thenReturn("TOKEN");
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer "+ "TOKEN");
		headers.setContentType(MediaType.APPLICATION_JSON);

		ArrayList<SpatialViewerDataset> results = new ArrayList<>();
		List<SpatialViewerExternalLinkDataset> expectedResult1 = new ArrayList<>();
		List<SpatialViewerFileDataset> expectedResult2 = new ArrayList<>();
		SpatialViewerExternalLinkDataset spatialViewerDataset1 = new SpatialViewerExternalLinkDataset();
		SpatialViewerExternalLinkDataset spatialViewerDataset2 = new SpatialViewerExternalLinkDataset();
		SpatialViewerFileDataset spatialViewerDataset3 = new SpatialViewerFileDataset();
        spatialViewerDataset3.setDlFileId("DlFileId");
        spatialViewerDataset3.setReleaseVersion(45.0);
		SpatialViewerFileDataset spatialViewerDataset4 = new SpatialViewerFileDataset();
        spatialViewerDataset4.setReleaseVersion(34.0);
        spatialViewerDataset4.setDlFileId("DlFileId2");
		expectedResult1.add(spatialViewerDataset1);
		expectedResult1.add(spatialViewerDataset2);
		expectedResult2.add(spatialViewerDataset3);
		expectedResult2.add(spatialViewerDataset4);
        when(fileRepo.max()).thenReturn(34.0);
		when(externalLinkRepo.findAll()).thenReturn(expectedResult1);
		when(fileRepo.findAll()).thenReturn(expectedResult2);
		results.addAll(expectedResult1);
		results.addAll(expectedResult2);

		HttpEntity<Object> entity = new HttpEntity<>(results, headers);
		SpatialViewerDatasetService.ESResponse[] esResponses = {new SpatialViewerDatasetService.ESResponse()};
		when(restTemplate.postForObject("host/api/as/v1/engines/search-engine/documents", entity, SpatialViewerDatasetService.ESResponse[].class)).thenReturn(esResponses);
		service.loadEnterpriseSearch();
		verify(restTemplate).postForObject("host/api/as/v1/engines/search-engine/documents", entity, SpatialViewerDatasetService.ESResponse[].class);
	}
}
