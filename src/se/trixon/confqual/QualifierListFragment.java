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
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockListFragment;

public class QualifierListFragment extends SherlockListFragment {

	private static Callbacks sDummyCallbacks = new Callbacks() {
		@Override
		public void onItemSelected(int position) {
		}
	};

	private static final String STATE_ACTIVATED_POSITION = "activated_position";
	private int mActivatedPosition = ListView.INVALID_POSITION;
	private Callbacks mCallbacks = sDummyCallbacks;
	private Context mContext;

	public QualifierListFragment() {
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (!(activity instanceof Callbacks)) {
			throw new IllegalStateException("Activity must implement fragment's callbacks.");
		}

		mCallbacks = (Callbacks) activity;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = getActivity();
		setListAdapter(new QulifierAdapter());
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mCallbacks = sDummyCallbacks;
	}

	@Override
	public void onListItemClick(ListView listView, View view, int position, long id) {
		super.onListItemClick(listView, view, position, id);
		mCallbacks.onItemSelected(position);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		if (mActivatedPosition != ListView.INVALID_POSITION) {
			outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
		}
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		if (savedInstanceState != null && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
			setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
		}
	}

	public void setActivatedPosition(int position) {
		if (position == ListView.INVALID_POSITION) {
			getListView().setItemChecked(mActivatedPosition, false);
		} else {
			getListView().setItemChecked(position, true);
		}

		mActivatedPosition = position;
	}

	public void setActivateOnItemClick(boolean activateOnItemClick) {
		getListView().setChoiceMode(activateOnItemClick ? ListView.CHOICE_MODE_SINGLE : ListView.CHOICE_MODE_NONE);
	}

	public interface Callbacks {

		public void onItemSelected(int position);
	}

	private class ItemViewHolder {
		public TextView key;
		public TextView value;
	}

	private class QulifierAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return Item.sItems.size();
		}

		@Override
		public Object getItem(int position) {
			return Item.sItems.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ItemViewHolder itemViewHolder;
			View v = convertView;
			if (v == null) {
				LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = li.inflate(R.layout.list_item, null);
				itemViewHolder = new ItemViewHolder();
				itemViewHolder.key = (TextView) v.findViewById(R.id.key);
				itemViewHolder.value = (TextView) v.findViewById(R.id.value);
				v.setTag(itemViewHolder);
			} else {
				itemViewHolder = (ItemViewHolder) v.getTag();
			}

			itemViewHolder.key.setText(getString(Item.sItems.get(position).getKeyId()));
			ConfQualApplication cqApp = (ConfQualApplication) getActivity().getApplication();
			if (position == 1) {
				itemViewHolder.value.setText(cqApp.getConfigValue(CfgKey.MCC));
			} else if (position == 2) {
				itemViewHolder.value.setText(cqApp.getConfigValue(CfgKey.LO));
			} else if (position == 3) {
				itemViewHolder.value.setText(cqApp.getConfigValue(CfgKey.SW));
			} else if (position == 4) {
				itemViewHolder.value.setText(cqApp.getConfigValue(CfgKey.AW));
			} else if (position == 5) {
				itemViewHolder.value.setText(cqApp.getConfigValue(CfgKey.AH));
			} else {
				itemViewHolder.value.setText(getString(Item.sItems.get(position).getValueId()));
			}

			return v;
		}
	}
}
