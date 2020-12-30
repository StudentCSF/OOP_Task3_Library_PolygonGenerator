package services.sorter;

import objects.MyPoint;

import java.util.Comparator;
import java.util.List;

public class MyPointSorter {

    public static void sort(List<MyPoint> src) {
        if (src.size() <= 3) return;
        int sumX = 0;
        int sumY = 0;
        for (MyPoint p : src) {
            sumX += p.getX();
            sumY += p.getY();
        }
        final MyPoint center = new MyPoint(sumX / src.size(), sumY / src.size());

        Comparator<MyPoint> cmp = new Comparator<MyPoint>() {
            @Override
            public int compare(MyPoint o1, MyPoint o2) {
                double atan1 = Math.atan2(o1.getY() - center.getY(), o1.getX() - center.getX());
                double atan2 = Math.atan2(o2.getY() - center.getY(), o2.getX() - center.getX());
                return Double.compare(atan1, atan2);
            }
        };
        src.sort(cmp);
    }
}
