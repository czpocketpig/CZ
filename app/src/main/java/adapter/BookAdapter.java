package adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cz.cz.R;

import java.util.List;

import entity.BookInfo;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2017/10/26.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private Context context;
    private List<BookInfo> bookInfos;


    public BookAdapter(List<BookInfo> bookInfos) {
        this.bookInfos = bookInfos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BookInfo bookInfo = bookInfos.get(position);
        holder.bookname_or_author.setText(bookInfo.getName() + bookInfo.getAuthor());
        holder.publisher.setText(bookInfo.getPublisher());
//        Log.i(TAG, "onBindViewHolder: " + bookInfo.isBorrow() + 1);
      if (bookInfo.getState()==1)
      {
        holder.isBorrow.setText("可借");
        holder.time.setText(bookInfo.getPlace());
      }else{
          holder.isBorrow.setText("不可借");
          holder.time.setText(bookInfo.getReturnDate());
      }

    }


    @Override
    public int getItemCount() {
        return bookInfos.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView bookname_or_author, publisher, time, isBorrow;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            bookname_or_author = cardView.findViewById(R.id.NameAndAuthor);
            publisher = cardView.findViewById(R.id.publisher);
            time = cardView.findViewById(R.id.time_or_palce);
            isBorrow = cardView.findViewById(R.id.isBorrowing);
        }
    }
}
