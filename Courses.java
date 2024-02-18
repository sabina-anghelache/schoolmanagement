public class Courses {
    private int id;
    private String name;
    private String prof;
    private int room;

    public Courses(int id, String name, String prof, int room) {

        this.id = id;
        this.name = name;
        this.prof = prof;
        this.room = room;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProf() {
        return prof;
    }

    public int getRoom() {
        return room;
    }

    public void setId() {
        this.id = id;
    }

    public void setName() {
        this.name = name;
    }

    public void setProf() {
        this.name = name;
    }

    public void setRoom() {
        this.room = room;
    }
}
