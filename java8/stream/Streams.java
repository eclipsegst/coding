package stream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	private enum Status {
		OPEN, CLOSED
	};
	
	private static final class Task {
		private final Status status;
		private final Integer points;
		
		Task( final Status status, final Integer points) {
			this.status = status;
			this.points = points;
		}
		
		public Integer getPoints() {
			return points;
		}
		
		public Status getStatus() {
			return status;
		}
		
		@Override
		public String toString() {
			return String.format( "[%s, %d]", status, points );
		}
	}
	
	public static void main(String[] args) {
		final Collection< Task > tasks = Arrays.asList(
			new Task( Status.OPEN, 5),
			new Task( Status.OPEN, 13),
			new Task( Status.CLOSED, 8)
		);
		
		final long totalPointsOfOpenTasks = tasks
				.stream() // convert task collecting to its stream representation.
				.filter( task -> task.getStatus() == Status.OPEN)
				.mapToInt(Task::getPoints) // convert the task stream to the stream of Integers
				.sum();
		
		// Total points: 18
		System.out.println("Total points: " + totalPointsOfOpenTasks);
		
		final long totalPoints = tasks
				.stream()
				.parallel()
				.map( task -> task.getPoints()) // or map(Task::getPoints)
				.reduce(0, Integer::sum);
		// Total points (all tasks): 26
		System.out.println("Total points (all tasks): " + totalPoints);
		
		// Group tasks by their status
		final Map<Status, List<Task>> map = tasks
				.stream()
				.collect( Collectors.groupingBy( Task::getStatus));
		// {CLOSED=[[CLOSED, 8]], OPEN=[[OPEN, 5], [OPEN, 13]]}
		System.out.println(map);
		
		// Calculate the weight of each tasks
		final Collection<String> result = tasks
				.stream()
				.mapToInt( Task::getPoints )
				.asLongStream()
				.mapToDouble( points -> (double)points/totalPoints )
				.boxed()
				.mapToLong( weight -> (long) (weight * 100) )
				.mapToObj( percentage -> percentage + "%")
				.collect( Collectors.toList() );
		System.out.println(result);
		
		
		final Path path = new File("files\\input.txt").toPath();
		try( Stream<String> lines = Files.lines( path,
				StandardCharsets.UTF_8)) {
			lines.onClose( () -> System.out.println("Done!")).forEach(
					System.out::println
					);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
}
