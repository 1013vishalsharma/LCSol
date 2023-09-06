package SDESheet.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectACycleUsingBFS {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        List<List<Integer>> adjList = new ArrayList<>(numCourses);

        for (int i = 0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for (int[] i: prerequisites){
            adjList.get(i[1]).add(i[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean cyclefound = false;
        int res[] = new int[numCourses];
        int j = 0;
        while (!queue.isEmpty()){
            int i = queue.poll();
            if(!visited[i]){
                visited[i] = true;
            } else {
                cyclefound = true;
                continue;
            }
            res[j] = i;
            j++;
            List<Integer> li = adjList.get(i);
            queue.addAll(li);
        }

        if(cyclefound){
            return res;
        } else {
            return new int[0];
        }

        //return null;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {
                {1,0},
                {2,0},
                {3,1},
                {3,2}
        };

        findOrder(4, prerequisites);
        System.out.println(2%3);
    }

}
