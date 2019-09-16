package barrenland.demo.Service;


import barrenland.demo.Bean.BarrenCoordinate;
import barrenland.demo.Controller.BarrenLandAnalysisController;
import barrenland.demo.Exception.IntegerPraserException;
import barrenland.demo.Utils.BarrenLandUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import static barrenland.demo.Constants.BarrenConstants.BARREN_X_TILES_VALUE;
import static barrenland.demo.Constants.BarrenConstants.BARREN_Y_TILES_VALUE;

/**
 * @author Varadharajan on 2019-09-16 21:03
 * @project name: barren-land
 */
@Component
public class BarrenFertileLandImpl implements BarrenFertileLandParser, BarrenlandVisited {

    private static BarrenCoordinate[][] grid = new BarrenCoordinate[BARREN_X_TILES_VALUE][BARREN_Y_TILES_VALUE];

    private static final Logger logger = LoggerFactory.getLogger(BarrenFertileLandImpl.class);

    @Override
    public String parseFertileFoundLand(String[] strArray) {
        List<Integer> fertileLand = new ArrayList<>();

        List<Integer[]> barrenLandEndPoints = getBarrenLandsPlottedCoordinates(strArray);


        List<BarrenCoordinate> totalBarrenLand = new ArrayList<>();
        for (Integer[] rectangle : barrenLandEndPoints) {
            totalBarrenLand.addAll(findAllBarrenLandForArea(rectangle));
        }

        for (int y = 0; y < BARREN_Y_TILES_VALUE; y++) {
            for (int x = 0; x < BARREN_X_TILES_VALUE; x++) {
                BarrenCoordinate co = new BarrenCoordinate(x, y);
                for (BarrenCoordinate c : totalBarrenLand) {
                    if (c.getX() == x && c.getY() == y) {
                        co.setIsBarren(true);
                        co.setVisited(true);
                        break;
                    } else {
                        co.setIsBarren(false);
                    }
                }
                grid[x][y] = co;
            }
        }

        fertileLand = findUnvisitedAreasAndCountFertileLand(fertileLand, 0, 0);

        Collections.sort(fertileLand);

        String output = "";

        if (!fertileLand.isEmpty()) {
            for (Integer land : fertileLand) {
                output += land.toString() + " ";
            }
        } else {
            output = "No fertile land available.";
        }

        return output;
    }

    @Override
    public List<Integer[]> getBarrenLandsPlottedCoordinates(String[] landArray) {
        List<Integer[]> rectanglePoints = new ArrayList<>();
        for (int h = 0; h < landArray.length; h++) {
            String[] strLandArray = landArray[h].split(" ");
            Integer[] intRectangleCorner = new Integer[strLandArray.length];
            for (int i = 0; i < strLandArray.length; i++) {
                try {
                    intRectangleCorner[i] = Integer.parseInt(strLandArray[i]);
                }
                catch(NumberFormatException e) {
                    throw new IntegerPraserException("Given input is invalid . does not contain integer");
                }
            }
            rectanglePoints.add(intRectangleCorner);
        }

        return rectanglePoints;
    }

    @Override
    public List<BarrenCoordinate> findAllBarrenLandForArea(Integer[] areaBounds) {
        List<BarrenCoordinate> areaBarrenLandCoordinates = new ArrayList<>();

        for (int i = areaBounds[0]; i <= areaBounds[2]; i++) {
            for (int j = areaBounds[1]; j <= areaBounds[3]; j++) {
                BarrenCoordinate coordinates = new BarrenCoordinate(i, j);
                areaBarrenLandCoordinates.add(coordinates);
            }
        }
        return areaBarrenLandCoordinates;
    }


    @Override
    public int visitAllBarrenCoordinates(BarrenCoordinate[][] coordinates, int val1, int val2) {
        int count = 0; // Count of grid squares being filled/visited

        Stack<BarrenCoordinate> stack = new Stack<BarrenCoordinate>();
        stack.push(new BarrenCoordinate(val1, val2));

        while (!stack.isEmpty()) {
            BarrenCoordinate c = stack.pop();

            if (BarrenLandUtils.isBarrenCoordinatesVisited(grid, c)) {
                count += 1;
                if (c.getY() - 1 >= 0 && !grid[c.getX()][c.getY() - 1].isVisited()) {
                    stack.push(new BarrenCoordinate(c.getX(), c.getY() - 1));
                }
                if (c.getY() + 1 < BARREN_Y_TILES_VALUE && !grid[c.getX()][c.getY() + 1].isVisited()) {
                    stack.push(new BarrenCoordinate(c.getX(), c.getY() + 1));
                }
                if (c.getX() - 1 >= 0 && !grid[c.getX() - 1][c.getY()].isVisited()) {
                    stack.push(new BarrenCoordinate(c.getX() - 1, c.getY()));
                }
                if (c.getX() + 1 < BARREN_X_TILES_VALUE && !grid[c.getX() + 1][c.getY()].isVisited()) {
                    stack.push(new BarrenCoordinate(c.getX() + 1, c.getY()));
                }
            }

        }
        return count;
    }

    @Override
    public List<Integer> findUnvisitedAreasAndCountFertileLand(List<Integer> bLand, int val1, int val2) {
        for (int y = val2; y < BARREN_Y_TILES_VALUE; y++) {
            for (int x = val1; x < BARREN_X_TILES_VALUE; x++) {
                BarrenCoordinate tile = grid[x][y];
                if (!tile.isVisited()) {
                    int totalFertileArea = visitAllBarrenCoordinates(grid, x, y);
                    bLand.add(totalFertileArea);
                    findUnvisitedAreasAndCountFertileLand(bLand, x, y);
                }
            }
        }
        return bLand;
    }
}
