package se.trixon.confqual;

import android.content.Intent;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;

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
	public void onItemSelected(String id) {
		if (mTwoPane) {
			Bundle arguments = new Bundle();
			arguments.putString(QualifierDetailFragment.ARG_ITEM_ID, id);
			QualifierDetailFragment fragment = new QualifierDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction().replace(R.id.qualifier_detail_container, fragment).commit();

		} else {
			Intent detailIntent = new Intent(this, QualifierDetailActivity.class);
			detailIntent.putExtra(QualifierDetailFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}
	}
}
