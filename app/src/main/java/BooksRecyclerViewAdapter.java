import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylibraryapp.R;

public class BooksRecyclerViewAdapter extends RecyclerView.Adapter<BooksRecyclerViewAdapter.ViewHolder>  {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

    private CardView parent;
    private ImageView imgBook;
    private TextView txtBookName;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        parent= itemView.findViewById(R.id.parent);
        imgBook=itemView.findViewById(R.id.imgBook);
        txtBookName=itemView.findViewById(R.id.txtBookName);

    }
    }

}
