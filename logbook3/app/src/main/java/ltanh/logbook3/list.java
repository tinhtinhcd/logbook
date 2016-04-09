package ltanh.logbook3;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ltanh.logbook3.data.table.Events;

public class list extends ListActivity{

    ListView listView;
    Events events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        events = new Events(getBaseContext());
        showList();
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {

        return super.onCreateView(name, context, attrs);
    }

    private void showList(){
        List<String> eventNames = getEvent();
        String[] events = new String[eventNames.size()];
        events = eventNames.toArray(events);

        ArrayAdapter<String> myAdapter = new ArrayAdapter <String>(this,android.R.layout.simple_list_item_1, events);
        setListAdapter(myAdapter);
    }

    private List<String> getEvent(){
        return events.getListEventName();
    }
}
