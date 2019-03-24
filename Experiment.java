public class Experiment {

    private String setup;
    private int day;
    private String time;
    private boolean completed;
    private float accuracy;

    public Experiment(String setup, int day, String time, boolean completed, float accuracy) {
        this.setup = setup;
        this.day = day;
        this.time = time;
        this.completed = completed;
        this.accuracy = accuracy;
    }

    public Experiment() {
        this.setup = "default";
        this.day = 0;
        this.time = "default";
        this.completed = true;
    }

    public Experiment(Experiment obj) {
        this.setup = obj.setup;
        this.day = obj.day;
        this.time = obj.time;
        this.completed = obj.completed;
        this.accuracy = obj.accuracy;
    }

    public String getSetup() { return setup; }

    public void setSetup(String setup) { this.setup = setup; }

    public int getDay() { return day; }

    public void setDay(int day) { this.day = day; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    public boolean isCompleted() { return completed; }

    public void setCompleted(boolean completed) { this.completed = completed; }

    public float getAccuracy() { return accuracy; }

    public void setAccuracy(float accuracy) { this.accuracy = accuracy; }
}
