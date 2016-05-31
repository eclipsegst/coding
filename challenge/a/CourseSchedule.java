package a;

/**
 * @author Zhaolong Zhong May 30, 2016
 * 
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * 
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses];
		
		for (int i = 0; i < prerequisites.length; i++) {
			matrix[prerequisites[i][1]][prerequisites[i][0]] = 1;
		}
		
		int[] visited = new int[numCourses]; // 0 - not visited, 1 - visiting, 2 - visited
		for (int j = 0; j < numCourses; j++) {
			if (visited[j] == 0) {
				if (dfs(matrix, j, visited)) {
					continue;
				}
				return false;
			}
		}
		
		return true;
	}
	
	private boolean dfs(int[][] matrix, int j, int[] visited) {
		visited[j] = 1;
		
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[j][i] == 1) {
				if (visited[i] == 1) {
					return false;
				}
				
				if (visited[i] == 0 && !dfs(matrix, i, visited)) {
					return false;
				}
			}
		}
		
		visited[j] = 2;
		return true;
	}
	
	public static void main(String[] args) {
		CourseSchedule solution = new CourseSchedule();
		int numCourses = 2;
		int[][] prerequisites1 = {{1, 0}};
		int[][] prerequisites2 = {{1, 0}, {0, 1}};
		
		System.out.println(solution.canFinish(numCourses, prerequisites1));
		System.out.println(solution.canFinish(numCourses, prerequisites2));
	}
}
