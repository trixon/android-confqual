/*
 * Copyright 2012 Patrik Karlsson (http://www.trixon.se)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package se.trixon.confqual;

import se.trixon.confqual.ConfQualApplication.CfgKey;
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

			TextView valueTextView = ((TextView) rootView.findViewById(R.id.value));
			ConfQualApplication cqApp = (ConfQualApplication) getActivity().getApplication();

			if (mItem.getKeyId() == R.string.key_mcc_mnc) {
				valueTextView.setText(cqApp.getConfigValue(CfgKey.MCC));
			} else if (mItem.getKeyId() == R.string.key_locale) {
				valueTextView.setText(cqApp.getConfigValue(CfgKey.LO));
			} else if (mItem.getKeyId() == R.string.key_smallest_width) {
				valueTextView.setText(cqApp.getConfigValue(CfgKey.SW));
			} else if (mItem.getKeyId() == R.string.key_available_width) {
				valueTextView.setText(cqApp.getConfigValue(CfgKey.AW));
			} else if (mItem.getKeyId() == R.string.key_available_height) {
				valueTextView.setText(cqApp.getConfigValue(CfgKey.AH));
			} else {
				valueTextView.setText(getString(mItem.getValueId()));
			}

			String text = convertStreamToString(getResources().openRawResource(mItem.getDescriptionId())).replaceAll("\\s+", " ");
			WebView webView = (WebView) rootView.findViewById(R.id.webView);
			webView.setVerticalScrollBarEnabled(false);
			webView.getSettings().setBuiltInZoomControls(true);
			webView.loadDataWithBaseURL("http://developer.android.com/guide/topics/resources/", text, "text/html", "utf-8", null);
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
