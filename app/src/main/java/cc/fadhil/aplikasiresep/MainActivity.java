package cc.fadhil.aplikasiresep;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	RecyclerView vRecyclerView;
	public boolean doubleClick = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		vRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

		RecyclerAdapter adapter = new RecyclerAdapter(this);
		vRecyclerView.setAdapter(adapter);
		vRecyclerView.hasFixedSize();
		vRecyclerView.setLayoutManager(new LinearLayoutManager(this));

	}

	public void onBackPressed(){
		if (doubleClick) {
			super.onBackPressed();
			return;
		}

		this.doubleClick = true;
		Toast.makeText(this, "Untuk keluar, tekan sekali lagi", Toast.LENGTH_SHORT).show();

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				doubleClick=false;
			}
		}, 2000);
	}

}
