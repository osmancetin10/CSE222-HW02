public class MainClass {

    public static void main(String[] args) {

        ExperimentList a= new ExperimentList();
        ExperimentList b= new ExperimentList();
        Experiment obj=new Experiment("Exp1",1,"time=5",true,77);
        Experiment obj2=new Experiment("exp2",2,"time=5",true,65);
        Experiment obj3=new Experiment("Exp3",2,"time=3",false,54);
        Experiment obj4=new Experiment("exp4",2,"time=7",true,81);
        Experiment obj5=new Experiment("exp5",2,"time=4",true,79);
        Experiment obj6=new Experiment("exp6",3,"time=13",true,13);

        a.addExp(obj);
        a.addExp(obj2);
        a.addExp(obj3);
        a.addExp(obj4);
        a.addExp(obj5);
        a.addExp(obj6);

        b.setHead(a.orderExperiments());
        b.showList();

        //System.out.println("getExp example parameters(2,2): " + a.getExp(2,2).getSetup());
        //a.removeExp(2,3);

        //a.setExp(2,2,obj6);
        //a.removeExp(2,3);
        //a.removeDay(2);
        //a.listExp(2);
        //a.orderDay(2);



    }
}
