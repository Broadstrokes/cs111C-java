public class Movie implements Comparable<Movie> {
    private String name;
    private int releaseYear;


    /**
     * Constructor
     * @param name
     * @param releaseYear
     */
    public Movie(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }


    /*
        GETTERS & SETTERS
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "\n\t{ Name: " + getName() + ", Year: " + getReleaseYear() + "}";
    }


    /**
     * Compares two Movie objects
     * @param other the other movie object that needs to be compared
     * @return int < 0  == 0 > 0
     */
    @Override
    public int compareTo(Movie other) {
        int nameComparison = this.getName().toLowerCase().compareTo(other.getName().toLowerCase());

        if (nameComparison == 0) {
            return Integer.compare(this.getReleaseYear(), other.getReleaseYear());
        } else {
            return nameComparison;
        }
    }
}
