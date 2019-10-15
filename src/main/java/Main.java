import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {

        InputStreamReader inputStreamReader;
        if (args.length > 0)
            inputStreamReader = new InputStreamReader(new FileInputStream(new File(args[0])));
        else
            inputStreamReader = new InputStreamReader(System.in);

        System.out.println(TradeBuilder.create1(Reader.readData(inputStreamReader)));

        if (args.length > 0)
            inputStreamReader = new InputStreamReader(new FileInputStream(new File(args[0])));
        else
            inputStreamReader = new InputStreamReader(System.in);
        System.out.println( TradeBuilder.create2(Reader.readData(inputStreamReader)));
    }


}
