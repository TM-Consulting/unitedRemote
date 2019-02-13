package quiz.unitedremote.com.unitedremoteandroid;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.MyViewHolder>{
    ArrayList<String> listnames;
    ArrayList<String> listdescriptions;
    ArrayList<String> listowners;
    ArrayList<String> listnumberstarts;


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView cardview;
        public TextView reponame,description,ownername,startnumber;


        public MyViewHolder(View v){
            super(v);
            cardview= (CardView) v.findViewById(R.id.cardviewrepo);
            reponame = (TextView) v.findViewById(R.id.reponame);
            description = (TextView) v.findViewById(R.id.repodesc);
            ownername = (TextView) v.findViewById(R.id.repoowner);
            startnumber = (TextView) v.findViewById(R.id.starnumber);


        }
    }

    public RepoAdapter(ArrayList<String> listnames, ArrayList<String> listdescriptions, ArrayList<String> listowners, ArrayList<String> listnumberstarts) {
        this.listnames = listnames;
        this.listdescriptions = listdescriptions;
        this.listowners = listowners;
        this.listnumberstarts = listnumberstarts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.repoitem, parent, false);
        MyViewHolder vh= new MyViewHolder(v);

        Log.e("helooo","list "+listowners.toString());
        return  vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ownername.setText(listowners.get(position));
        holder.description.setText(listdescriptions.get(position));
        holder.reponame.setText(listnames.get(position));
        holder.startnumber.setText(listnumberstarts.get(position));

    }

    @Override
    public int getItemCount() {
        return listnames.size();
    }


}
