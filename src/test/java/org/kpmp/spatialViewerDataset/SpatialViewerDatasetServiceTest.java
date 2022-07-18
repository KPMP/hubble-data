package org.kpmp.spatialViewerDataset;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SpatialViewerDatasetServiceTest {

	@Mock
	private SpatialViewerFileDatasetRepository fileRepo;
	@Mock
	private SpatialViewerExternalLinkRepository externalLinkRepo;

  
	private SpatialViewerDatasetService service;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		service = new SpatialViewerDatasetService(externalLinkRepo, fileRepo);
	}

  @After
	public void tearDown() throws Exception {
		// MockitoAnnotations.init(this).close();
		service = null;
	}

	@Test
	public void testGetSpatialViewerDataset() throws JSONException, Exception {
    List<SpatialViewerDataset> expectedResult = new ArrayList<>();
    SpatialViewerFileDataset spatialViewerFileDataset = mock(SpatialViewerFileDataset.class);
		when(spatialViewerFileDataset.getSpatialViewerDataset()).thenReturn(expectedResult);
		assertEquals(expectedResult, service.getSpatialViewerDataset());
	}

}
