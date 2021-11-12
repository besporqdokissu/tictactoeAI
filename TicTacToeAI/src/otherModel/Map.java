package otherModel;

import java.util.Arrays;

public class Map {
    private String[][] map;

    public Map() {
        map = new String[3][3];
        for (String[] strings : map) {
            Arrays.fill(strings, " ");
        }
    }

    public String[][] getMap() {
        return map;
    }


    @Override
    public String toString() {
        StringBuilder map = new StringBuilder();
        map.append("---------\n");
        for (int i = 0; i < this.map.length; i++) {
            map.append("| ");
            for (int k = 0; k < this.map[0].length; k++) {
                map.append(this.map[i][k]).append(" ");
            }
            map.append("|\n");
        }
        map.append("---------");
        return map.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Map map1 = (Map) o;
        return Arrays.deepEquals(map, map1.map);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(map);
    }


}
