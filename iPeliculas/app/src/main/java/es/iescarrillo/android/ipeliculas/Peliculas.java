package es.iescarrillo.android.ipeliculas;

public class Peliculas {
    private String title;
    private String genre;
    private String description;
    private float rating;
    private int imageRes;
    private String director;
    private String date;


    public Peliculas(String title, String genre, String description, float rating, int imageRes, String director, String date) {
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.rating = rating;
        this.imageRes = imageRes;
        this.director = director;
        this.date=date;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public String getDescription() { return description; }
    public float getRating() { return rating; }
    public int getImageRes() { return imageRes; }
    public String getDirector() { return director; }
    public String getDate() { return date; }
}
