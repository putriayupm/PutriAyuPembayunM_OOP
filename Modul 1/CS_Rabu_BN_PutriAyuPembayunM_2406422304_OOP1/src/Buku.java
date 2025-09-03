public class Buku {
    public String judul;
    public int year;
    public BookGenre genre;
    public Author author;
    public int CurrentAge;

    public Buku (String judul, int year, BookGenre genre, Author author){
        this.judul = judul;
        this.year = year;
        this.genre = genre;
        this.author = author;
    }

    public int getAuthorCurrentAge(){
        CurrentAge = year - author.tahunLahir;
        return CurrentAge;
    }

    public void showDetail(){
        System.out.println ("Judul: " + judul);
        System.out.println ("Genre: " + genre);
        System.out.println ("Tahun Terbit: " + year);
        System.out.println ("Nama Author: " + author.nama);
        System.out.println ("Tahun Lahir: " + author.tahunLahir);
        System.out.println ("Usia Author Saat Buku Diterbitkan: " + CurrentAge);
    }


}
