import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

// custom exception
class SongAlreadyExistsException extends Exception{
    SongAlreadyExistsException(String mssg){
        super(mssg);
    }
}

class Song{
    private int id;
    private String title;
    private String artist;

    // constructor
    public Song(int id, String title, String artist){
        this.id=id;
        this.title=title;
        this.artist=artist;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    // override to string method
    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}

class PlaylistManager{
    private LinkedList<Song> playlist=new LinkedList<>();
    private Stack<Song> history=new Stack<>();
    private Set<Integer> songSet=new HashSet<>();

    // method to add song
    public void addSong(Song s) throws SongAlreadyExistsException{
        if(songSet.contains(s.getId())){
            throw new SongAlreadyExistsException("song already exist "+s.getTitle());
        }
        playlist.add(s);
        songSet.add(s.getId());
        System.out.println("Song added "+s.getTitle());
    }

    // method to remove song
    public void removeSong(int id){
        for(int i=0;i<playlist.size();i++){
            if(playlist.get(i).getId()==id){
                System.out.println("Song removed "+playlist.get(i).getTitle());
                playlist.remove(i);
                return;
            }
            else{
                System.out.println("No song to remove");
            }
        }
    }

    // method to play music
    public void playSong(int id){
        for(Song s:playlist){
            if(s.getId()==id){
                history.push(s);
                System.out.println("Song playing "+s.getTitle());
                return;
            }
        }
        System.out.println("Song not found");
    }

    // method to show playlist
    public void showPlaylist(){
        if (playlist.isEmpty()){
            System.out.println("Playlist is Empty");
            return;
        }
        for(Song s:playlist){
            System.out.println(s.toString());
        }
    }

    // method to show history

    public void showHistory(){
        if(history.isEmpty()){
            System.out.println("No history");
            return;
        }
        for(Song s:history){
            System.out.println(s.toString());
        }
    }
}

public class MusicPlaylistManager {
    public static void main(String[] args) throws SongAlreadyExistsException {

        PlaylistManager playlist=new PlaylistManager();

        try{
            playlist.addSong(new Song(1,"Sitaare", "Arijit Singh"));
            playlist.addSong(new Song(2,"For a reason", "Karan Aujla"));

            playlist.addSong(new Song(1,"Sitaare", "Arijit Singh"));
        }
        catch (SongAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nShow playlist");
        playlist.showPlaylist();

        System.out.println("\nRemoving song:");
        playlist.removeSong(1);

        System.out.println("\nShow playlist after removing:");
        playlist.showPlaylist();

        System.out.println("\nPlay song with id 2: ");
        playlist.playSong(2);

        System.out.println("\nHistory:");
        playlist.showHistory();

    }
}
