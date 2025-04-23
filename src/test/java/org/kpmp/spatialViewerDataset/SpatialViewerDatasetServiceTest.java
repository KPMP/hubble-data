package org.kpmp.spatialViewerDataset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		service = new SpatialViewerDatasetService(externalLinkRepo, fileRepo, restTemplate, env);
		ReflectionTestUtils.setField(service, "enterpriseSearchHost", "host");
		ReflectionTestUtils.setField(service, "enterpriseSearchEngineName", "search-engine");
        ReflectionTestUtils.setField(service, "recentlyReleasedDate", "release-date");
	}

  @AfterEach
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
		spatialViewerDataset1.setParticipantId(123);
		spatialViewerDataset1.setRedcapId("123-456");
		spatialViewerDataset1.setExternalLink("11");
		SpatialViewerExternalLinkDataset spatialViewerDataset2 = new SpatialViewerExternalLinkDataset();
		spatialViewerDataset2.setParticipantId(345);
		spatialViewerDataset2.setRedcapId("345-456");
		spatialViewerDataset2.setExternalLink("55");
		SpatialViewerFileDataset spatialViewerDataset3 = new SpatialViewerFileDataset();
        spatialViewerDataset3.setDlFileId("DlFileId");
        spatialViewerDataset3.setReleaseVersion(45.0);
		spatialViewerDataset3.setParticipantId(456);
		spatialViewerDataset3.setRedcapId("456-456");
		spatialViewerDataset3.setFileId(444);
		SpatialViewerFileDataset spatialViewerDataset4 = new SpatialViewerFileDataset();
        spatialViewerDataset4.setReleaseVersion(34.0);
        spatialViewerDataset4.setDlFileId("DlFileId2");
		spatialViewerDataset4.setParticipantId(566);
		spatialViewerDataset4.setRedcapId("566-456");
		spatialViewerDataset4.setFileId(888);
		expectedResult1.add(spatialViewerDataset1);
		expectedResult1.add(spatialViewerDataset2);
		expectedResult2.add(spatialViewerDataset3);
		expectedResult2.add(spatialViewerDataset4);
        when(fileRepo.max()).thenReturn(34.0);
		when(externalLinkRepo.findAll()).thenReturn(expectedResult1);
		when(fileRepo.findAll()).thenReturn(expectedResult2);
		results.addAll(expectedResult1);
		results.addAll(expectedResult2);
        String expectedJson = "[{\"externallink\":\"11\",\"configtype\":null,\"imagetype\":\"\",\"datatype\":null,\"spectracksampleid\":null,\"redcapid\":\"123-456\",\"participantid\":123,\"age\":null,\"protocol\":null,\"sampletype\":null,\"sex\":null,\"tissuesource\":null,\"enrollmentcategory\":null,\"primaryadjudicatedcategory\":null,\"kdigostage\":null,\"baselineegfr\":null,\"proteinuria\":null,\"a1c\":null,\"albuminuria\":null,\"diabeteshistory\":null,\"diabetesduration\":null,\"hypertensionduration\":null,\"hypertensionhistory\":null,\"onraasblockade\":null,\"race\":null,\"releaseversion\":null,\"participant_id_sort\":123456,\"image_type_sort\":\"\",\"dlfileid\":null,\"relatedfiles\":[]},{\"externallink\":\"55\",\"configtype\":null,\"imagetype\":\"\",\"datatype\":null,\"spectracksampleid\":null,\"redcapid\":\"345-456\",\"participantid\":345,\"age\":null,\"protocol\":null,\"sampletype\":null,\"sex\":null,\"tissuesource\":null,\"enrollmentcategory\":null,\"primaryadjudicatedcategory\":null,\"kdigostage\":null,\"baselineegfr\":null,\"proteinuria\":null,\"a1c\":null,\"albuminuria\":null,\"diabeteshistory\":null,\"diabetesduration\":null,\"hypertensionduration\":null,\"hypertensionhistory\":null,\"onraasblockade\":null,\"race\":null,\"releaseversion\":null,\"participant_id_sort\":345456,\"image_type_sort\":\"\",\"dlfileid\":null,\"relatedfiles\":[]},{\"externallink\":null,\"configtype\":null,\"imagetype\":\"\",\"datatype\":null,\"spectracksampleid\":null,\"redcapid\":\"456-456\",\"participantid\":456,\"age\":null,\"protocol\":null,\"sampletype\":null,\"sex\":null,\"tissuesource\":null,\"enrollmentcategory\":null,\"primaryadjudicatedcategory\":null,\"kdigostage\":null,\"baselineegfr\":null,\"proteinuria\":null,\"a1c\":null,\"albuminuria\":null,\"diabeteshistory\":null,\"diabetesduration\":null,\"hypertensionduration\":null,\"hypertensionhistory\":null,\"onraasblockade\":null,\"race\":null,\"releaseversion\":null,\"participant_id_sort\":456456,\"image_type_sort\":\"\",\"dlfileid\":\"DlFileId\",\"relatedfiles\":null,\"fileid\":444,\"filename\":null,\"packageid\":null,\"filesize\":null,\"level\":null,\"file_name_sort\":null,\"spatialviewerdataset\":null},{\"externallink\":null,\"configtype\":null,\"imagetype\":\"\",\"datatype\":null,\"spectracksampleid\":null,\"redcapid\":\"566-456\",\"participantid\":566,\"age\":null,\"protocol\":null,\"sampletype\":null,\"sex\":null,\"tissuesource\":null,\"enrollmentcategory\":null,\"primaryadjudicatedcategory\":null,\"kdigostage\":null,\"baselineegfr\":null,\"proteinuria\":null,\"a1c\":null,\"albuminuria\":null,\"diabeteshistory\":null,\"diabetesduration\":null,\"hypertensionduration\":null,\"hypertensionhistory\":null,\"onraasblockade\":null,\"race\":null,\"releaseversion\":\"Recently Released - release-date\",\"participant_id_sort\":566456,\"image_type_sort\":\"\",\"dlfileid\":\"DlFileId2\",\"relatedfiles\":null,\"fileid\":888,\"filename\":null,\"packageid\":null,\"filesize\":null,\"level\":null,\"file_name_sort\":null,\"spatialviewerdataset\":null}]";
		HttpEntity<Object> entity = new HttpEntity<>(expectedJson, headers);
		SpatialViewerDatasetService.ESResponse[] esResponses = {new SpatialViewerDatasetService.ESResponse()};
		when(restTemplate.postForObject(anyString(), any(), any(Class.class))).thenReturn(esResponses);
		service.loadEnterpriseSearch();
		verify(restTemplate).postForObject("host/api/as/v1/engines/search-engine/documents", entity, SpatialViewerDatasetService.ESResponse[].class);
	}
}
