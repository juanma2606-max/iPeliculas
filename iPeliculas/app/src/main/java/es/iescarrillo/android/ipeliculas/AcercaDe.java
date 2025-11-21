package es.iescarrillo.android.ipeliculas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AcercaDe extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.acerca_de);

        //Creamos la toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_acerca_de);
        setSupportActionBar(toolbar);
        //Añadimos el botón de volver
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    //Añadimos el botón de volver
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}