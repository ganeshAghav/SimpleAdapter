package ganesh.com.adaptersimple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView simpleListView;
    String[] animalName={"Apple","1","EITS","2","Nile Petrolieum","3","United petrolieum","4","5","6","7"};
    int [] animalImages={R.drawable.applelogo,R.drawable.a,R.drawable.eitslogo,R.drawable.b,
            R.drawable.nilepetrolieum,R.drawable.c,R.drawable.unitedpetroleum,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleListView= (ListView) findViewById(R.id.simpleListView);

        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();

        for(int i=0;i<animalName.length;i++)
        {
            HashMap<String,String> hashMap=new HashMap<>();
            hashMap.put("name",animalName[i]);
            hashMap.put("image",animalImages[i]+"");
            arrayList.add(hashMap);
        }
        String[] from={"name","image"};
        int[] to={R.id.textView,R.id.imageView};

        SimpleAdapter simpleAdapter=new SimpleAdapter(MainActivity.this,arrayList,R.layout.list_view_items,from,to);
        simpleListView.setAdapter(simpleAdapter);


        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),animalName[i],Toast.LENGTH_LONG).show();
            }
        });

    }
}
