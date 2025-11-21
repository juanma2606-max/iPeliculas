package es.iescarrillo.android.ipeliculas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Detalles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles);

        Toolbar toolbar = findViewById(R.id.toolbar_detalles);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Obtener referencias de Views
        TextView tvTitulo = findViewById(R.id.tittle);
        TextView tvGenero = findViewById(R.id.genre);
        TextView tvDescripcion = findViewById(R.id.desc);
        ImageView imgPelicula = findViewById(R.id.img);
        TextView tvDirector = findViewById(R.id.director);
        TextView tvDate = findViewById(R.id.date);
        RatingBar ratingBar = findViewById(R.id.stars);

        // Obtener los datos pasados desde MainActivity
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String titulo = extras.getString("TITULO");
            String genero = extras.getString("GENERO");
            String descripcion = extras.getString("DESCRIPCION");
            String director = extras.getString("DIRECTOR");
            String date = extras.getString("DATE");
            float rating = extras.getFloat("RATING");
            int imagenResId = extras.getInt("IMAGEN_RES_ID", 0); // 0 es el valor por defecto

            // Mostrar los datos
            tvTitulo.setText(titulo);
            tvGenero.setText(genero);
            tvDescripcion.setText(descripcion);
            tvDirector.setText(director);
            tvDate.setText(date);
            ratingBar.setRating(rating);

            if (imagenResId != 0) {
                imgPelicula.setImageResource(imagenResId);
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuAcercaDe) {
            Intent viewNameIntent = new Intent(this, AcercaDe.class);
            startActivity(viewNameIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}