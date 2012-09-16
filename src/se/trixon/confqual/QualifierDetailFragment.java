package se.trixon.confqual;

import se.trixon.confqual.dummy.DummyContent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

public class QualifierDetailFragment extends SherlockFragment {

	public static final String ARG_ITEM_ID = "item_id";

	DummyContent.DummyItem mItem;

	public QualifierDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments().containsKey(ARG_ITEM_ID)) {
			mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_qualifier_detail, container, false);
		if (mItem != null) {
			((TextView) rootView.findViewById(R.id.qualifier_detail)).setText(mItem.content);
		}
		return rootView;
	}
}
