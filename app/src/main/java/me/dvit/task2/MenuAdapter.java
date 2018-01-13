package me.dvit.task2;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuAdapterViewHolder> {
    Context context;
    List<CustomMenu> customMenu;
    public MenuAdapter( List<CustomMenu> customMenu){
        this.customMenu = customMenu;
    }
    @Override
    public MenuAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
       MenuAdapterViewHolder holder = new MenuAdapterViewHolder(row);
        return holder;

    }

    @Override
    public void onBindViewHolder(final MenuAdapterViewHolder holder, final int position)  {
        final CustomMenu custom = customMenu.get(position);
        holder.item_text.setText(custom.menu_item_name);
        holder.item_image.setImageResource(custom.menu_item_icon);

    }

    @Override
    public int getItemCount() {
        return customMenu.size();
    }
    class MenuAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView item_text;
        ImageView item_image;

        public MenuAdapterViewHolder(View itemView) {
            super(itemView);
            item_text = (TextView) itemView.findViewById(R.id.item_name);
            item_image = (ImageView) itemView.findViewById(R.id.item_icon);

        }



           /* if (position==0){

                HomeFragment fragment = new HomeFragment();
                FragmentTransaction fragmentTransaction = ((AppCompatActivity) context).getSupportFragmentManager()
                        .beginTransaction();
                fragmentTransaction.replace(R.id.nav_view, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
            else if (position==1){

            }
            else if (position==2){

            }
            else if (position==3){

            }*/

        }

    }




