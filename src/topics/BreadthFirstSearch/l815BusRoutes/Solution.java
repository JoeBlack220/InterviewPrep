package topics.BreadthFirstSearch.l815BusRoutes;
import java.util.*;
public class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        Set<Integer> taken = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        if(S == T) return 0;

        for(int i = 0; i < routes.length; ++i) {
            for(int num: routes[i]) {
                if(map.get(num) == null) map.put(num, new HashSet<>());
                Set<Integer> set = map.get(num);
                set.add(i);
            }
        }

        Set<Integer> stations = new HashSet<>();
        int step = 1;
        for(int bus: map.get(S)) {
            taken.add(bus);
            for(int station: routes[bus]) {
                if(station == T) return step;
                else {
                    stations.add(station);
                }
                visited.add(station);
            }
        }

        while(!stations.isEmpty()) {
            Set<Integer> next = new HashSet<>();
            step++;
            for(int station: stations) {
                for(int bus: map.get(station)) {
                    if(!taken.add(bus)) continue;
                    for(int next_station: routes[bus]) {
                        if(next_station == T) return step;
                        if(!visited.add(next_station)) continue;
                        next.add(next_station);
                    }
                }
            }
            stations = next;
        }

        return -1;
    }
}