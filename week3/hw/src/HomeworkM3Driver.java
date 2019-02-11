import java.util.*;

public class HomeworkM3Driver {

	public static void main(String[] args) {
		



//		runTests();
//		runTests2();



	}

	public static void movieTest1() {
		List<Movie> myMovieList = new ArrayList<>();

		Movie aliens0 = new Movie("Aliens", 2020);
		Movie aliens1 = new Movie("Aliens", 1998);
		Movie aliens2 = new Movie("Aliens1", 2000);
		Movie aliens3 = new Movie("aliens", 2009);
		Movie aliens4 = new Movie("Aliens", 2018);
		Movie boonies = new Movie("Boonies", 1995);

		myMovieList.add(aliens0);
		myMovieList.add(aliens2);
		myMovieList.add(boonies);
		myMovieList.add(aliens3);
		myMovieList.add(aliens1);
		myMovieList.add(aliens4);


		Collections.sort(myMovieList);
		System.out.println(myMovieList.toString());
	}


	public static void runTests2() {
		movieTest1();
	}



}
