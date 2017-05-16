package application.cartoon.com.checkboxrec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import application.cartoon.com.checkboxrec.adapter.BookAdapter;
import application.cartoon.com.checkboxrec.bean.Book;
import application.cartoon.com.checkboxrec.bean.ResultBean;
import application.cartoon.com.checkboxrec.view.ListViewDecoration;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
    private Toolbar toolbar;
private Button ok;
    private List<Book> bookList=new ArrayList<>();
    private BookAdapter adapter;
//adapteradapteradapter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            initView();
            initData();

    }

    private void initData() {
        for (int i = 0; i <20 ; i++) {
           Book book=new Book();
            book.setName("商品"+i);
            book.setId(i);
            book.setChose(false);
            book.setDesc("描述"+i);
bookList.add(book);
        }
        adapter = new BookAdapter(this, bookList);
        recyclerView.setAdapter(adapter);
    }

    private void initView() {
recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        ok= (Button) findViewById(R.id.ensure);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new ListViewDecoration(this));
        //设置toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
        toolbar.setBackgroundResource(R.color.colorPrimary);

        toolbar.inflateMenu(R.menu.base_toolbar_menu);//设置右上角的填充菜单
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId = item.getItemId();
                if (menuItemId == R.id.selectAll) {
                    for (int i=0 ;i<bookList.size();i++
                            ) {
                        if (!bookList.get(i).isChose()){
                            bookList.get(i).setChose(true);
                            adapter.notifyItemChanged(i);
                        }
                    }
                  //  adapter.selectAll(recyclerView);

                } else if (menuItemId == R.id.deleteAll) {
                    Toast.makeText(MainActivity.this , "dfksa" , Toast.LENGTH_SHORT).show();

                    for (int i=0 ;i<bookList.size();i++
                            ) {
                       if (bookList.get(i).isChose()){
                        bookList.get(i).setChose(false);
                       adapter.notifyItemChanged(i);
                       }
                    }
                   // adapter.selectAll(recyclerView);
                }
                return true;
            }
        });
ok.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        List<Book> list=new ArrayList();
for (int i=0 ;i<bookList.size();i++){
    if (bookList.get(i).isChose()){
        list.add(bookList.get(i));
    }
}
        Gson gson=new Gson();
        ResultBean bean = new ResultBean();
        bean.setBookList(list);
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("result",gson.toJson(bean));
        startActivity(intent);
    }
});
    }
}
