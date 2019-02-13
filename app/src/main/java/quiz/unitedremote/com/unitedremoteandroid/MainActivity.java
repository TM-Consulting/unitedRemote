package quiz.unitedremote.com.unitedremoteandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import quiz.unitedremote.com.unitedremoteandroid.controller.RepoController;
import quiz.unitedremote.com.unitedremoteandroid.entity.AllRepositories;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RepoController.RepoInfos service = RepoController.getRetrofitInstance().create(RepoController.RepoInfos.class);

    RepoAdapter adapter;
    ArrayList<String> listnames= new ArrayList<String>();
    ArrayList<String> listdescriptions= new ArrayList<String>();
    ArrayList<String> listowners= new ArrayList<String>();
    ArrayList<String> listnumberstarts= new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.my_recycler_view);
        rv.setHasFixedSize(true);
        adapter = new RepoAdapter( listnames, listdescriptions, listowners, listnumberstarts);
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(llm);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(800);
        itemAnimator.setRemoveDuration(800);
        rv.setItemAnimator(itemAnimator);
        getData();
    }



    public void getData(){
        service.getAllrepositories().enqueue(new Callback<AllRepositories>() {
            @Override
            public void onResponse(Call<AllRepositories> call, Response<AllRepositories> response) {
               if(response.isSuccessful()){
                   for(int i=0;i<response.body().getItems().size();i++){
                       listnames.add(response.body().getItems().get(i).getName());
                       listdescriptions.add(response.body().getItems().get(i).getDescription());
                       listowners.add(response.body().getItems().get(i).getOwner().getLogin());
                       listnumberstarts.add(""+response.body().getItems().get(i).getWatchers());// I consider that watchers is the number pf starts
                       adapter.notifyDataSetChanged();
                   }
               }
            }

            @Override
            public void onFailure(Call<AllRepositories> call, Throwable t) {

            }
        });
    }
}
