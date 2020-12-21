package jesuitas.dam.recuperacion_1ev;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class Segunda_Pantalla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda__pantalla);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_segundo, menu);
        return true;
    }

    public void Cancel(MenuItem item) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Check(MenuItem item) {
        final EditText name = findViewById(R.id.Name);
        final EditText email = findViewById(R.id.Email);
        final EditText phone = findViewById(R.id.Phone);
        if( name.isEnabled() && phone.isEnabled() && email.isEnabled()){
            Toast myToast = Toast.makeText(this, "Completa todos los datos", Toast.LENGTH_LONG);
            myToast.show();
        }
        else if(name.isEnabled() && phone.isEnabled() && email.isEnabled()){
        AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(Segunda_Pantalla.this);
        myAlertBuilder.setMessage("¿Está seguro?");
        myAlertBuilder.setPositiveButton("SÍ", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent sendIntent = new Intent();
                sendIntent.putExtra("name", name.getText().toString());
                sendIntent.putExtra("email", email.getText().toString());
                sendIntent.putExtra("phone", phone.getText().toString());
                startActivity(sendIntent);


            }
        }
    }
}
}



