package assignment1;

public final class ClassRoom {
    private String name, room, course;

    public ClassRoom(String name, String room, String course) {
        this.name = name;
        this.room = room;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "name='" + name + '\'' +
                ", room='" + room + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
