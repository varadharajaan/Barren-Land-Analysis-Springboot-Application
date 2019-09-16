package barrenland.demo.Service;


import barrenland.demo.Bean.BarrenCoordinate;

import java.util.List;

/**
 * @author Varadharajan on 2019-09-16 21:11
 * @project name: barren-land
 */
public interface BarrenlandVisited {

    int visitAllBarrenCoordinates(BarrenCoordinate[][] coordinates, int val1, int val2);

    List<Integer> findUnvisitedAreasAndCountFertileLand(List<Integer> bLand, int val1, int val2);


}
