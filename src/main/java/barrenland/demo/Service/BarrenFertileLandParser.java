package barrenland.demo.Service;

import barrenland.demo.Bean.BarrenCoordinate;

import java.util.List;

/**
 * @author Varadharajan on 2019-09-16 20:56
 * @project name: barren-land
 */
public interface BarrenFertileLandParser {

    String parseFertileFoundLand(String[] strArray);

    List<Integer[]> getBarrenLandsPlottedCoordinates(String[] landArray);

    List<BarrenCoordinate> findAllBarrenLandForArea(Integer[] bounds);
}
