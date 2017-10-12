package cc.fadhil.aplikasiresep;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import static android.R.attr.start;

/**
 * Created by ASUS on 24/09/2017.
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
	Context context;
	DaftarResep dr = new DaftarResep();
	LayoutInflater inflater;

	public RecyclerAdapter(Context context) {
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = inflater.inflate(R.layout.item_list, parent, false);
		RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(RecyclerViewHolder holder, int position) {
		holder.cv.setOnClickListener(click);
		holder.tvJudul.setText(dr.getJudulresep(position));
		holder.tvDeskripsi.setText(dr.getDeskripsi(position));

		holder.iv.setImageResource(dr.getGambarresep(position));
		holder.cv.setTag(holder);
	}

	View.OnClickListener click = new View.OnClickListener() {
		@Override
		public void onClick(View view) {
			RecyclerViewHolder vholder = (RecyclerViewHolder) view.getTag();

			int position = vholder.getPosition();

			Intent i = new Intent(context, Detail.class);
			i.putExtra("index", position);
			context.startActivity(i);
		}
	};

	@Override
	public int getItemCount() {
		return dr.judulresep.length;
	}
}

