package org.kpmp.spatialViewerDataset;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SpatialViewerDatasetTest {

    private SpatialViewerDataset spatialViewerDataset;

    @Before
    public void setUp() throws Exception {
        spatialViewerDataset = new SpatialViewerDataset();
    }

    @After
    public void tearDown() throws Exception {
        spatialViewerDataset = null;
    }

    @Test
    public void setFileId() {
        spatialViewerDataset.setFileId(12345);
        assertEquals(12345, spatialViewerDataset.getFileId());
    }

    @Test
    public void setDlFileId() {
        spatialViewerDataset.setDlFileId("dl_file_id");
        assertEquals("dl_file_id", spatialViewerDataset.getDlFileId());
    }

    @Test
    public void setFileName() {
        spatialViewerDataset.setFileName("file.jpg");
        assertEquals("file.jpg", spatialViewerDataset.getFileName());
    }

    @Test
    public void setPackageId() {
        spatialViewerDataset.setPackageId("package_id");
        assertEquals("package_id", spatialViewerDataset.getPackageId());
    }

    @Test
    public void setFileSize() {
        spatialViewerDataset.setFileSize((long) 1234123421);
        assertEquals((long) 1234123421, spatialViewerDataset.getFileSize(), 0.01);
    }

    @Test
    public void setProtocol() {
        spatialViewerDataset.setProtocol("blah");
        assertEquals("blah", spatialViewerDataset.getProtocol());
    }

    @Test
    public void setMetadataTypeId() {
        spatialViewerDataset.setMetadataTypeId(123);
        assertEquals(123, spatialViewerDataset.getMetadataTypeId());
    }

    @Test
    public void setReleaseVer() {
        spatialViewerDataset.setReleaseVer(2.0);
        assertEquals(2.0, spatialViewerDataset.getReleaseVer(), 0.01);
    }

    @Test
    public void setReleaseSunset() {
        spatialViewerDataset.setReleaseSunset(2.0);
        assertEquals(2.0, spatialViewerDataset.getReleaseSunset(), 0.01);
    }

    @Test
    public void setConfigType() {
        spatialViewerDataset.setConfigType("config");
        assertEquals("config", spatialViewerDataset.getConfigType());
    }

    @Test
    public void setImageType() {
        spatialViewerDataset.setImageType("type");
        assertEquals("type", spatialViewerDataset.getImageType());
    }

    @Test
    public void setDataType() {
        spatialViewerDataset.setDataType("dtype");
        assertEquals("dtype", spatialViewerDataset.getDataType());
    }
}
