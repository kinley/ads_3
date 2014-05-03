package tuikin;

import java.util.Scanner;

public class Zadacha3 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        MyList a=new MyList();
        a.generateFromString(in.nextLine());
        a.show();
        a.deleteReverse();
        a.show();
    }
    private static class MyList {
        private class Element{
            public String Word;
            public Element next;
            Element(String Word)
            {
                this.Word=Word;
                next=null;
            }
        }
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
        private void showRecurtion(Element element){ //прочему рекурсией? прост)
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
            else return element;
        }
        public void generateFromString(String Text){
            String[] arr=Text.split("[^a-zA-z]");
            for(String ss: arr)
            {
                if(!ss.equals("")) this.add(new Element(ss));
            }
        }
        private String reverse(String word){
            String rWord="";
            for(int i=word.length()-1;i>=0;i--)
                rWord=rWord.concat(""+word.charAt(i));
            return rWord;
        }
        public void deleteReverse(){
            Element element=head;
            while(element!=null){
                String rWord=reverse(element.Word);
                boolean a=false;
                Element element2=element.next;
                while(element2!=null&&!a){
                    if(element2.Word.equals(rWord)) {
                        element.Word="777";  //не хотелось возиться с перемещениями ссылок
                        element2.Word="777";
                        a=true;
                    }
                    element2=element2.next;
                }
                element=element.next;
            }
            cleanAfter();
        }
        private void cleanAfter(){
            if(head!=null){
                Element element=head; 
                while(element.next!=null){
                    if(element.next.Word.equals("777")) element.next=element.next.next;
                    else element=element.next;
                }
                if(head.Word.equals("777")) head=head.next; //первый то не проверяли еще
            }
        }
    }
}

