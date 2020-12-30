package services.generator;

import objects.MyPoint;
import objects.MyPolygon;
import services.sorter.MyPointSorter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PolygonRandomGenerator {
    private static final Random RND = new Random();

    public MyPolygon create(int vertexCount, int minX, int maxX, int minY, int maxY) {
        List<MyPoint> result = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            int x = RND.nextInt(maxX - minX) + minX;
            int y = RND.nextInt(maxY - minY) + minY;
            MyPoint point = new MyPoint(x, y);
            if (result.contains(point)) i--;
            else result.add(point);
        }
        MyPointSorter.sort(result);
        return new MyPolygon(result);
    }
}
