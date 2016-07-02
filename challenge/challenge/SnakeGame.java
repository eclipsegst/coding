package challenge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhaolong Zhong Jul 1, 2016
 * 
 * Design Snake Game
 * 
 * Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.
 * The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
 * You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.
 * Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.
 * When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
 * 
 * Example:
 * Given width = 3, height = 2, and food = [[1,2],[0,1]].
 * Snake snake = new Snake(width, height, food);
 * Initially the snake appears at position (0,0) and the food at (1,2).
 * |S| | |
 * | | |F|
 * snake.move("R"); -> Returns 0
 * | |S| |
 * | | |F|
 * snake.move("D"); -> Returns 0
 * | | | |
 * | |S|F|
 * snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )
 * | |F| |
 * | |S|S|
 * snake.move("U"); -> Returns 1
 * | |F|S|
 * | | |S|
 * snake.move("L"); -> Returns 2 (Snake eats the second food)
 * | |S|S|
 * | | |S|
 * snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 *	
 * Reference:
 * https://leetcode.com/discuss/109238
 */
public class SnakeGame {
	int width;
	int height;
	int[][] food;
	int score;
	int foodIndex;
	Set<Integer> set;
	Deque<Integer> body;
	
	/** Initialize your data structure here.
	    @param width - screen width
	    @param height - screen height 
	    @param food - A list of food positions
	    E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
	public SnakeGame(int width, int height, int[][] food) {
		this.width = width;
		this.height = height;
		this.food = food;
		
		set = new HashSet<Integer>();
		set.add(0);
		body = new ArrayDeque<Integer>();
		body.offerLast(0);
	}
	
	/** Moves the snake.
	    @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
	    @return The game's score after the move. Return -1 if game over. 
	    Game over when snake crosses the screen boundary or bites its body. */
	public int move(String direction) {
	    if (score == -1) {
	    	return -1; 
	    }
	    
	    int rowHead = body.peekFirst() / width;
	    int colHead = body.peekFirst() % width;
	    
	    switch(direction) {
		    case "U" : 
		    	rowHead--;
		    	break;
		    case "D" :
		    	rowHead++;
		    	break;
		    case "L" :
		    	colHead--;
		    	break;
	    	default :
	    		colHead++;
	    }
	    
	    int head = rowHead * width + colHead;
	    
	    set.remove(body.peekLast()); // new head can be at the "old" tail, so we remove the tail every time and add it back later.
	    if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
	    	return score = -1;
	    }
	    
	    set.add(head);
	    body.offerFirst(head);
	    
	    if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
	    	set.add(body.peekLast()); // add tail back 
	    	foodIndex++;
	    	return ++score;
	    }
	    
	    body.pollLast();
	    
	    return score;
	}

	public static void main(String[] args) {
//		int width = 3, height = 2;
//		int[][] food = new int[][]{{1, 2}, {0, 1}};
		
		int width = 77, height = 285;
		int[][] food = new int[][]{{3, 6}, {50, 31}};
		
		SnakeGame snake = new SnakeGame(width, height, food);
		System.out.println(snake.move("R"));
		System.out.println(snake.move("D"));
		System.out.println(snake.move("R"));
		System.out.println(snake.move("U"));
		System.out.println(snake.move("L"));
		System.out.println(snake.move("U"));
	}
}

/**
* Your SnakeGame object will be instantiated and called as such:
* SnakeGame obj = new SnakeGame(width, height, food);
* int param_1 = obj.move(direction);
*/