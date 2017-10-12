package cc.fadhil.aplikasiresep;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {
	TextView mtv_detail_judul;
	TextView mtv_detail_alatbahan;
	TextView mtv_detail_t_alatbahan;
	ImageView miv_detail_gambar;
	TextView mtv_detail_caramasak;
	TextView mtv_detail_t_caramasak;
	ImageView miv_back;


	boolean showingFirst = true;
	boolean showing2 = true;
	DaftarResep resep = new DaftarResep();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		int index = getIntent().getIntExtra("index",0);

		mtv_detail_judul = (TextView) findViewById(R.id.tv_detail_judul);
		mtv_detail_alatbahan = (TextView) findViewById(R.id.tv_detail_alatbahan);
		mtv_detail_t_alatbahan = (TextView) findViewById(R.id.tv_detail_t_alatbahan);
		miv_detail_gambar = (ImageView) findViewById(R.id.iv_detail_gambar);
		mtv_detail_caramasak = (TextView) findViewById(R.id.tv_detail_caramasak);
		mtv_detail_t_caramasak = (TextView) findViewById(R.id.tv_detail_t_caramasak);
		miv_back = (ImageView) findViewById(R.id.iv_back);

		mtv_detail_t_alatbahan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				if (showingFirst==true){
					Drawable draw2 = getResources().getDrawable(R.drawable.panah_atas);
					mtv_detail_t_alatbahan.setCompoundDrawablesWithIntrinsicBounds(null, null, draw2, null);
					mtv_detail_alatbahan.setVisibility(View.VISIBLE);
					showingFirst = false;
				}else{
					Drawable draw = getResources().getDrawable(R.drawable.panah_bawah);
					mtv_detail_t_alatbahan.setCompoundDrawablesWithIntrinsicBounds(null, null, draw, null);
					mtv_detail_alatbahan.setVisibility(View.GONE);
					showingFirst =true;
				}

			}
		});

		mtv_detail_t_caramasak.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (showing2==true){
					Drawable draw2 = getResources().getDrawable(R.drawable.panah_atas);
					mtv_detail_t_caramasak.setCompoundDrawablesWithIntrinsicBounds(null, null, draw2, null);
					mtv_detail_caramasak.setVisibility(View.VISIBLE);
					showing2 = false;
				}else{
					Drawable draw = getResources().getDrawable(R.drawable.panah_bawah);
					mtv_detail_t_caramasak.setCompoundDrawablesWithIntrinsicBounds(null, null, draw, null);
					mtv_detail_caramasak.setVisibility(View.GONE);
					showing2 =true;
				}
			}
		});

		mtv_detail_judul.setText(resep.getJudulresep(index));
		mtv_detail_alatbahan.setText(resep.getAlatbahan(index));
		miv_detail_gambar.setImageResource(resep.getGambarresep(index));
		mtv_detail_caramasak.setText(resep.getCaramasak(index));

		miv_back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				finish();
				Intent back = new Intent(getApplicationContext(), MainActivity.class);
				back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				back.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				back.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(back);
			}
		});
	}

	public void onBackPressed(){
		finish();;
		Intent back = new Intent(getApplicationContext(), MainActivity.class);
		back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		back.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
		back.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(back);
	}
}
