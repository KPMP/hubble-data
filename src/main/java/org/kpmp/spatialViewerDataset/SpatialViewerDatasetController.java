package org.kpmp.spatialViewerDataset;

import org.kpmp.spatialViewerDataset.SpatialViewerDatasetService.ESResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SpatialViewerDatasetController {
    private final SpatialViewerDatasetService spatialViewerDatasetService;

    @Autowired
    public SpatialViewerDatasetController(SpatialViewerDatasetService spatialViewerDatasetService) {
        this.spatialViewerDatasetService = spatialViewerDatasetService;
    }

    @RequestMapping(value = "/api/v1/spatial-viewer/load-search", method = RequestMethod.GET)
    public @ResponseBody String loadSearch(HttpServletRequest request) throws Exception {
        return "Successfully added " + spatialViewerDatasetService.loadEnterpriseSearch().size() + " documents.";
    }
}
