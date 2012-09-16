package se.trixon.confqual;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

public class QualifierDetailFragment extends SherlockFragment {

	public static final String ARG_ITEM_ID = "item_id";

	Item mItem;

	public QualifierDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments().containsKey(ARG_ITEM_ID)) {
			mItem = Item.sItems.get(getArguments().getInt(ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_qualifier_detail, container, false);
		if (mItem != null) {
			((TextView) rootView.findViewById(R.id.qualifier_detail)).setText(mItem.getKeyId());
		}
		return rootView;
	}
}
