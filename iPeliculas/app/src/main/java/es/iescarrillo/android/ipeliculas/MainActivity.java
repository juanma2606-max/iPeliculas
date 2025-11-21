package es.iescarrillo.android.ipeliculas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PeliculasAdapter.OnItemClickListener{

    private RecyclerView recyclerView;
    private PeliculasAdapter adapter;
    private List<Peliculas> filmtList;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Creamos la toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // [1]
        //Creamos el recyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //CReamos sus items
        filmtList = new ArrayList<>();

        filmtList.add(new Peliculas("John Wick", "accion", "Lorem ipsum dolor sit amet consectetur adipiscing elit, conubia lacus condimentum euismod aenean nullam curabitur, cubilia nulla potenti quisque tincidunt feugiat. Felis bibendum ac condimentum mauris natoque dui pharetra penatibus sociis, ligula sed nulla risus integer nisi orci faucibus parturient, iaculis odio eleifend nam laoreet fringilla mus cubilia. Pulvinar praesent sapien inceptos accumsan interdum penatibus curae aenean molestie litora nibh, ac consequat netus aliquam orci tincidunt nunc volutpat ultrices eleifend gravida, facilisis dapibus aliquet blandit in eu laoreet vel magna sodales.\n" +
                "\n", 5, R.drawable.wick, "Chad Stahelski", "10 de febrero de 2017"));
        filmtList.add(new Peliculas("Spiderman 2", "superheroes", "Lorem ipsum dolor sit amet consectetur adipiscing elit, conubia lacus condimentum euismod aenean nullam curabitur, cubilia nulla potenti quisque tincidunt feugiat. Felis bibendum ac condimentum mauris natoque dui pharetra penatibus sociis, ligula sed nulla risus integer nisi orci faucibus parturient, iaculis odio eleifend nam laoreet fringilla mus cubilia. Pulvinar praesent sapien inceptos accumsan interdum penatibus curae aenean molestie litora nibh, ac consequat netus aliquam orci tincidunt nunc volutpat ultrices eleifend gravida, facilisis dapibus aliquet blandit in eu laoreet vel magna sodales.\n" +
                "\n", 5, R.drawable.spiderman2,"Sam Raimi","30 de junio de 2004"));
        filmtList.add(new Peliculas("Transformers", "accion", "Lorem ipsum dolor sit amet consectetur adipiscing elit, conubia lacus condimentum euismod aenean nullam curabitur, cubilia nulla potenti quisque tincidunt feugiat. Felis bibendum ac condimentum mauris natoque dui pharetra penatibus sociis, ligula sed nulla risus integer nisi orci faucibus parturient, iaculis odio eleifend nam laoreet fringilla mus cubilia. Pulvinar praesent sapien inceptos accumsan interdum penatibus curae aenean molestie litora nibh, ac consequat netus aliquam orci tincidunt nunc volutpat ultrices eleifend gravida, facilisis dapibus aliquet blandit in eu laoreet vel magna sodales.\n" +
                "\n", 5, R.drawable.trans,"Michael Bay","5 de julio de 2007"));
        filmtList.add(new Peliculas("Avatar", "ciencia-ficción", "Lorem ipsum dolor sit amet consectetur adipiscing elit, conubia lacus condimentum euismod aenean nullam curabitur, cubilia nulla potenti quisque tincidunt feugiat. Felis bibendum ac condimentum mauris natoque dui pharetra penatibus sociis, ligula sed nulla risus integer nisi orci faucibus parturient, iaculis odio eleifend nam laoreet fringilla mus cubilia. Pulvinar praesent sapien inceptos accumsan interdum penatibus curae aenean molestie litora nibh, ac consequat netus aliquam orci tincidunt nunc volutpat ultrices eleifend gravida, facilisis dapibus aliquet blandit in eu laoreet vel magna sodales.\n" +
                "\n", 5, R.drawable.avatar,"James Cameron","18 de diciembre de 2009"));
        filmtList.add(new Peliculas("Jurassic Park", "ciencia-ficción", "Lorem ipsum dolor sit amet consectetur adipiscing elit, conubia lacus condimentum euismod aenean nullam curabitur, cubilia nulla potenti quisque tincidunt feugiat. Felis bibendum ac condimentum mauris natoque dui pharetra penatibus sociis, ligula sed nulla risus integer nisi orci faucibus parturient, iaculis odio eleifend nam laoreet fringilla mus cubilia. Pulvinar praesent sapien inceptos accumsan interdum penatibus curae aenean molestie litora nibh, ac consequat netus aliquam orci tincidunt nunc volutpat ultrices eleifend gravida, facilisis dapibus aliquet blandit in eu laoreet vel magna sodales.\n" +
                "\n", 5, R.drawable.jp,"Steven Spielberg","11 de junio de 1993"));

        adapter = new PeliculasAdapter(this, filmtList);
        adapter.setOnItemClickListener(this); // 'this' se refiere a MainActivity, que implementa la interfaz
        recyclerView.setAdapter(adapter);
        recyclerView.scheduleLayoutAnimation();


    }

    public void onItemClick(Peliculas peliculaSeleccionada) {
        // En lugar de Toast, iniciaremos la nueva Activity
        // Toast.makeText(this, "Clic en: " + peliculaSeleccionada.getTitle(), Toast.LENGTH_SHORT).show();

        // 4. Iniciar la Activity de detalles (asumiendo que se llama DetallesActivity)
        Intent intent = new Intent(this, Detalles.class);

        // PASAR DATOS: Los objetos completos de Java no se pueden pasar directamente.
        // Se recomienda pasar los datos individuales o hacer que la clase Peliculas implemente Parcelable/Serializable.

        // Opción Recomendada (Pasar datos individuales):
        intent.putExtra("TITULO", peliculaSeleccionada.getTitle());
        intent.putExtra("GENERO", peliculaSeleccionada.getGenre());
        intent.putExtra("DESCRIPCION", peliculaSeleccionada.getDescription());
        intent.putExtra("IMAGEN_RES_ID", peliculaSeleccionada.getImageRes());
        intent.putExtra("DIRECTOR", peliculaSeleccionada.getDirector());
        intent.putExtra("DATE", peliculaSeleccionada.getDate());
        intent.putExtra("RATING", peliculaSeleccionada.getRating());

        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Usar un switch es más limpio para múltiples opciones de menú
        if (item.getItemId() == R.id.menuAcercaDe) {
            Intent viewNameIntent = new Intent(this, AcercaDe.class);
            startActivity(viewNameIntent);
            return true; // Evento manejado
        }
        // Para cualquier otro caso, delega el comportamiento a la clase padre.
        return super.onOptionsItemSelected(item);
    }
}