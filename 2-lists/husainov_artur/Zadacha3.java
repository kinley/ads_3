package tuikin_bolel;

import java.util.Scanner;

public class Zadacha3 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        MyList a=new MyList();
        a.generateFromString(in.nextLine());
        a.show();
    }
}
class Element{
    public String Word;
    public Element next;
    Element(String Word)
    {
        this.Word=Word;
        next=null;
    }
}
class MyList {
    private Element head;
    MyList(){
        head=null;
    }
    public void show(){
        Element element=head;
        System.out.print("Список : ");
        showRecurtion(element);
        System.out.println();
    }
    private void showRecurtion(Element element){
        if(element!=null)
        {
                System.out.print("\""+element.Word+"\" ");
                showRecurtion(element.next);
        }
    } 
    public void add(Element newOne){
        if(head!=null)
        {
            lastElement(head).next= newOne;
        }
        else
        {
            head=newOne;
        }
    }
    private Element lastElement(Element element){
        if(element.next!=null)
        {
            return lastElement(element.next);
        }
        else
        return element;
    }
    public void generateFromString(String Text){
            String[] arr=Text.split("[^a-zA-z]");
            for(String ss: arr)
            {
                if(!ss.equals("")) this.add(new Element(ss));
            }
    }
}
