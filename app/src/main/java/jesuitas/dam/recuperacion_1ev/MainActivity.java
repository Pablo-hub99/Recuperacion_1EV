package jesuitas.dam.recuperacion_1ev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.first);

        registerForContextMenu(textView);


    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        getMenuInflater().inflate(R.menu.menu_press,menu);

    }
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.Edit:
                Intent intent = new Intent(this, Segunda_Pantalla.class);
                startActivity(intent);
            case R.id.Delete:
                TextView email = findViewById(R.id.Email);
                email.setText("");
                TextView phone = findViewById(R.id.Phone);
                phone.setText("");
                TextView name = findViewById(R.id.Name);
                name.setText("");
        }

        return super.onContextItemSelected(item);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.meny_main, menu);
        return true;
    }


    public void Gold(MenuItem item) {
    }

    public void white(MenuItem item) {
    }
    public void Contactar (Button button){
        RadioButton usePhone = findViewById(R.id.usePhone);
        RadioButton UseEmail = findViewById(R.id.UseEmail);
        TextView phone = findViewById(R.id.Phone);
        TextView email = findViewById(R.id.Email);
        if(!usePhone.isChecked() && !UseEmail.isChecked()){
            Toast myToast =Toast.makeText(this,"Seleccione metodo de contacto", Toast.LENGTH_LONG);
            myToast.show();
        }
        else if(usePhone.isChecked() &&  phone.isEnabled()){
            Toast myToast =Toast.makeText(this,"Numero de telefono no encontrado", Toast.LENGTH_LONG);
            myToast.show();

        }
        else if(usePhone.isChecked() && !phone.isEnabled()){
            Intent sendIntent = new Intent();
            sendIntent.putExtra(Intent.EXTRA_PHONE_NUMBER);
        }
        else if(UseEmail.isChecked() &&  email.isEnabled()){
            Toast myToast =Toast.makeText(this,"Correo electronico no encontrado", Toast.LENGTH_LONG);
            myToast.show();
    }
        else if(usePhone.isChecked() && !phone.isEnabled()){
            Intent sendIntent = new Intent();
            sendIntent.setAction(sendIntent.ACTION_SENDTO);
            sendIntent.setData(Uri.parse("mailto:"));
            sendIntent.putExtra(Intent.EXTRA_TEXT);
            sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[]);
            sendIntent.putExtra(Intent.EXTRA_SUBJECT);

        }

    }
}
