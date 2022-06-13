package manager;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    int i= (int) (System.currentTimeMillis())/1000%3600;
    @DataProvider
    public Iterator<Object[]> registrationValidData(){

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"Frog"+i+"@gmail.com", "Zat"+i+"$"});
        list.add(new Object[]{"Frog"+i+1+"@gmail.com", "Zat"+i+"$"});
        list.add(new Object[]{"Frog"+i+2+"@gmail.com", "Zat"+i+"$"});
        list.add(new Object[]{"Frog"+i+3+"@gmail.com", "Zat"+i+"$"});

        return list.iterator();
    }

}

