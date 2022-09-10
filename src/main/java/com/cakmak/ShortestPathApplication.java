package com.cakmak;

import com.cakmak.findPath.CalculatePaths;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShortestPathApplication {

	private static final Integer[][] DISTANCE_ARRAY =
			{
					{-1,1,2,-1}, //this row covers the distance of other cities to city A
					{1,-1,500,1},
					{2,500,-1,1},
					{-1,1,1,-1},
			};



	public static void main(String[] args) {
		SpringApplication.run(ShortestPathApplication.class, args);

		CalculatePaths calculatePaths=new CalculatePaths();

		System.out.println(calculatePaths.findShortestPath(0, DISTANCE_ARRAY));

		System.exit(0);
	}

}
