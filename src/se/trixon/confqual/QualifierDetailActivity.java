package se.trixon.confqual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;

public class QualifierDetailActivity extends SherlockFragmentActivity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.activity_conf_qual, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			NavUtils.navigateUpTo(this, new Intent(this, QualifierListActivity.class));
		} else if (item.getItemId() == R.id.menu_about) {
			((ConfQualApplication) getApplication()).getAboutDialog(this).show();
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qualifier_detail);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		if (savedInstanceState == null) {
			Bundle arguments = new Bundle();
			arguments.putString(QualifierDetailFragment.ARG_ITEM_ID, getIntent().getStringExtra(QualifierDetailFragment.ARG_ITEM_ID));
			QualifierDetailFragment fragment = new QualifierDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction().add(R.id.qualifier_detail_container, fragment).commit();
		}
	}
}
