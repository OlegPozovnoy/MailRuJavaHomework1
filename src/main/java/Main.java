import tradebuilder.ITradeBuilder;
import tradebuilder.TradeBuilderEnumImpl;
import tradebuilder.TradeBuilderSwitchImpl;

import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        try (InputStreamReader inputStreamReader = new InputStreamReader(
                args.length > 0 ? new FileInputStream(new File(args[0])) : System.in)) {

            //testing switch Trade builder
            ITradeBuilder tradeBuilder = new TradeBuilderSwitchImpl();
            System.out.println(tradeBuilder.create(Reader.readData(inputStreamReader)));
            //testing enum TradeBuilder
            tradeBuilder = new TradeBuilderEnumImpl();
            System.out.println(tradeBuilder.create(Reader.readData(inputStreamReader)));
        }
    }
}
