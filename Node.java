public class Node {

    public Experiment object;
    public Node nextDay;
    public Node nextExp;

    public Node(Experiment obj) {
        this.object=obj;
        this.nextExp=null;
        this.nextDay=null;
    }

    public int getDay() { return object.getDay(); }


}
