package barrenland.demo.Utils;


import barrenland.demo.Bean.BarrenCoordinate;

import static barrenland.demo.Constants.BarrenConstants.BARREN_X_TILES_VALUE;
import static barrenland.demo.Constants.BarrenConstants.BARREN_Y_TILES_VALUE;

/**
 * @author Varadharajan on 2019-09-16 21:10
 * @project name: barren-land
 */
public class BarrenLandUtils {


    /**
     * @param coordinates
     * @param co
     * @return
     */

    public static boolean isBarrenCoordinatesVisited(BarrenCoordinate[][] coordinates, BarrenCoordinate co) {
        boolean flag = false;
        if (co.getX() < 0 || co.getY() < 0 || co.getX() >= BARREN_X_TILES_VALUE || co.getY() >= BARREN_Y_TILES_VALUE) {
            return false;
        }

        BarrenCoordinate coordinateToCheck = coordinates[co.getX()][co.getY()];

        if (coordinateToCheck.isVisited()) {
            return false;
        }

        coordinateToCheck.setVisited(true);

        return true;
    }
}

