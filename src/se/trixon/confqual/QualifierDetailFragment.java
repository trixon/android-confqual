package se.trixon.confqual;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
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
			((TextView) rootView.findViewById(R.id.key)).setText(getString(mItem.getKeyId()));
			((TextView) rootView.findViewById(R.id.value)).setText(getString(mItem.getValueId()));

			String text = convertStreamToString(getResources().openRawResource(mItem.getDescriptionId())).replaceAll("\\s+", " ");
			WebView webView = (WebView) rootView.findViewById(R.id.webView);
			webView.setVerticalScrollBarEnabled(false);
			webView.getSettings().setBuiltInZoomControls(true);
			webView.loadData(text, "text/html", null);
		}

		return rootView;
	}

	private String convertStreamToString(java.io.InputStream is) {
		try {
			return new java.util.Scanner(is).useDelimiter("\\A").next();
		} catch (java.util.NoSuchElementException e) {
			return "";
		}
	}
}
