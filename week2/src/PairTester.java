
public class PairTester {

	public static void main(String[] args) {
		Pair<Integer> numberPair = new Pair<Integer>(3,4);
		Pair<Integer> numberPair1 = new Pair<Integer>(3,4);
		Pair<Integer> numberPair2 = new Pair<Integer>(4,3);
		Pair<Integer> numberPair3 = new Pair<Integer>(3,3);

		Pair<String> wordPair = new Pair<String>("hello", "goodbye");

		System.out.println(numberPair);
		System.out.println(wordPair);
		
		// testing our sameItems method
		String s1 = new String("apple");
		String s2 = new String("apple");
		Pair<String> wordPair2 = new Pair<String>(s1, s2);
		System.out.println("wordPair2 contains the same items? " + wordPair2.sameItems());


		System.out.println(">>>>>>>>> TEST EQUALS METHOD >>>>>>>>>>>>>>");

		System.out.println(numberPair.equals(numberPair1)); // true
		System.out.println(numberPair.equals(numberPair2)); // true
		System.out.println(numberPair.equals(numberPair3)); // false
		System.out.println(numberPair.equals(wordPair)); // false



//		PairDifferent<Integer,String> numberWordPair = new PairDifferent<Integer,String>(2, "hello");
//		PairDifferent<Integer,Integer> doubleNumberPair = new PairDifferent<Integer,Integer>(1,1);

	}

}
