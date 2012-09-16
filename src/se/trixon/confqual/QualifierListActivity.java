package se.trixon.confqual;

import android.content.Intent;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class QualifierListActivity extends SherlockFragmentActivity implements QualifierListFragment.Callbacks {

	private boolean mTwoPane;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qualifier_list);

		if (findViewById(R.id.qualifier_detail_container) != null) {
			mTwoPane = true;
			((QualifierListFragment) getSupportFragmentManager().findFragmentById(R.id.qualifier_list)).setActivateOnItemClick(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.activity_conf_qual, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public void onItemSelected(int position) {
		if (mTwoPane) {
			Bundle arguments = new Bundle();
			arguments.putInt(QualifierDetailFragment.ARG_ITEM_ID, position);
			QualifierDetailFragment fragment = new QualifierDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction().replace(R.id.qualifier_detail_container, fragment).commit();

		} else {
			Intent detailIntent = new Intent(this, QualifierDetailActivity.class);
			detailIntent.putExtra(QualifierDetailFragment.ARG_ITEM_ID, position);
			startActivity(detailIntent);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.menu_about) {
			((ConfQualApplication) getApplication()).getAboutDialog(this).show();
		}

		return super.onOptionsItemSelected(item);
	}
}
