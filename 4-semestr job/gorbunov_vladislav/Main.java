import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;

public class Main {
    static Tree goodguys;
    static Tree badguys;

    public static void report(String name) {
        if (goodguys.isMember(name)) System.out.println(name + " - good");
        else if (badguys.isMember(name)) System.out.println(name + " - bad");
        else System.out.println(name + " - not found");
    }

    public static void favor(String name) {
        goodguys.add(name);
        badguys.remove(name);
    }

    public static void unfavor(String name) {
        badguys.add(name);
        goodguys.remove(name);
    }

    public static void main(String args[]) throws Exception {
        goodguys = new Tree("good.txt");
        badguys = new Tree("bad.txt");
        BufferedReader fileIn = new BufferedReader(new FileReader("in.txt"));
        String command = fileIn.readLine();
        while (command != null && !command.equals("")) {
            String[] commandAndName = command.split("\\ ");
            String name = commandAndName[0];
            String cmd = commandAndName[1];
            if (cmd.equals("+")) favor(name);
            else if (cmd.equals("-")) unfavor(name);
            if (cmd.equals("?")) report(name);
            command = fileIn.readLine();
        }
        FileOutputStream fos;
        fos = new FileOutputStream("out-good.txt");
        for (String s : goodguys.toList()) fos.write((s + "\n").getBytes());
        fos.close();
        fos = new FileOutputStream("out-bad.txt");
        for (String s : badguys.toList()) fos.write((s + "\n").getBytes());
        fos.close();
    }
}
