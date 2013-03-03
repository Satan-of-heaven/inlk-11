import java.util.*;
import java.io.*;
import static ch.lambdaj.Lambda.*;
import static org.hamcrest.Matchers.*;

public abstract class SongDataAccess
{    
    private LinkedList<Song> songs;

    public SongDataAccess(LinkedList<Song> s)
    {
        songs = s;
    }

    public SongDataAccess()
    {
        songs = new LinkedList<Song>();
    }

    public LinkedList<Song> getSongs()
    {
        return songs;
    }

    public void addSong(Song s)
    {
        if(!containsSong(s))
        {
            songs.add(s);
        }
        else
        {
            throw new IllegalArgumentException("Song exists");
        } 
    }

    public void removeSong(int index)
    {
        if(songs != null && songs.size() > 0 && index >= 0 && index < songs.size())
        {
            songs.remove(index);
        }
    }

    public void removeSong(Song s)
    {
        if(containsSong(s))
        {
            songs.remove(songs.indexOf(select(songs, having(on(Song.class).getName(), equalTo(s.getName()))).get(0)));
        }
        else
        {
            throw new IllegalArgumentException("Song does not exist");
        }
    }

    public void removeSong(String s)
    {
        if(containsSong(s))
        {
            songs.remove(songs.indexOf(select(songs, having(on(Song.class).getName(), equalTo(s))).get(0)));
        }
        else
        {
            throw new IllegalArgumentException("Song does not exist");
        }
    }

    public int countSongs()
    {
        if(songs != null)
        {
            return songs.size();
        }

        return 0;
    }   

    public LinkedList<Song> searchSongs(String p)
    {
        LinkedList<Song> s1 = new LinkedList<Song>();
        List<Song> s2 = select(songs, having(on(Song.class).getName(), containsString(p))); //SongName
        s1.addAll(s2); //merge
        s2 = select(songs, having(on(Song.class).getInterpret(), containsString(p)));//SongInterpret
        s1.removeAll(s2);//remove duplicates
        s1.addAll(s2);

        return s1;
    }

    public Boolean containsSong(Song s)
    {
        return (exists(songs, having(on(Song.class).getName(), equalTo(s.getName()))));
    }

    public Boolean containsSong(String s)
    {
        return (exists(songs, having(on(Song.class).getName(), equalTo(s))));
    }

    public Boolean serialize(String fileName)
    {
        try{
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(songs);
            oos.flush();
            oos.close();
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }

    public void deserialize(String fileName)
    {
        try
        {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            LinkedList<Song> s = (LinkedList<Song>)ois.readObject();
            ois.close();

            songs = s;
        }
        catch(Exception ex)
        {
            songs = new LinkedList<Song>();
        }
    }
}
