package barrenland.demo.Controller;

import barrenland.demo.Bean.ResponseDTO;
import barrenland.demo.Service.BarrenFertileLandImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Varadharajan on 2019-09-16 23:44
 * @project name: BarrenLandAnalyser
 */
@RestController
@RequestMapping("/BarrenLandManagement/v1")
public class BarrenLandAnalysisController {

    private static final Logger logger = LoggerFactory.getLogger(BarrenLandAnalysisController.class);

    @Autowired
    private BarrenFertileLandImpl barrenFertileLandImpl;

    @ApiOperation(value = "create BarrenLand metadata")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 404, message = "Given Land Coordinates not found"),
            @ApiResponse(code = 500, message = "Server Error"),})
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/findFertileLands")
    public ResponseEntity<ResponseDTO> findFertileLandAvailable(@RequestParam("strArray") @Valid final String[] inputArray) {

        logger.info("method started for calculating fertile land");
        String land = barrenFertileLandImpl.parseFertileFoundLand(inputArray);
        ResponseDTO dto = new ResponseDTO();
        dto.setOutput(land);
        logger.info("output is-->" + dto.getOutput());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
