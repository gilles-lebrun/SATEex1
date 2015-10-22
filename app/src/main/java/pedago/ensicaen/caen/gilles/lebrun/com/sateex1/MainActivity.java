package pedago.ensicaen.caen.gilles.lebrun.com.sateex1;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void monButton(View view) {
        Log.v("SATE3A", "click sur le boutton");
        Toast.makeText(this, "Click button", Toast.LENGTH_LONG).show();
        String info = ((EditText)findViewById(R.id.info_recherche)).getText().toString();
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, info);
        startActivity(intent);
    }

    public void monButtonOther(View view) {
        Intent intent = new Intent(this, Other2Activity.class);
        intent.putExtra("monButton", "Retourner à l'Activité");
        startActivityForResult(intent, MesConstantes.INFO2OTHER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==MesConstantes.INFO2OTHER){
            String mess = "??????";
            if (resultCode==MesConstantes.RESULT_OK) {
                mess = data.getStringExtra("Resultat");
            }
            TextView tv = (TextView)findViewById(R.id.textreturn);
            tv.setText(mess);

        }
    }
}
