package es.ulpgc.alu.garcia106.kilian.extraordinaria.master;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.alu.garcia106.kilian.extraordinaria.R;
import es.ulpgc.alu.garcia106.kilian.extraordinaria.data.Item;

public class MasterAdapter extends RecyclerView.Adapter<MasterAdapter.ViewHolder> {

  private List<Item> items;
  private final View.OnClickListener clickListener;

  public MasterAdapter(View.OnClickListener clickListener) {
    this.items = new ArrayList<>();
    this.clickListener = clickListener;
  }

  public void addItem(Item item) {
    items.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<Item> items) {
    items.addAll(items);
    notifyDataSetChanged();
  }

  public void setItems(List<Item> items) {
    items = items;
    notifyDataSetChanged();
  }


  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.master_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.itemView.setTag(items.get(position));
    holder.itemView.setOnClickListener(clickListener);

    String letter = items.get(position).getLetter();
    holder.letterText.setText(letter);
  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView letterText;

    ViewHolder(View view) {
      super(view);
      letterText = view.findViewById(R.id.letter_text);

    }
  }
}
