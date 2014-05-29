import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Tree {
    private String data;  //имя депутата
    private Tree parent; //родительское дерево, ветвью которого мы являемся
    private Tree l; //левое поддерево
    private Tree r; //правое поддерево

    public Tree(String file) throws Exception { //инициализация пустого дерева
        data = null;
        l = null;
        r = null;
        BufferedReader in = new BufferedReader(new FileReader(file));
        String str;
        while ((str = in.readLine()) != null) add(str);
        in.close();
    }

    public Tree(Tree parent) { //инициализация дочернего дерева
        super();
        this.parent = parent;
    }

    //сравнение двух имент не целиком а по эелементу
    //элемент в данном случае - это символ с номером уровня
    //уровень = разряд
    //в случае если сравнивать нечего(к примеру 4тый символ в "aaa" и "bbb") возвразаем
    //максинт - что значит - сравнить невозможно
    private int cmp(String s1, String s2, int level) {
        if (s1.length() <= level && s2.length() <= level) return Integer.MAX_VALUE;
        int c1 = s1.length() > level ? s1.charAt(level) : 0;
        int c2 = s2.length() > level ? s2.charAt(level) : 0;
        return c1 - c2;
    }


    //метод добавления с учетом уровня, закрыт для невозможности ичпортить структуру дерева
    private void add(String name, int level) {
        if (data == null) data = name; //если текущий элемент пуст(голова дерева) - то сюда и пишем
        else {
            int cmp = cmp(name, data, level); //сравниваем разряды
            //для cmp==0 - это попытка добавить существующий элемент - игнорируем
            if (cmp > 0) { //определям в какую ветку добавить
                if (r == null) r = new Tree(this);
                r.add(name, level + 1); //и добавляем
            }
            if (cmp < 0) {
                if (l == null) l = new Tree(this);
                l.add(name, level + 1);
            }
        }
    }

    //метод добавления для корневого элемента
    public void add(String name) {
        add(name, 0);
    }

    private Tree search(String name, int level) { //поиск поддрева, аналогично добавлению, но тут мы возвращаем найденное дерево
        if (data == null) return null;
        else {
            Integer cmp = cmp(name, data, level);
            if (cmp == Integer.MAX_VALUE) return null;
            Tree result = null;
            if (cmp == 0) result = this;
            if (cmp > 0) result = r == null ? null : r.search(name, level + 1);
            if (cmp < 0) result = l == null ? null : l.search(name, level + 1);
            return result;
        }
    }

    public boolean isMember(String name) {
        return search(name, 0) != null; // если есть дерево с ключем - то есть и коюч
    }

    // получение головы дерева
    private Tree getHead() {
        Tree t = this;
        while (t.parent != null) t = parent;
        return t;
    }

    //удаление элемента
    public void remove(String name) {
        Tree tree = search(name, 0); //проверяем существование элемента
        if (tree != null) {
            if (tree.parent != null) { //если у него есть радитель
                //то удаляем ветвь из родателя
                Tree parent = tree.parent;
                //получаем все дочерние эоементы(которые дочерни к удаляемому) - их удалять не надо
                //поэтому мы их передобавим
                ArrayList<String> data = new ArrayList<String>();
                if (tree.l != null) tree.l.addAllToList(data);
                if (tree.r != null) tree.r.addAllToList(data);
                if (parent.l == tree) parent.l = null;
                else parent.r = null;
                Tree head = getHead();
                //добавляем в голову(будут распределены как надо, так
                //как добавляем в голову, а значит и все ост операции будут работать корректно)
                for (String i : data) head.add(i);
            } else {
                //если радителя нет - то это голова. Просто чистим данные
                data = null;
            }
        }
    }

    //преобразование в список, необходимо для отладки и выцвода
    public List<String> toList() {
        ArrayList<String> data = new ArrayList<String>();
        addAllToList(data);
        return data;
    }

    //добавление всех дочерних элементов в список
    private void addAllToList(List<String> list) {
        list.add(data);
        if (l != null) l.addAllToList(list);
        if (r != null) r.addAllToList(list);
    }
}
