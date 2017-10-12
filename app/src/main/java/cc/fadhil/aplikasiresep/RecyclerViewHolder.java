package cc.fadhil.aplikasiresep;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by ASUS on 24/09/2017.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

	TextView tvJudul, tvDeskripsi;
	ImageView iv;
	RelativeLayout cv;
	public RecyclerViewHolder(View itemView) {
		super(itemView);

		tvJudul = (TextView) itemView.findViewById(R.id.tv_judul);
		tvDeskripsi = (TextView) itemView.findViewById(R.id.tv_deskripsi);
		iv = (ImageView) itemView.findViewById(R.id.iv_gambar);
		cv = (RelativeLayout) itemView.findViewById(R.id.rel);
	}
}
