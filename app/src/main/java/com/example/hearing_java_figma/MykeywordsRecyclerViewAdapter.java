package com.example.hearing_java_figma;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.hearing_java_figma.VO.KeywordTuple;
import com.example.hearing_java_figma.databinding.FragmentKeywordsBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link com.example.hearing_java_figma.VO.KeywordTuple}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MykeywordsRecyclerViewAdapter extends RecyclerView.Adapter<MykeywordsRecyclerViewAdapter.ViewHolder> {

    private List<KeywordTuple> mValues;

    public MykeywordsRecyclerViewAdapter(List<KeywordTuple> items) {
        mValues = items;
    }

    public void setList(List<KeywordTuple> mValues){
        this.mValues = mValues;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentKeywordsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        /*holder.mIdView.setText(mValues.get(position).id);*/
        holder.mContentView.setText(mValues.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        /* public final TextView mIdView;*/
        public final TextView mContentView;
        public KeywordTuple mItem;

        public ViewHolder(FragmentKeywordsBinding binding) {
            super(binding.getRoot());
            /*mIdView = binding.itemNumber;*/
            binding.content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    KeywordsMenu(view);
                }
            });
            binding.deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setMessage("Are you sure you want to delete it?");
                    builder.setCancelable(true);
                    builder.setPositiveButton("Confirm",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //put your code that needed to be executed when okay is clicked
                                    AlertDialog.Builder builderok = new AlertDialog.Builder(view.getContext());
                                    builderok.setMessage("Delete function not yet incomplete");
                                    builderok.create().show();
                                }
                            });
                    builder.setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder.create().show();
                }
            });
            mContentView = binding.content;
        }
        private void KeywordsMenu(View view){

            PopupMenu popupmenu = new PopupMenu(view.getContext(), view);
            popupmenu.setGravity(Gravity.LEFT);
            popupmenu.getMenuInflater().inflate(R.menu.keywords_menu, popupmenu.getMenu());

            popupmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {

                    switch (menuItem.getItemId()){
                        case R.id.activate_switch:

                            break;
                        case R.id.deactivate_keyword:

                            break;
                    }
                    return true;
                }
            });
            popupmenu.show();

        }
        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}