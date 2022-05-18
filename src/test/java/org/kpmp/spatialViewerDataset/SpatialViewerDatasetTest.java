package org.kpmp.spatialViewerDataset;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kpmp.file.File;

import java.util.Arrays;
import java.util.List;

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
    public void setImageType() {
        spatialViewerDataset.setImageType("type");
        assertEquals("type", spatialViewerDataset.getImageType());
    }

    @Test
    public void setDataType() {
        spatialViewerDataset.setDataType("dtype");
        assertEquals("dtype", spatialViewerDataset.getDataType());
    }

    @Test
    public void setParticipantId() {
        spatialViewerDataset.setParticipantId(12);
        assertEquals(12, spatialViewerDataset.getParticipantId());
    }

    @Test
    public void setRedcapId() {
        spatialViewerDataset.setRedcapId("redcapid");
        assertEquals("redcapid", spatialViewerDataset.getRedcapId());
    }

    @Test
    public void setAge() {
        spatialViewerDataset.setAge("age");
        assertEquals("age", spatialViewerDataset.getAge());
    }

    @Test
    public void setSampleType() {
        spatialViewerDataset.setSampleType("sample");
        assertEquals("sample", spatialViewerDataset.getSampleType());
    }

    @Test
    public void setSex() {
        spatialViewerDataset.setSex("sex");
        assertEquals("sex", spatialViewerDataset.getSex());
    }

    @Test
    public void setTissueSource() {
        spatialViewerDataset.setTissueSource("tsource");
        assertEquals("tsource", spatialViewerDataset.getTissueSource());
    }

    @Test
    public void setTissueType() {
        spatialViewerDataset.setTissueType("ttype");
        assertEquals("ttype", spatialViewerDataset.getTissueType());
    }

    @Test
    public void setSpectrackSampleId() {
        spatialViewerDataset.setSpectrackSampleId("spectrack");
        assertEquals("spectrack", spatialViewerDataset.getSpectrackSampleId());
    }

    @Test
    public void setLevel() {
        spatialViewerDataset.setLevel("L0");
        assertEquals("L0", spatialViewerDataset.getLevel());
    }

    @Test
    public void setRelatedFiles() {
        File file = new File();
        List files = Arrays.asList(file);
        spatialViewerDataset.setRelatedFiles(files);
        assertEquals(files, spatialViewerDataset.getRelatedFiles());
    }
}
