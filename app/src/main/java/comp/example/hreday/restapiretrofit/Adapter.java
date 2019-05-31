package comp.example.hreday.restapiretrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;

    List<PojoClass> list;


    public Adapter() {
    }

    public Adapter(Context context, List<PojoClass> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.sample,parent,false);


        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        PojoClass hh=list.get(position);
        holder.muthor.setText(hh.getName());
        Picasso.get().load(hh.getImage()).into(holder.img);
        holder.mame.setText(hh.getHobby());
       // Picasso.get().load(hh.getImage()).into(holder.img);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is the activity", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView muthor,mame;
        ImageView img;

       // ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);

            muthor=itemView.findViewById(R.id.text1Id);
            img=itemView.findViewById(R.id.imageId);
           // img=itemView.findViewById(R.id.imageId);
            mame=itemView.findViewById(R.id.text2Id);
        }
    }
}
