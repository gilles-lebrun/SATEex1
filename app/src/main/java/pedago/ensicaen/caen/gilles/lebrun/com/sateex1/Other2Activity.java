package pedago.ensicaen.caen.gilles.lebrun.com.sateex1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Other2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other2);
        Intent intentInfo = getIntent();
        String nomButton = intentInfo.getStringExtra("monButton");
        Button btn = (Button)findViewById(R.id.button_act2);
        btn.setText(nomButton);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_other2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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

    public void returnButton(View view) {
        Intent intentRes = new Intent();
        intentRes.putExtra("Resultat", "C'est +++++ OK!");
        setResult(MesConstantes.RESULT_OK, intentRes);
        finish();
    }
}
