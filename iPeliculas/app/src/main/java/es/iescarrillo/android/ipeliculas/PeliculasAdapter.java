package es.iescarrillo.android.ipeliculas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasAdapter.ProductViewHolder> {

    private static List<Peliculas> filmList;
    private Context context;
    private static OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Peliculas pelicula);
    }

    public PeliculasAdapter(Context context, List<Peliculas> filmList) {
        this.context = context;
        this.filmList = filmList;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProduct;
        TextView tvName, tvGenre, tvDescription;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.myImageView);
            tvName = itemView.findViewById(R.id.tvTitle);
            tvGenre = itemView.findViewById(R.id.genero);
            tvDescription = itemView.findViewById(R.id.tvDescription);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    // getAdapterPosition() podría ser NO_POSITION si el ítem está siendo animado.
                    if (position != RecyclerView.NO_POSITION) {
                        // Obtener la película y llamar al método de la interfaz
                        listener.onItemClick(filmList.get(position));
                    }
                }
            });

        }
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pelicula_plantilla, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        Peliculas pelicula = filmList.get(position);

        holder.tvName.setText(pelicula.getTitle());
        holder.tvGenre.setText(pelicula.getGenre());
        holder.tvDescription.setText(pelicula.getDescription());

        holder.imgProduct.setImageResource(pelicula.getImageRes());

    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }
}
