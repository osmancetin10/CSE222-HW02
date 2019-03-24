import java.lang.Iterable;
import java.util.Iterator;

public class ExperimentList implements Iterable<Experiment>  {

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    private Node head;


    public void addExp(Experiment obj){

        Node addNode=new Node(obj);
        Node cursorNode=head;
        Node tempNode;
        int control=0;

        if(head==null){
            head=addNode;
        }

        else {
            while ( cursorNode.nextExp!=null  ) {

                if(obj.getDay() < cursorNode.nextExp.getDay()){

                    tempNode=cursorNode.nextExp;
                    cursorNode.nextExp=addNode;
                    addNode.nextExp=tempNode;
                    control=1;
                    break;
                }
                cursorNode=cursorNode.nextExp;
            }

            if(control==0){

                cursorNode.nextDay=addNode;
                cursorNode.nextExp=addNode;
            }
        }
    }

    public void setExp(int day,int index, Experiment obj){

        Node cursorNode=head;
        Node tempNode;
        int i;

        while( cursorNode!=null){

            if(day==cursorNode.getDay()){
                for(i=0;(i<index) && (cursorNode.nextExp!=null);i++){
                    cursorNode=cursorNode.nextExp;
                }
                cursorNode.object.setAccuracy(obj.getAccuracy());
                cursorNode.object.setCompleted(obj.isCompleted());
                cursorNode.object.setSetup(obj.getSetup());
                cursorNode.object.setTime(obj.getTime());
            }
            cursorNode=cursorNode.nextDay;

        }

    }

    public Experiment getExp(int day,int index){

        Node cursorNode=head;
        Node tempNode;
        int i;

        while( cursorNode!=null){

            if(day==cursorNode.getDay()){
                for(i=0;(i<index) && (cursorNode.nextExp!=null);i++){
                    cursorNode=cursorNode.nextExp;
                }
                return cursorNode.object;
            }
            cursorNode=cursorNode.nextDay;

        }

        if(cursorNode!=null)    return cursorNode.object;
        else return null;
    }

    public void removeExp(int day, int index){

        Node cursorNode=head;
        Node tempNode;
        int i,control=0;


        while( cursorNode!=null && control==0){

            if(day==cursorNode.getDay()){
                for(i=0;(i<index-1) && (cursorNode.nextExp!=null);i++){
                    cursorNode=cursorNode.nextExp;
                }
                cursorNode.nextExp=cursorNode.nextExp.nextExp;
                control=1;
            }
            cursorNode=cursorNode.nextDay;

        }

    }

    public void listExp(int day){

        Node cursorNode=head;
        Node tempNode;
        int i,index=expCount(day);

        while( cursorNode!=null ){

            if(day==cursorNode.getDay()){
                if(cursorNode.object.isCompleted()==true) System.out.println(cursorNode.object.getSetup());
                for(i=0;(i<index-1) && (cursorNode.nextExp!=null);i++){
                    cursorNode=cursorNode.nextExp;
                    if(cursorNode.object.isCompleted()==true) System.out.println(cursorNode.object.getSetup());
                }

            }
            cursorNode=cursorNode.nextDay;

        }
    }

    public void removeDay(int day){

        int index=expCount(day);
        Node cursorNode=head;
        Node tempNode;

        while(cursorNode.nextExp!=null){

            if(cursorNode.nextExp.getDay()==day){
                for(int i=0;i<index;i++){
                    cursorNode.nextExp=cursorNode.nextExp.nextExp;
                }
                break;
            }

            cursorNode=cursorNode.nextExp;
        }

    }

    public void orderDay(int day){

        Node cursorNode=head;
        Node temp1Node;
        Experiment temp;

        while(cursorNode!=null){

            if(cursorNode.getDay()==day){
                break;
            }

            cursorNode=cursorNode.nextDay;
        }

        for(; (cursorNode.nextExp!=null) && (cursorNode.nextExp.getDay()==day) ;cursorNode=cursorNode.nextExp){

            temp1Node=cursorNode;

            for (;(temp1Node.nextExp!=null) && (temp1Node.nextExp.getDay()==day) ;temp1Node=temp1Node.nextExp) {

                if (temp1Node.object.getAccuracy() > temp1Node.nextExp.object.getAccuracy()) {
                    temp = temp1Node.object;
                    temp1Node.object = temp1Node.nextExp.object;
                    temp1Node.nextExp.object = temp;
                }
            }
        }



    }

    public Node orderExperiments(){

        ExperimentList tempList=this;
        Node cursorNode=tempList.head;
        Node temp1Node;
        Experiment temp;


        for(; (cursorNode.nextExp!=null);cursorNode=cursorNode.nextExp){

            temp1Node=cursorNode;

            for (;(temp1Node.nextExp!=null) ;temp1Node=temp1Node.nextExp) {

                if (temp1Node.object.getAccuracy() > temp1Node.nextExp.object.getAccuracy()) {
                    temp = temp1Node.object;
                    temp1Node.object = temp1Node.nextExp.object;
                    temp1Node.nextExp.object = temp;
                }
            }
        }
        return tempList.head;
    }

    public void showList(){

        Node cursorNode=head;
        while(cursorNode!=null){
            System.out.println(cursorNode.object.getSetup());
            cursorNode=cursorNode.nextExp;
        }
    }

    public int expCount(int day){

        Node cursorNode=head;
        Node tempNode;
        int i=0;

        while(cursorNode!=null){
            if(cursorNode.getDay()==day)
                break;

            cursorNode=cursorNode.nextDay;
        }

        while(cursorNode!=null){
            if(cursorNode.getDay()!=day){
                break;
            }
            i++;
            cursorNode=cursorNode.nextExp;
        }
        return i;
    }


    @Override
    public Iterator<Experiment> iterator() {
        return null;
    }
}
