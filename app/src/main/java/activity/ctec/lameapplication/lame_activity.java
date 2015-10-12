package activity.ctec.lameapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.view.View;
import android.graphics.Color;
import android.content.Intent;

public class lame_activity extends AppCompatActivity
{

    private Button colorChangeButton;
    private Button swapScreenButton;
    private TextView basicText;
    private RelativeLayout background;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lame_activity);

        background = (RelativeLayout) findViewById(R.id.BackgroundLayout);
        basicText = (TextView) findViewById(R.id.sillyText);
        colorChangeButton = (Button) findViewById(R.id.sillyButton);
        swapScreenButton = (Button) findViewById(R.id.swapScreenButton);

        setupListeners();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lame_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void changeBackgroundColor()
    {
        int redColor;
        int greenColor;
        int blueColor;

        redColor = (int) (Math.random() * 256);
        greenColor = (int) (Math.random() * 256);
        blueColor = (int) (Math.random() * 256);

        background.setBackgroundColor(Color.rgb(redColor, greenColor, blueColor));

        redColor = (int) (Math.random() * 256);
        greenColor = (int) (Math.random() * 256);
        blueColor = (int) (Math.random() * 256);

        colorChangeButton.setBackgroundColor(Color.rgb(redColor, greenColor, blueColor));
    }

    private void changeVisiblity()
    {
        if(basicText.getVisibility() == View.VISIBLE)
        {
            basicText.setVisibility(View.GONE);
        }
        else
        {
            basicText.setVisibility(View.VISIBLE);
        }

        basicText.setVisibility(View.GONE);
    }

    private void setupListeners()
    {
        colorChangeButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View buttonView)
            {
                //this is where action happens
                changeBackgroundColor();
                changeVisiblity();
            }
        });

        swapScreenButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View buttonView)
            {
                Intent myIntent = new Intent(buttonView.getContext(), FoodActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

    }

}
