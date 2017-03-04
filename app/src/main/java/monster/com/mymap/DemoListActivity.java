package monster.com.mymap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by ASUS on 2017/3/2.
 */

public class DemoListActivity extends ListActivity {
   private ClassAndName[] datas = {new ClassAndName(MainActivity.class,"定位到家乡"),new ClassAndName(CircleOptionsActivity.class,"圆形覆盖物"),new
           ClassAndName(TextOverLayActivity.class,"文本覆盖物"),new ClassAndName(MarkerOverLayActivity.class,"图标覆盖物"),new ClassAndName(SearchInBoundActivity.class,"范围内搜索")};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<ClassAndName> adapter = new ArrayAdapter<ClassAndName>(this,android.R.layout.simple_list_item_1,datas);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        ClassAndName classAndName = (ClassAndName) l.getItemAtPosition(position);
        startActivity(new Intent(this,classAndName.clss));
    }

    class  ClassAndName{
        public Class<?> clss;
        public  String name;
        public ClassAndName (Class<?> clss,String name){
            this.clss = clss;
            this.name = name;
        }
        public  String toString(){
            return name;
        }
    }

}
