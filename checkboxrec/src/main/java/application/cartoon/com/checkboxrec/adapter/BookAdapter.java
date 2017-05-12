package application.cartoon.com.checkboxrec.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import application.cartoon.com.checkboxrec.R;
import application.cartoon.com.checkboxrec.bean.Book;


public class BookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private List<Book> bookList;
private LayoutInflater inflater ;
    private ScaleAnimation animation;
int i;
    public BookAdapter(Context context,List<Book> bookList) {

        inflater=LayoutInflater.from(context);
        animation= (ScaleAnimation) AnimationUtils.loadAnimation(context,R.anim.check_in);
        animation.setFillAfter(true);

        this.bookList=bookList;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View view=inflater.inflate(R.layout.rec_item,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof MyViewHolder) {
i++;
            Log.e("TAG",i+"");
            ((MyViewHolder) holder).chose= (CheckBox) holder.itemView.findViewById(R.id.checkbox);
            ((MyViewHolder)holder).chose.setChecked(((MyViewHolder)holder).chose.isChecked());
            ((MyViewHolder)holder).chose.startAnimation(animation);
            ((MyViewHolder)holder).content.setText(bookList.get(position).getName());
            ((MyViewHolder)holder).chose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    bookList.get(position).setChose(((MyViewHolder)holder).chose.isChecked());

                    ((MyViewHolder)holder).chose.startAnimation(animation);
                }
            });


        }
    }

    @Override
    public int getItemCount() {

        return bookList!=null?bookList.size():0;
    }











    /**
     * 全选或删除
     *
     * @param parent
     */
    public void selectAll(RecyclerView parent) {


        int visibleChildCount = parent.getChildCount();

        for (int i = 0; i < visibleChildCount; i++) {
            View view = parent.getChildAt(i);
            CheckBox chose = (CheckBox) view.findViewById(R.id.checkbox);
            final RecyclerView.ViewHolder holder = parent.getChildViewHolder(view);

            if(holder!=null&&holder instanceof MyViewHolder){

               ((MyViewHolder) holder).chose.startAnimation(animation);
//            notifyDataSetChanged();
                ((MyViewHolder) holder).chose.setChecked(bookList.get(holder.getLayoutPosition()).isChose());
            }

        }
    }

    /**
     * 取消
     *
     * @param parent
     */
    public void deleteAll(RecyclerView parent) {


        int visibleChildCount = parent.getChildCount();
        for (int i = 0; i < visibleChildCount; i++) {
            View view = parent.getChildAt(i);
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox);

        }
    }








    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView content;
        private CheckBox chose;

        public MyViewHolder(View itemView) {
            super(itemView);
content= (TextView) itemView.findViewById(R.id.content);
            chose= (CheckBox) itemView.findViewById(R.id.checkbox);


        }
    }


}
