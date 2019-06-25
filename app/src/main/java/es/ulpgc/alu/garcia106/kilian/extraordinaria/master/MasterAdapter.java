package es.ulpgc.alu.garcia106.kilian.extraordinaria.master;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.alu.garcia106.kilian.extraordinaria.R;
import es.ulpgc.alu.garcia106.kilian.extraordinaria.data.Letter;

public class MasterAdapter extends RecyclerView.Adapter<MasterAdapter.ViewHolder> {

  private List<Letter> letters;
  private final View.OnClickListener clickListener;

  public MasterAdapter(View.OnClickListener clickListener) {
    this.letters = new ArrayList<>();
    this.clickListener = clickListener;
  }

  public void addItem(Letter letter) {
    letters.add(letter);
    notifyDataSetChanged();
  }

  public void addItems(List<Letter> letters) {
    letters.addAll(letters);
    notifyDataSetChanged();
  }

  public void setLetters(List<Letter> letters) {
    this.letters = letters;
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
    holder.itemView.setTag(letters.get(position));
    holder.itemView.setOnClickListener(clickListener);

    char  letter = letters.get(position).getLetter();
    holder.letterText.setText(Character.toString(letter));
  }

  @Override
  public int getItemCount() {
    return letters.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView letterText;

    ViewHolder(View view) {
      super(view);
      letterText = view.findViewById(R.id.letter_text);

    }
  }
}
