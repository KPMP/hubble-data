package org.kpmp.spatialViewerDataset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;
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
}
