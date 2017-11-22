package com.devtolife.vkvideoline;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKList;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {


    Context context;
    ModelVideo modVid;
    ModelVideo[] myDataset;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] scope = new String[]{VKScope.VIDEO, VKScope.WALL, VKScope.FRIENDS};
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VKSdk.login(this, scope);
        context = getApplicationContext();
//
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {


                //
                final VKRequest request = VKApi.video().get(VKParameters
                        .from(VKApiConst.FIELDS, "title,duration,photo_320,player"));

                request.executeWithListener(new VKRequest.VKRequestListener() {


                    @Override
                    public void onComplete(VKResponse response) {
                        super.onComplete(response);

                        VKList<com.vk.sdk.api.model.VKApiVideo> list = (VKList) response.parsedModel;

                                            myDataset = new ModelVideo[list.size()];
                        for (int i = 0; i <= list.size() - 1; i++) {

                            modVid = new ModelVideo(i,
                                    list.get(i).photo_320,
                                    list.get(i).title,
                                    list.get(i).duration,
                                    list.get(i).player);

                            myDataset[i] = modVid;
                        }


                        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

                        // use a linear layout manager
                        mLayoutManager = new LinearLayoutManager(context);

                        mRecyclerView.setLayoutManager(mLayoutManager);

                        mAdapter = new MyRecyclerAdapter(context, myDataset);
                        mRecyclerView.setAdapter(mAdapter);



                        mRecyclerView.addOnItemTouchListener(
                                new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(View view, int position) {

                                        Intent intent = new Intent(MainActivity.this, FullActivity.class);

                                        String stringUrlVideo = null;
                                        stringUrlVideo = myDataset[position].getUrlVideo();

//                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        intent.putExtra("title", stringUrlVideo);
                                        startActivity(intent);
                                    }
                                })
                        );
                    }

                    @Override
                    public void onError(VKError error) {
                        //Do error stuff
                    }

                    @Override
                    public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
                        //I don't really believe in progress
                    }
                });
            }

            @Override
            public void onError(VKError error) {
                // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        } else {
            return;
        }

    }


    public void onProgressClick(View view) {
        Toast.makeText(this, "Подождите, идёт загрузка!", Toast.LENGTH_LONG).show();
    }
}
