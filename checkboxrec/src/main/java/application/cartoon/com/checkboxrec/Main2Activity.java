package application.cartoon.com.checkboxrec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

import application.cartoon.com.checkboxrec.adapter.BookAdapter;
import application.cartoon.com.checkboxrec.bean.Book;
import application.cartoon.com.checkboxrec.bean.ResultBean;
import application.cartoon.com.checkboxrec.view.ListViewDecoration;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<Book> bookList;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();
        initData();

    }

    private void initData() {
       Gson gson=new Gson();
       ResultBean bean= gson.fromJson(getIntent().getStringExtra("result"), ResultBean.class);
        adapter = new BookAdapter(this, bean.getBookList());
        recyclerView.setAdapter(adapter);
    }

    private void initView() {
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new ListViewDecoration(this));

    }
}
