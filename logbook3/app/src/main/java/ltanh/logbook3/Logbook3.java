package ltanh.logbook3;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import ltanh.logbook3.Entities.Event;
import ltanh.logbook3.data.table.Events;

public class Logbook3 extends AppCompatActivity{


    protected AutoCompleteTextView venueTxt;
    protected AutoCompleteTextView organizerTxt;
    protected EditText eventTxt;
    protected TextView startDatetxt,dateOfEvent;
    protected Button save;
    private Events eventRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook3);
        eventRepository = new Events(getBaseContext());
    }

    @Override
    protected void onStart() {
        super.onStart();
        eventTxt = (EditText)findViewById(R.id.event_name);
        startDatetxt = (TextView)findViewById(R.id.start_date);
        dateOfEvent = (TextView)findViewById(R.id.date_of_event);
        venueTxt = (AutoCompleteTextView)findViewById(R.id.venue);
        organizerTxt = (AutoCompleteTextView)findViewById(R.id.organizer);
        save = (Button)findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveEvent();
            }
        });
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    private void saveEvent(){

        Event event = new Event();
        event.setEventName(eventTxt.getText() != null ? eventTxt.getText().toString() : "");
        event.setDateOfEvent(dateOfEvent.getText()!=null?dateOfEvent.getText().toString() : "");
        event.setStartDate(startDatetxt.getText()!=null?startDatetxt.getText().toString() : "");
        event.setVenueId(venueTxt.getText()!=null?venueTxt.getText().toString() : "");
        event.setOrganizer(organizerTxt.getText()!=null?organizerTxt.getText().toString() : "");
        eventRepository.create(event);

        listEvent();
    }

    private void listEvent(){
        Intent intent = new Intent(Logbook3.this,list.class);
        startActivity(intent);

    }
}
